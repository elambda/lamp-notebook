package org.lamp.javacore.tutorial.designpattern.visitor.functionalFluent;

public class Fruit  {

	private String name;

	public Fruit(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Fruit{" + "name='" + name + '\'' + '}';
	}
}
