package org.lamp.javacore.tutorial.designpattern.visitor.traditional;

public class ShoppingCartVisitor implements ItemVisitor<String> {

	@Override
	public String visit(ShoppingCart shoppingCart) {
		return "visit shoppingCart: "+ shoppingCart;
	}

	@Override
	public String visit(Book book) {
		return "visit book: "+ book;
	}

	@Override
	public String visit(Fruit fruit) {
		return "visit fruit: "+ fruit;
	}
}
