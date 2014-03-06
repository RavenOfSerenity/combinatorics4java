package combinatorics4java.generator;

import java.util.Iterator;
import java.util.List;

import combinatorics4java.state.CartesianProductState;

public final class CartesianProduct {

	private CartesianProduct() {

	}

	public static <E> Iterator<List<E>> iterator(List<List<E>> elements) {
		return new CartesianProductState<E>(elements);
	}

}
