package combinatorics4java.framework;

import java.util.List;

public final class CartesianProductTestDataDeserializer extends
	TestDataDeserializer<List<Character>, List<Character>> {

    @Override
    protected List<List<Character>> deserializeElements(String line) {
	return TestUtils.getListOfList(line);
    }

    @Override
    protected List<List<Character>> deserializeResult(String line) {
	return TestUtils.getListOfList(line);
    }

}
