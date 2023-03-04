package org.lamp.javacore.tutorial.designpattern.chain;

public class WithdrawalRequest {
	
	private int totalAmout;
	
	public WithdrawalRequest(int totalAmout) {
		this.totalAmout = totalAmout;
	}
	
	public int getTotalAmout() {
		return totalAmout;
	}
}
