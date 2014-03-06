package combinatorics4java.examples;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import combinatorics4java.generator.Enumeration;

public class EnumerationExample {

	private static <E> void printList(List<E> combination) {
		System.out.print("{");
		for (int i = 0; i < combination.size() - 1; i++) {
			System.out.print(combination.get(i));
			System.out.print(",");
		}
		System.out.print(combination.get(combination.size() - 1));
		System.out.println("}");
	}

	public static void main(String[] args) {
		List<Character> elements = Arrays.asList('a', 'b', 'c', 'd');
		Enumeration charEnumeration = new Enumeration(elements, 3);
		Iterator<List<Character>> it = charEnumeration.iterator();
		while (it.hasNext()) {
			printList(it.next());
		}
	}

}
