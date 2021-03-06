package org.jtester.hamcrest.iassert.common.impl;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.collection.IsIn;
import org.hamcrest.core.AllOf;
import org.hamcrest.core.AnyOf;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.jtester.hamcrest.iassert.common.intf.IAssert;
import org.mockito.internal.matchers.Any;
import org.mockito.internal.matchers.NotNull;
import org.mockito.internal.matchers.Null;
import org.mockito.internal.matchers.Same;

public class BaseAssert<T, E extends IAssert<T, ?>> extends Assert<T, E> implements IAssert<T, E> {
	public BaseAssert() {
		super();
	}

	public BaseAssert(Class<? extends IAssert<?, ?>> clazE) {
		super(clazE);
	}

	public BaseAssert(T value, Class<? extends IAssert<?, ?>> clazE) {
		super(value, clazE);
	}

	public E isEqualTo(T expected) {
		Matcher<T> matcher = IsEqual.equalTo(expected);
		return this.assertThat(matcher);
	}

	public E notEqualTo(T expected) {
		Matcher<T> matcher = IsNot.not(IsEqual.equalTo(expected));
		return this.assertThat(matcher);
	}

	public E clazIs(Class<?> expected) {
		Matcher<?> matcher = Is.is(expected);
		return this.assertThat(matcher);
	}

	public E is(Matcher<T> matcher) {
		Matcher<T> _matcher = Is.is(matcher);
		return this.assertThat(_matcher);
	}

	public E not(Matcher<T> matcher) {
		Matcher<T> _matcher = IsNot.not(matcher);
		return this.assertThat(_matcher);
	}

	public E allOf(IAssert<?, ?> matcher1, IAssert<?, ?> matcher2, IAssert<?, ?>... matchers) {
		List<Matcher<?>> list = list(matcher1, matcher2, matchers);
		Matcher<?> matcher = AllOf.allOf(list);
		return this.assertThat(matcher);
	}

	public E allOf(Iterable<IAssert<?, ?>> matchers) {
		List<Matcher<?>> list = list(matchers);
		Matcher<?> matcher = AllOf.allOf(list);
		return this.assertThat(matcher);
	}

	public E anyOf(IAssert<?, ?> matcher1, IAssert<?, ?> matcher2, IAssert<?, ?>... matchers) {
		List<Matcher<?>> list = list(matcher1, matcher2, matchers);
		Matcher<?> matcher = AnyOf.anyOf(list);
		return this.assertThat(matcher);
	}

	private List<Matcher<?>> list(IAssert<?, ?> matcher1, IAssert<?, ?> matcher2, IAssert<?, ?>... matchers) {
		List<Matcher<?>> list = new ArrayList<Matcher<?>>();
		list.add(matcher1);
		list.add(matcher2);
		if (matchers != null) {
			for (IAssert<?, ?> matcher : matchers) {
				list.add(matcher);
			}
		}
		return list;
	}

	private List<Matcher<?>> list(Iterable<IAssert<?, ?>> matchers) {
		List<Matcher<?>> list = new ArrayList<Matcher<?>>();
		if (matchers != null) {
			for (IAssert<?, ?> matcher : matchers) {
				list.add(matcher);
			}
		}
		return list;
	}

	public E anyOf(Iterable<IAssert<?, ?>> matchers) {
		List<Matcher<?>> list = list(matchers);
		Matcher<?> matcher = AnyOf.anyOf(list);
		return this.assertThat(matcher);
	}

	public E in(T... values) {
		Matcher<T> matcher = IsIn.isOneOf(values);
		return this.assertThat(matcher);
	}

	public E notIn(T... values) {
		Matcher<T> _matcher = IsNot.not(IsIn.isOneOf(values));
		return this.assertThat(_matcher);
	}

	public E same(T value) {
		Matcher<?> _matcher = new Same(value);
		return this.assertThat(_matcher);
	}

	public E any() {
		Matcher<?> _matcher = Any.ANY;
		return this.assertThat(_matcher);
	}

	public E isNull() {
		Matcher<?> _matcher = Null.NULL;
		return this.assertThat(_matcher);
	}

	public E notNull() {
		Matcher<?> _matcher = NotNull.NOT_NULL;
		return this.assertThat(_matcher);
	}
}
