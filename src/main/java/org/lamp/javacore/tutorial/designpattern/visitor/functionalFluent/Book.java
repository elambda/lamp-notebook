package org.lamp.javacore.tutorial.designpattern.visitor.functionalFluent;

public class Book {
	private String name;

	public Book(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Book{" + "name='" + name + '\'' + '}';
	}
}
