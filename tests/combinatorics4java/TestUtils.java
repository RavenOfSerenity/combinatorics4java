package combinatorics4java;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class TestUtils {

    private TestUtils() {

    }

    public static List<List<Character>> getList(String... result) {
	List<List<Character>> list = new ArrayList<>();
	for (String row : result) {
	    List<Character> rowList = new ArrayList<>();
	    for (String part : row.split(",")) {
		rowList.add(part.charAt(0));
	    }
	    list.add(rowList);
	}
	return list;
    }

    public static <E> void areEqual(String message, Iterator<List<E>> generatorIterator,
	    Iterator<List<E>> resultsIterator) {

	while (resultsIterator.hasNext()) {
	    assertTrue(generatorIterator.hasNext());
	    assertThat(message, resultsIterator.next(), is(generatorIterator.next()));
	}
	assertTrue(!generatorIterator.hasNext());

    }

    public static String getMessage(String name, int size) {
	return String.format("%s with iterator of size %d", name, size);
    }
}
