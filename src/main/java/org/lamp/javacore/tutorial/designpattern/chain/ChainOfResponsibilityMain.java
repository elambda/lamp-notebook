package org.lamp.javacore.tutorial.designpattern.chain;

import org.lamp.javacore.tutorial.designpattern.chain.impl.FiftyWithdrawalHandler;
import org.lamp.javacore.tutorial.designpattern.chain.impl.TenWithdrawalHandler;
import org.lamp.javacore.tutorial.designpattern.chain.impl.TwentyWithdrawalHandler;

public class ChainOfResponsibilityMain {
	public static void main(String[] args) {
		WithdrawalHandler tenDollarHandler = new TenWithdrawalHandler();
		WithdrawalHandler twentyDollarHandler = new TwentyWithdrawalHandler();
		WithdrawalHandler fiftyDollarHandler = new FiftyWithdrawalHandler();
		
		// set the chain of responsibility
		tenDollarHandler.setNext(twentyDollarHandler);
		twentyDollarHandler.setNext(fiftyDollarHandler);
		
		// simulate withdrawal requests
		WithdrawalRequest request1 = new WithdrawalRequest(30);
		WithdrawalRequest request2 = new WithdrawalRequest(80);
		WithdrawalRequest request3 = new WithdrawalRequest(125);
		
		tenDollarHandler.handle(request1);
		System.out.println();
		tenDollarHandler.handle(request2);
		System.out.println();
		tenDollarHandler.handle(request3);
	}
}