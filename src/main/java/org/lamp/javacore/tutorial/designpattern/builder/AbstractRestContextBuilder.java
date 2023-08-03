package org.lamp.javacore.tutorial.designpattern.builder;

public abstract class AbstractRestContextBuilder<CTX extends IContext, BUILDER extends AbstractRestContextBuilder<CTX, BUILDER>> {

	protected CTX ctx;

	public AbstractRestContextBuilder(CTX ctx) {
		this.ctx = ctx;
	}


	public BUILDER objectType(String objectType){
		ctx.setObjectType(objectType);
		return (BUILDER) this;
	}

	public CTX build() {
		return ctx;
	}

}
