package combinatorics4java;

import java.util.List;

import org.junit.Test;

import combinatorics4java.generator.CartesianProduct;

public final class CartesianProductTestGenerator {

    private final List<List<Character>> elements = TestUtils.getList("a,b,c", "x,y");
    private final List<List<Character>> twoListResults = TestUtils.getList("a,x", "a,y", "b,x", "b,y",
	    "c,x", "c,y");

    @Test
    public void testGenerators() {
	TestUtils.areEqual("Cartesian product test", CartesianProduct.iterator(elements),
		twoListResults.iterator());
    }

}
