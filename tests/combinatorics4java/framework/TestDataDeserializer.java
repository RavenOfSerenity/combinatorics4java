package combinatorics4java.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class TestDataDeserializer<T1, T2> {

    private String name;
    private List<T1> elements;
    private List<T2> result;
    private Scanner scanner;
    private List<Object[]> data = new ArrayList<>();

    public void fromFile(String filename) {
	this.scanner = new Scanner(TestUtils.getTestDataStream(filename));
	while (scanner.hasNextLine()) {
	    String assignmentType = scanner.next().toLowerCase();
	    switch (assignmentType) {
	    case "name":
		this.name = scanner.nextLine().trim();
		break;
	    case "elements":
		this.elements = this.deserializeElements(scanner.nextLine().trim());
		break;
	    case "result":
		this.result = this.deserializeResult(scanner.nextLine().trim());
		this.data.add(this.getDataRow());
		break;
	    }
	}
    }

    public Iterable<Object[]> getTestData() {
	return this.data;
    }

    private Object[] getDataRow() {
	return new Object[] { this.name, this.elements, this.result };
    }

    protected abstract List<T1> deserializeElements(String line);

    protected abstract List<T2> deserializeResult(String line);

}
