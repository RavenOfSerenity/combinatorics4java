package combinatorics4java.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import combinatorics4java.generator.CartesianProduct;

public final class CartesianProductExample {

    public static void main(String[] args) {
	List<List<Character>> elements = new ArrayList<>();
	elements.add(Arrays.asList('1', '2', '3'));
	elements.add(Arrays.asList('a', 'b'));
	elements.add(Arrays.asList('x', 'y', 'z'));
	Iterator<List<Character>> it = CartesianProduct.iterator(elements);
	while (it.hasNext()) {
	    ExampleUtils.printList(it.next());
	}
    }

}
