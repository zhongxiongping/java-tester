package org.jtester.unitils.jmock.fluent;

import org.hamcrest.Matcher;
import org.jmock.Expectations;

public interface IAssert<T, E extends IAssert<T, ?>> {
	public E eq(T expected);

	public E notEq(T expected);

	public E in(T... values);

	public E notIn(T... values);

	public E type(Class<?> claz);

	public E is(Matcher<T> matcher);

	public E not(Matcher<T> matcher);

	public E and(Matcher<?>... matchers);

	public E and(Iterable<Matcher<?>> matchers);

	public E or(Matcher<?>... matchers);

	public E or(Iterable<Matcher<?>> matchers);

	public T match(Expectations expectations);

	// public E same(T value);
}
