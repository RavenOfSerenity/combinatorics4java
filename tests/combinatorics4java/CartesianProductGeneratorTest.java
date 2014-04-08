package combinatorics4java;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import combinatorics4java.framework.CartesianProductTestDataDeserializer;
import combinatorics4java.framework.TestDataDeserializer;
import combinatorics4java.framework.TestUtils;
import combinatorics4java.generator.CartesianProduct;
import combinatorics4java.state.Generator;

@RunWith(Parameterized.class)
public final class CartesianProductGeneratorTest {

    // private static final List<List<Character>> elements =
    // TestUtils.getListOfList("abc xy");
    private static final List<List<Character>> twoListResults = TestUtils.getListOfList("ax ay bx by cx cy");

    private static final TestDataDeserializer<List<Character>, List<Character>> dataDeserializer = new CartesianProductTestDataDeserializer();
    private static final String testDataFilename = "CartesianProductData.txt";

    private List<List<Character>> elements;
    private List<List<Character>> resultsList;

    public CartesianProductGeneratorTest(String name, List<List<Character>> elements,
	    List<List<Character>> resultsList) {
	this.elements = elements;
	this.resultsList = resultsList;
    }

    @Test
    public void testGenerator() {
	Generator<Character> generator = CartesianProduct.iterator(elements);
	TestUtils.areEqual(generator, this.resultsList);
    }

    @Parameters(name = "{0}")
    public static Iterable<Object[]> data() {
	dataDeserializer.fromFile(testDataFilename);
	return dataDeserializer.getTestData();
    }

}
