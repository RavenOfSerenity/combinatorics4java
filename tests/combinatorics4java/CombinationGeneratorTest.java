package combinatorics4java;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import combinatorics4java.framework.CommonCombinatoricTestDataDeserializer;
import combinatorics4java.framework.TestDataDeserializer;
import combinatorics4java.framework.TestUtils;
import combinatorics4java.generator.Combination;
import combinatorics4java.state.Generator;

@RunWith(Parameterized.class)
public final class CombinationGeneratorTest {

    private static final String name = "Combination";
    /*
     * private static final List<Character> elements = TestUtils.getList("abc");
     * private static final Combination<Character> combination = new
     * Combination<>(elements); private static final List<List<Character>>
     * sizeOneResults = TestUtils.getListOfList("a b c"); private static final
     * List<List<Character>> sizeTwoResults =
     * TestUtils.getListOfList("ab ac bc"); private static final
     * List<List<Character>> sizeThreeResults = TestUtils.getListOfList("abc");
     */

    private static final TestDataDeserializer<Character, List<Character>> dataDeserializer = new CommonCombinatoricTestDataDeserializer();
    private static final String testDataFilename = "CombinationData.txt";

    private Combination<Character> combination;
    private int size;
    private List<List<Character>> resultsList;

    public CombinationGeneratorTest(String name, List<Character> elements,
	    List<List<Character>> resultsList) {
	this.combination = new Combination<>(elements);
	this.size = resultsList.get(0).size();
	this.resultsList = resultsList;
    }

    @Test
    public void testGenerator() {
	Generator<Character> generator = combination.iterator(this.size);
	TestUtils.areEqual(generator, this.resultsList);
    }

    @Parameters(name = "{0}")
    public static Iterable<Object[]> data() {
	CombinationGeneratorTest.dataDeserializer.fromFile(testDataFilename);
	return dataDeserializer.getTestData();
    }

}
