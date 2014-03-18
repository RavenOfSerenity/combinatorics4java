package combinatorics4java;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import combinatorics4java.generator.Combination;

public final class CombinationGeneratorTest {

    private final String name = "Combination";
    private final List<Character> elements = Arrays.asList('a', 'b', 'c');
    private final List<List<Character>> sizeOneResults = TestUtils.getList("a", "b", "c");
    private final List<List<Character>> sizeTwoResults = TestUtils.getList("ab", "ac", "bc");
    private final List<List<Character>> sizeThreeResults = TestUtils.getList("abc");

    @Test
    public void testGenerators() {
	Combination<Character> enumeration = new Combination<>(elements);
	TestUtils.areEqual(TestUtils.getMessage(name, 1), enumeration.iterator(1), sizeOneResults);
	TestUtils.areEqual(TestUtils.getMessage(name, 2), enumeration.iterator(2), sizeTwoResults);
	TestUtils.areEqual(TestUtils.getMessage(name, 3), enumeration.iterator(3), sizeThreeResults);
    }
}
