package org.jtester.hamcrest.iassert.common.impl;

import org.hamcrest.Matcher;
import org.jtester.hamcrest.iassert.common.intf.IAssert;
import org.jtester.hamcrest.iassert.common.intf.IReflectionAssert;
import org.jtester.hamcrest.matcher.property.PropertyMatcher;
import org.jtester.hamcrest.matcher.property.UnitilsPropertyMatcher;
import org.jtester.hamcrest.matcher.property.UnitilsReflectionMatcher;
import org.unitils.reflectionassert.ReflectionComparatorMode;

public class ReflectionAssert<T, E extends IAssert<T, ?>> extends ObjectContainerAssert<T, E> implements
		IReflectionAssert<E> {

	public ReflectionAssert(Class<? extends IAssert<?, ?>> clazE) {
		super(clazE);
	}

	public ReflectionAssert(T value, Class<? extends IAssert<?, ?>> clazE) {
		super(value, clazE);
	}

	public E reflectionEq(Object expected, ReflectionComparatorMode... modes) {
		UnitilsReflectionMatcher matcher = new UnitilsReflectionMatcher(expected, modes);
		return this.assertThat(matcher);
	}

	public E lenientEq(Object expected) {
		UnitilsReflectionMatcher matcher = new UnitilsReflectionMatcher(expected, new ReflectionComparatorMode[] {
				ReflectionComparatorMode.IGNORE_DEFAULTS, ReflectionComparatorMode.LENIENT_ORDER });
		return this.assertThat(matcher);
	}

	public E propertyEq(String property, Object expected) {
		UnitilsPropertyMatcher matcher = new UnitilsPropertyMatcher(property, expected, null);
		return this.assertThat(matcher);
	}

	public E propertyMatch(String property, Matcher<?> matcher) {
		PropertyMatcher _matcher = new PropertyMatcher(property, matcher);
		return this.assertThat(_matcher);
	}
}
