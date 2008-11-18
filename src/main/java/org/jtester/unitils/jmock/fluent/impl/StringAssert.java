package org.jtester.unitils.jmock.fluent.impl;

import org.hamcrest.Matcher;
import org.hamcrest.text.IsEqualIgnoringCase;
import org.hamcrest.text.StringContains;
import org.hamcrest.text.StringEndsWith;
import org.hamcrest.text.StringStartsWith;
import org.jtester.unitils.jmock.fluent.IStringAssert;

public class StringAssert extends BaseAssert<String, IStringAssert> implements IStringAssert {

	public StringAssert(String value, Class<? extends IStringAssert> clazE) {
		super(value, clazE);
	}

	public StringAssert(Class<String> clazT, Class<? extends IStringAssert> clazE) {
		super(clazT, clazE);
	}

	@Override
	protected StringAssert getInstance() {
		return new StringAssert(String.class, StringAssert.class);
	}

	public IStringAssert contains(String expected) {
		StringContains matcher = new StringContains(expected);
		return (IStringAssert) this.assertThat(matcher);
	}

	public IStringAssert end(String expected) {
		Matcher<String> matcher = StringEndsWith.endsWith(expected);
		return (IStringAssert) this.assertThat(matcher);
	}

	public IStringAssert eqIgnoreCase(String item) {
		Matcher<String> matcher = IsEqualIgnoringCase.equalToIgnoringCase(item);
		return (IStringAssert) this.assertThat(matcher);
	}

	public IStringAssert regular(String regular) {
		// TODO Auto-generated method stub
		return null;
	}

	public IStringAssert start(String expected) {
		Matcher<String> matcher = StringStartsWith.startsWith(expected);
		return (IStringAssert) this.assertThat(matcher);
	}
}
