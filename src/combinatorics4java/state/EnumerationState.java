package combinatorics4java.state;

import java.util.ArrayList;
import java.util.List;

public final class EnumerationState<E> extends CombinatoricState<E> {

    private List<E> elements;

    public EnumerationState(List<E> elements, int size) {
	super(size);
	if (elements == null || elements.size() == 0) {
	    throw new IllegalArgumentException("Elements list is empty");
	}
	this.elements = elements;
    }

    @Override
    protected int getRadix(int position) {
	return this.elements.size();
    }

    @Override
    protected List<E> getNextCombination() {
	List<E> combinationList = new ArrayList<>();
	for (int i = 0; i < this.size(); i++) {
	    combinationList.add(elements.get(this.getIndex(i)));
	}
	return combinationList;

    }

}
