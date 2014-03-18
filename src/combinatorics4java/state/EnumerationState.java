package combinatorics4java.state;

import java.util.ArrayList;
import java.util.List;

public class EnumerationState<E> extends CombinatoricState<E> {

    protected List<E> elements;
    private int size;

    public EnumerationState(List<E> elements, int size) {
	super(size);
	if (elements == null || elements.size() == 0) {
	    throw new IllegalArgumentException("Elements list is empty");
	}
	this.elements = elements;
	this.size = this.calculateSize(size);
    }

    protected int calculateSize(int enumerationSize) {
	int len = this.getRadix(0);
	return (int) Math.pow(len, enumerationSize);
    }

    @Override
    protected int getRadix(int position) {
	return this.elements.size();
    }

    @Override
    protected List<E> getNextCombination() {
	List<E> combinationList = new ArrayList<>();
	for (int i = 0; i < this.getStateSize(); i++) {
	    combinationList.add(elements.get(this.getIndex(i)));
	}
	return combinationList;

    }

    @Override
    public int size() {
	return this.size;
    }

}
