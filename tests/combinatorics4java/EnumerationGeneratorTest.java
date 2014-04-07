package combinatorics4java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import combinatorics4java.generator.Enumeration;
import combinatorics4java.state.Generator;

@RunWith(Parameterized.class)
public final class EnumerationGeneratorTest {

    private static final String name = "Enumeration";
    private static final List<Character> elements = Arrays.asList('a', 'b', 'c');
    private static final Enumeration<Character> enumeration = new Enumeration<>(elements);
    private static final List<List<Character>> sizeOneResults = TestUtils.getListOfList("a b c");
    private static final List<List<Character>> sizeTwoResults = TestUtils.getListOfList("aa ab ac ba bb bc ca cb cc");

    private String message;
    private int size;
    private List<List<Character>> resultsList;

    public EnumerationGeneratorTest(String message, int size, List<List<Character>> resultsList) {
	this.message = message;
	this.size = size;
	this.resultsList = resultsList;
    }

    @Test
    public void testGenerators() {
	Generator<Character> generator = enumeration.iterator(this.size);
	TestUtils.areEqual(this.message, generator, this.resultsList);
    }

    @Parameters(name = "{0}")
    public static Iterable<Object[]> data() {
	List<Object[]> data = new ArrayList<>();
	data.add(new Object[] { TestUtils.getMessage(name, 1), 1, sizeOneResults });
	data.add(new Object[] { TestUtils.getMessage(name, 2), 2, sizeTwoResults });
	return data;
    }
}
