package combinatorics4java.examples;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import combinatorics4java.generator.Enumeration;

public final class EnumerationExample {

    public static void main(String[] args) {
	List<Character> elements = Arrays.asList('a', 'b', 'c', 'd');
	Enumeration<Character> charEnumeration = new Enumeration<>(elements);
	Iterator<List<Character>> it = charEnumeration.iterator(3);
	while (it.hasNext()) {
	    ExampleUtils.printList(it.next());
	}
    }

}
