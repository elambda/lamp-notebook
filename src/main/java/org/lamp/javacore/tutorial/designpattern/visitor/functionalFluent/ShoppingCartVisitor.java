package org.lamp.javacore.tutorial.designpattern.visitor.functionalFluent;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartVisitor {

	public static void main(String[] args) {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setBook(new Book("Think in Java"));
		shoppingCart.setFruit(new Fruit("Apple"));

//		VisitorInitializer<String> visitorInitializer = builder -> {
//			builder.register(ShoppingCart.class, cart -> "visited shoppingCart " + cart);
//			builder.register(Book.class, book -> "visited book " + book);
//			builder.register(Fruit.class, fruit -> "visited fruit " + fruit);
//		};

		VisitorInitializer<String> visitorInitializer = ItemVisitor
			                                                .<ShoppingCart, String>forType(ShoppingCart.class).execute((ShoppingCart cart) ->  "visited data " + cart)
			                                                .forType(Book.class).execute((Book book) ->  "visited data " + book)
			                                                .forType(Fruit.class).execute((Fruit fruit) ->  "visited data " + fruit)
			;

		ItemVisitor<String> visitor = ItemVisitor.of(visitorInitializer);

		@SuppressWarnings("all")
		VisitableFactory<ShoppingCart> visitableFactory = VisitableFactory.visiting(ShoppingCart.class)
			                                         .collectsFrom(
																								 cart -> cart,
																								 cart -> cart.getBook(),
																								 cart -> cart.getFruit()
			                                         );
		Visitable<ShoppingCart> visitable = visitableFactory.makeVisitable(shoppingCart);

		System.out.println("============visitable.accept => output style 1===========");
		String acceptWithString = visitable.accept(visitor, Collectors.joining(" -- "));
		System.out.println(acceptWithString);

		System.out.println("============visitable.accept => output style 2===========");
		List<String> acceptWithList = visitable.accept(visitor, Collectors.toList());
		acceptWithList.forEach(System.out::println);

		System.out.println("============visitor.visit => output style 1===========");
		String visit = visitor.visit(shoppingCart);
		System.out.println(visit);
	}

}
