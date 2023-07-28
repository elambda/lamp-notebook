package org.lamp.javacore.tutorial.designpattern.visitor.traditional;

public class Book implements ItemElement {
	private String name;

	public Book(String name) {
		this.name = name;
	}

	@Override
	public <R> R accept(ItemVisitor<R> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Book{" + "name='" + name + '\'' + '}';
	}
}
