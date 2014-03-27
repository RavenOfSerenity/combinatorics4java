package combinatorics4java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import combinatorics4java.generator.Combination;
import combinatorics4java.state.Generator;

@RunWith(Parameterized.class)
public final class CombinationGeneratorTest {

    private static final String name = "Combination";
    private static final List<Character> elements = Arrays.asList('a', 'b', 'c');
    private static final Combination<Character> combination = new Combination<>(elements);
    private static final List<List<Character>> sizeOneResults = TestUtils.getList("a", "b", "c");
    private static final List<List<Character>> sizeTwoResults = TestUtils.getList("ab", "ac", "bc");
    private static final List<List<Character>> sizeThreeResults = TestUtils.getList("abc");

    private String message;
    private int size;
    private List<List<Character>> resultsList;

    public CombinationGeneratorTest(String message, int size, List<List<Character>> resultsList) {
	this.message = message;
	this.size = size;
	this.resultsList = resultsList;
    }

    @Test
    public void testGenerator() {
	Generator<Character> generator = combination.iterator(this.size);
	TestUtils.areEqual(this.message, generator, this.resultsList);
    }

    @Parameters(name = "{0}")
    public static Iterable<Object[]> data() {
	List<Object[]> data = new ArrayList<>();
	data.add(new Object[] { TestUtils.getMessage(name, 1), 1, sizeOneResults });
	data.add(new Object[] { TestUtils.getMessage(name, 2), 2, sizeTwoResults });
	data.add(new Object[] { TestUtils.getMessage(name, 3), 3, sizeThreeResults });
	return data;
    }

}
