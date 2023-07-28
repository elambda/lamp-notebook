package org.lamp.javacore.tutorial.designpattern.visitor.traditional;


import java.util.List;
import java.util.stream.Collectors;

public class VisitorMain {

	public static void main(String[] args) {
		ShoppingCartVisitor visitor = new ShoppingCartVisitor();

		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setBook(new Book("Think in Java"));
		shoppingCart.setFruit(new Fruit("Apple"));

		String acceptAsString = shoppingCart.accept(visitor, Collectors.joining(" -- "));
		List<String> acceptAsList = shoppingCart.accept(visitor, Collectors.toList());

		System.out.println("shoppingList :\n" + acceptAsString);
		System.out.println("=============");
		acceptAsList.forEach(System.out::println);
	}
}
