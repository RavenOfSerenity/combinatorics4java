package combinatorics4java;

import java.util.List;

import org.junit.Test;

import combinatorics4java.generator.CartesianProduct;

public final class CartesianProductTestGenerator {

    private final List<List<Character>> elements = TestUtils.getList("abc", "xy");
    private final List<List<Character>> twoListResults = TestUtils.getList("ax", "ay", "bx", "by",
	    "cx", "cy");

    @Test
    public void testGenerators() {
	TestUtils.areEqual("Cartesian product test", CartesianProduct.iterator(elements),
		twoListResults);
    }

}
