package combinatorics4java.generator;

import java.util.List;

import combinatorics4java.state.CartesianProductState;
import combinatorics4java.state.Generator;

public final class CartesianProduct {

    private CartesianProduct() {

    }

    public static <E> Generator<E> iterator(List<List<E>> elements) {
	return new CartesianProductState<E>(elements);
    }

}
