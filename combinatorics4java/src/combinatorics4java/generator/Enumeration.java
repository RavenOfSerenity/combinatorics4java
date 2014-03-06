package combinatorics4java.generator;

import java.util.Iterator;
import java.util.List;

import combinatorics4java.state.EnumerationState;

public final class Enumeration<E> implements Iterable<List<E>> {

	private List<E> elements;
	private int size;

	public Enumeration(List<E> elements, int size) {
		assert (elements != null && elements.size() > 0);
		assert (size > 0);
		this.elements = elements;
		this.size = size;
	}

	@Override
	public Iterator<List<E>> iterator() {
		return new EnumerationState<>(elements, size);
	}

}
