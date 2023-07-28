package org.lamp.javacore.tutorial.designpattern.visitor.traditional;

public interface ItemElement {

	<R> R accept(ItemVisitor<R> visitor);
}
