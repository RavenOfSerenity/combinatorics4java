package combinatorics4java.framework;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import combinatorics4java.state.Generator;

public final class TestUtils {

    private final static String TEST_DATA_PREFIX = "../data/";

    private TestUtils() {

    }

    public static List<List<Character>> getListOfList(String serializedList) {
	String[] serializedRows = serializedList.split(" ");
	return TestUtils.getListOfList(serializedRows);
    }

    public static List<List<Character>> getListOfList(String... seralizedRows) {
	List<List<Character>> list = new ArrayList<>();
	for (String row : seralizedRows) {
	    List<Character> rowList = TestUtils.getList(row);
	    list.add(rowList);
	}
	return list;
    }

    public static List<Character> getList(String row) {
	List<Character> rowList = new ArrayList<>();
	for (int i = 0; i < row.length(); i++) {
	    rowList.add(row.charAt(i));
	}
	return rowList;
    }

    public static <E> void areEqual(Generator<E> generator, List<List<E>> resultsList) {
	Iterator<List<E>> resultsIterator = resultsList.iterator();
	assertTrue(resultsList.size() == generator.size());
	while (resultsIterator.hasNext()) {
	    assertThat(resultsIterator.next(), is(generator.next()));
	}

    }

    public static String getMessage(String name, int size) {
	return String.format("%s of size %d", name, size);
    }

    public static InputStream getTestDataStream(String filename) {
	return TestUtils.class.getResourceAsStream(TEST_DATA_PREFIX + filename);
    }
}
