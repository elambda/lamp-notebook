package org.lamp.javacore.tutorial.designpattern.chain.impl;

import org.lamp.javacore.tutorial.designpattern.chain.WithdrawalHandler;
import org.lamp.javacore.tutorial.designpattern.chain.WithdrawalRequest;

public class FiftyWithdrawalHandler implements WithdrawalHandler {
	
	public static final int DENOMINATION = 50;
	private WithdrawalHandler nextHandler;
	
	@Override
	public void setNext(WithdrawalHandler next) {
		this.nextHandler = next;
	}
	
	@Override
	public void handle(WithdrawalRequest request) {
		if (request.getTotalAmout() >= DENOMINATION) {
			int numBills = request.getTotalAmout() / DENOMINATION;
			int remainder = request.getTotalAmout() % DENOMINATION;
			showInfo(numBills, DENOMINATION);
			if (remainder != 0) {
				nextHandler.handle(new WithdrawalRequest(remainder));
			}
		} else {
			System.err.println("Unable to dispense " + request.getTotalAmout() + " dollars");
		}
	}
	
}
