package combinatorics4java.examples;

import java.util.List;

public final class ExampleUtils {

	static <E> void printList(List<E> combination) {
		System.out.print("{");
		for (int i = 0; i < combination.size() - 1; i++) {
			System.out.print(combination.get(i));
			System.out.print(",");
		}
		System.out.print(combination.get(combination.size() - 1));
		System.out.println("}");
	}

}
