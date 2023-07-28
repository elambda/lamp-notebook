package org.lamp.javacore.tutorial.designpattern.visitor.functionalFluent;


public class ShoppingCart {
	private Book book;
	private Fruit fruit;


	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Fruit getFruit() {
		return fruit;
	}

	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}

	@Override
	public String toString() {
		return "ShoppingCart{" + "book=" + book + ", fruit=" + fruit + '}';
	}
}
