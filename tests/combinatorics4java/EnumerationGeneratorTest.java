package combinatorics4java;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import combinatorics4java.generator.Enumeration;

public final class EnumerationGeneratorTest {

    private final String name = "Enumeration";
    private final List<Character> elements = Arrays.asList('a', 'b', 'c');
    private List<List<Character>> sizeOneResults = TestUtils.getList("a", "b", "c");
    private List<List<Character>> sizeTwoResults = TestUtils.getList("aa", "ab", "ac", "ba", "bb",
	    "bc", "ca", "cb", "cc");

    @Test
    public void testGenerators() {
	Enumeration<Character> enumeration = new Enumeration<>(elements);
	TestUtils.areEqual(TestUtils.getMessage(name, 1), enumeration.iterator(1), sizeOneResults);
	TestUtils.areEqual(TestUtils.getMessage(name, 1), enumeration.iterator(2), sizeTwoResults);
    }

    public String getMessage(int size) {
	return String.format("Combination size %d iterator", size);
    }

}
