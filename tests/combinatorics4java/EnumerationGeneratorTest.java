package combinatorics4java;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import combinatorics4java.framework.CommonCombinatoricTestDataDeserializer;
import combinatorics4java.framework.TestDataDeserializer;
import combinatorics4java.framework.TestUtils;
import combinatorics4java.generator.Enumeration;
import combinatorics4java.state.Generator;

@RunWith(Parameterized.class)
public final class EnumerationGeneratorTest {

    private static final TestDataDeserializer<Character, List<Character>> dataDeserializer = new CommonCombinatoricTestDataDeserializer();
    private static final String testDataFilename = "EnumerationData.txt";

    private Enumeration<Character> enumeration;
    private int size;
    private List<List<Character>> resultsList;

    public EnumerationGeneratorTest(String name, List<Character> elements,
	    List<List<Character>> resultsList) {
	this.enumeration = new Enumeration<>(elements);
	this.size = resultsList.get(0).size();
	this.resultsList = resultsList;
    }

    @Test
    public void testGenerators() {
	Generator<Character> generator = enumeration.iterator(this.size);
	TestUtils.areEqual(generator, this.resultsList);
    }

    @Parameters(name = "{0}")
    public static Iterable<Object[]> data() {
	EnumerationGeneratorTest.dataDeserializer.fromFile(testDataFilename);
	return dataDeserializer.getTestData();
    }
}
