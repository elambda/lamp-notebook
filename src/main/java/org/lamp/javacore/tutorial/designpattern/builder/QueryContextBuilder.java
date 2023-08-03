package org.lamp.javacore.tutorial.designpattern.builder;

public class QueryContextBuilder extends AbstractRestContextBuilder<QueryContext, QueryContextBuilder>{

	public QueryContextBuilder() {
		super(new QueryContext());
	}

	public QueryContextBuilder queryOptions(String options){
		return this;
	}
}
