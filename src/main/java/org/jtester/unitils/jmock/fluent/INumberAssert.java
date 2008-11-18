package org.jtester.unitils.jmock.fluent;

public interface INumberAssert<T extends Number & Comparable<T>, E extends INumberAssert<T, E>> extends IAssert<T, E> {
	public E lt(int max);

	public E leq(int max);

	public E gt(int min);

	public E geq(int min);
}
