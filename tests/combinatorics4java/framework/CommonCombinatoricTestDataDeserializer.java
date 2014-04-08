package combinatorics4java.framework;

import java.util.List;

public final class CommonCombinatoricTestDataDeserializer extends
	TestDataDeserializer<Character, List<Character>> {

    @Override
    protected List<Character> deserializeElements(String line) {
	return TestUtils.getList(line);
    }

    @Override
    protected List<List<Character>> deserializeResult(String line) {
	return TestUtils.getListOfList(line);
    }

}
