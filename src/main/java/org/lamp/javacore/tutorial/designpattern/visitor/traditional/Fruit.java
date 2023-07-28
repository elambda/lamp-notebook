package org.lamp.javacore.tutorial.designpattern.visitor.traditional;

public class Fruit implements ItemElement {

	private String name;

	public Fruit(String name) {
		this.name = name;
	}

	@Override
	public <R> R accept(ItemVisitor<R> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Fruit{" + "name='" + name + '\'' + '}';
	}
}
