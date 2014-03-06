package combinatorics4java.generator;

import java.util.Iterator;
import java.util.List;

import combinatorics4java.state.EnumerationState;

public final class Enumeration<E> {

	private List<E> elements;

	public Enumeration(List<E> elements) {
		assert (elements != null && elements.size() > 0);
		this.elements = elements;
	}

	public Iterator<List<E>> iterator(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Invalid size specified");
		}
		return new EnumerationState<>(elements, size);
	}

}
