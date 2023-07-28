package org.lamp.javacore.tutorial.designpattern.visitor.traditional;

public interface ItemVisitor<R> {
	R visit(ShoppingCart shoppingCart);

	R visit(Book book);

	R visit(Fruit fruit);
}
