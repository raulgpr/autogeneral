package com.autogeneral.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Stack;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.autogeneral.test.exception.ToDoNotFoundException;
import com.autogeneral.test.models.BalanceTestResult;
import com.autogeneral.test.models.ToDoItem;
import com.autogeneral.test.models.ToDoItemAddRequest;
import com.autogeneral.test.models.ToDoItemUpdateRequest;

@RestController
@Validated
public class TestController {
	
	private HashMap<Integer,ToDoItem> map = new HashMap<Integer,ToDoItem>();
	private int id = 1;

	@RequestMapping(method=RequestMethod.GET, path="tasks/validateBrackets")
	public BalanceTestResult validateBrackets(@Valid @Size(max=50) @RequestParam(required=true) String input) {
		BalanceTestResult result = new BalanceTestResult(input);
		result.setBalanced(balancedBrackets(input));
		
		return result;
	}
	
	@RequestMapping(method=RequestMethod.POST, path="todo")
	public ToDoItem createToDo(@RequestBody ToDoItemAddRequest body) {
		ToDoItem item = new ToDoItem();
		
		item.setId(this.id);
		item.setText(body.getText());
		item.setCreatedAt(new Date().toString());
		item.setIsCompleted(false);
		map.put(this.id++, item);
		
		return item;
	}
	
	@RequestMapping(method=RequestMethod.GET, path="todo/{id}")
	public ToDoItem getToDoById(@PathVariable(value="id", required=true) int id) {
		
		ToDoItem item = map.get(id);
		if (item == null) {
			throw new ToDoNotFoundException(Integer.toString(id));
		}
		
		return item;
	}
	
	@RequestMapping(method=RequestMethod.PATCH, path="todo/{id}")
	public ToDoItem updateToDo(@PathVariable int id, @RequestBody ToDoItemUpdateRequest body) {
		
		ToDoItem item = map.get(id);
		if (item == null) {
			throw new ToDoNotFoundException(Integer.toString(id));
		} else {
			item.setText(body.getText());
			item.setCreatedAt(new Date().toString());
			map.remove(id);
			map.put(id, item);
		}
		
		return item;
	}

	
    public static boolean balancedBrackets(String s) {
        Stack<Character> stack  = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{' ) {     
                stack.push(c);
            } else if(c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }           
            } else if (c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

}
