package combinatorics4java.generator;

import java.util.List;

import combinatorics4java.state.EnumerationState;
import combinatorics4java.state.Generator;

public final class Enumeration<E> {

    private List<E> elements;

    public Enumeration(List<E> elements) {
	this.elements = elements;
    }

    public Generator<E> iterator(int size) {
	return new EnumerationState<>(elements, size);
    }

}
