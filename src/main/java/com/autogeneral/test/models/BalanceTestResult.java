package com.autogeneral.test.models;

public class BalanceTestResult {
	private String input;
	private boolean isBalanced;
	
	public BalanceTestResult(String input) {
		super();
		this.input = input;
	}

	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public boolean isBalanced() {
		return isBalanced;
	}
	public void setBalanced(boolean isBalanced) {
		this.isBalanced = isBalanced;
	}
	
	@Override
	public String toString() {
		return "BalanceTestResult [input=" + input + ", isBalanced=" + isBalanced + "]";
	}
}
