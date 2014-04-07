package combinatorics4java;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import combinatorics4java.generator.CartesianProduct;
import combinatorics4java.state.Generator;

@RunWith(Parameterized.class)
public final class CartesianProductGeneratorTest {

    private static final List<List<Character>> elements = TestUtils.getListOfList("abc xy");
    private static final List<List<Character>> twoListResults = TestUtils.getListOfList("ax ay bx by cx cy");

    private String message;
    private List<List<Character>> resultsList;

    public CartesianProductGeneratorTest(String message, List<List<Character>> resultsList) {
	this.message = message;
	this.resultsList = resultsList;
    }

    @Test
    public void testGenerator() {
	Generator<Character> generator = CartesianProduct.iterator(elements);
	TestUtils.areEqual(this.message, generator, this.resultsList);
    }

    @Parameters(name = "{0}")
    public static Iterable<Object[]> data() {
	List<Object[]> data = new ArrayList<>();
	data.add(new Object[] { "Cartesian product test", twoListResults });
	return data;
    }

}
