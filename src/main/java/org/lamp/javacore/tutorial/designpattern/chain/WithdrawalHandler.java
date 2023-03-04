package org.lamp.javacore.tutorial.designpattern.chain;

public interface WithdrawalHandler {
	
	void setNext(WithdrawalHandler next);
	
	void handle(WithdrawalRequest request);
	
	default void showInfo(int numBills, int denomination) {
		 System.out.printf("Dispensing %s $%d bills", numBills, denomination);
	}
}
