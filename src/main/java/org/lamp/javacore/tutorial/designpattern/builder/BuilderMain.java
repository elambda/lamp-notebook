package org.lamp.javacore.tutorial.designpattern.builder;

public class BuilderMain {

	public static void main(String[] args) {
		QueryContext queryContext = new QueryContextBuilder().objectType("QueryModel").queryOptions("").build();
		EditContext editContext = new EditContextBuilder().objectType("EditModel").editOptions("").build();
	}
}
