package org.jtester.hamcrest.iassert.object.impl;

import org.jtester.hamcrest.iassert.common.impl.ComparableAssert;
import org.jtester.hamcrest.iassert.common.intf.IAssert;
import org.jtester.hamcrest.iassert.object.intf.INumberAssert;

public class NumberAssert<T extends Number & Comparable<T>, E extends INumberAssert<T, ?>> extends
		ComparableAssert<T, E> implements INumberAssert<T, E> {

	public NumberAssert(Class<? extends IAssert<?, ?>> clazE) {
		super(clazE);
	}

	public NumberAssert(T value, Class<? extends IAssert<?, ?>> clazE) {
		super(value, clazE);
	}
}
