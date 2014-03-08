package combinatorics4java.examples;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import combinatorics4java.generator.Combination;

public final class CombinationExample {

    public static void main(String[] args) {
	List<Character> elements = Arrays.asList('1', '2', '3', '4', '5');
	Combination<Character> charCombination = new Combination<>(elements);
	Iterator<List<Character>> it = charCombination.iterator(3);
	while (it.hasNext()) {
	    ExampleUtils.printList(it.next());
	}

    }
}
