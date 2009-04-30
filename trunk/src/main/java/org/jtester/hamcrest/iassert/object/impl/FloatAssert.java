package org.jtester.hamcrest.iassert.object.impl;

import org.jtester.hamcrest.iassert.object.IFloatAssert;

public class FloatAssert extends NumberAssert<Float, IFloatAssert> implements
		IFloatAssert {
	public FloatAssert() {
		super(IFloatAssert.class);
	}

	public FloatAssert(Float f) {
		super(f, IFloatAssert.class);
	}
}