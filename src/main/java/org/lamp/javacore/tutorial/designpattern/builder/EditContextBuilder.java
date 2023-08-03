package org.lamp.javacore.tutorial.designpattern.builder;

public class EditContextBuilder extends AbstractRestContextBuilder<EditContext, EditContextBuilder> {

	public EditContextBuilder() {
		super(new EditContext());
	}

	public EditContextBuilder editOptions(String options){
		return this;
	}
}
