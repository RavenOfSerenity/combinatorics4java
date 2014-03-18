package combinatorics4java.generator;

import java.util.List;

import combinatorics4java.state.CombinationState;
import combinatorics4java.state.Generator;

public final class Combination<E> {

    private List<E> elements;

    public Combination(List<E> elements) {
	this.elements = elements;
    }

    public Generator<E> iterator(int size) {
	return new CombinationState<>(elements, size);
    }

}
