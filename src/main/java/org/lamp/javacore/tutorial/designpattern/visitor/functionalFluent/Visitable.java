package org.lamp.javacore.tutorial.designpattern.visitor.functionalFluent;

import java.util.stream.Collector;
import java.util.stream.Stream;

public interface Visitable<T> {

	Stream<Object> get();

	default <R, RR> RR accept(ItemVisitor<R> visitor, Collector<? super R, ?, RR> collector) {
		return get().map(visitor::visit)
			       .collect(collector);
	}
}
