package org.lamp.javacore.tutorial.designpattern.visitor.traditional;


import java.util.stream.Collector;
import java.util.stream.Stream;

public class ShoppingCart {

	private Book book;
	private Fruit fruit;


	public <R, RR> RR accept(ItemVisitor<R> visitor, Collector<? super R, ? extends Object, RR> collector) {
		R r1 = this.book.accept(visitor);
		R r2 = this.fruit.accept(visitor);
		R r3 = visitor.visit(this);
		return Stream.of(r1,r2,r3).collect(collector);
	}

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
