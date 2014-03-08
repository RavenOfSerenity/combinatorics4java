package combinatorics4java.generator;

import java.util.Iterator;
import java.util.List;

import combinatorics4java.state.EnumerationState;

public final class Enumeration<E> {

	private List<E> elements;

	public Enumeration(List<E> elements) {
		this.elements = elements;
	}

	public Iterator<List<E>> iterator(int size) {
		return new EnumerationState<>(elements, size);
	}

}
