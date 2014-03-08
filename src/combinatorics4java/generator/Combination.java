package combinatorics4java.generator;

import java.util.Iterator;
import java.util.List;

import combinatorics4java.state.CombinationState;

public final class Combination<E> {

    private List<E> elements;

    public Combination(List<E> elements) {
	this.elements = elements;
    }

    public Iterator<List<E>> iterator(int size) {
	return new CombinationState<>(elements, size);
    }

}
