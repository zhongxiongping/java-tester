package org.jtester.hamcrest;

import java.util.Collection;

public interface IArrayAssert<T, E extends IArrayAssert<T, ?>> extends IAssert<T, E> {
	E hasItems(T item, T... items);

	E hasItems(Collection collection);
}