package combinatorics4java.state;

import java.util.ArrayList;
import java.util.List;

public final class CombinationState<E> extends CombinatoricState<E> {

    private List<E> elements;
    private int maxIndex;
    private int maxPosition;

    public CombinationState(List<E> elements, int size) {
	super(size);
	if (elements == null || elements.size() == 0) {
	    throw new IllegalArgumentException("Elements list is empty");
	} else if (size > elements.size()) {
	    throw new IllegalArgumentException("Size can't exceed the number of elements");
	}
	this.elements = elements;
	this.maxIndex = elements.size() - 1;
	this.maxPosition = this.size() - 1;
    }

    @Override
    protected void init() {
	for (int i = 0; i < this.size(); i++) {
	    this.setIndex(i, i);
	}
    }

    /*
     * Returns false if there are not enough elements to fill the rest of the
     * state, in other words if we fill this with ascending indexes we will
     * exceed the maximum index
     */
    @Override
    protected boolean isValid(int fromPosition) {
	int index = this.getIndex(fromPosition) + 1;
	int availableElements = this.maxIndex - index;
	int availablePositions = this.maxPosition - fromPosition;
	return availableElements >= availablePositions;
    }

    /*
     * Since combinations don't contain repetition, we need to fill with indexes
     * that are in ascending order
     */
    @Override
    protected void fill(int fromPosition) {
	int index = this.getIndex(fromPosition);
	for (int i = fromPosition + 1; i < this.size(); i++) {
	    this.setIndex(i, ++index);
	}
    }

    @Override
    protected List<E> getNextCombination() {
	List<E> combinationList = new ArrayList<>();
	for (int i = 0; i < this.size(); i++) {
	    combinationList.add(elements.get(this.getIndex(i)));
	}
	return combinationList;

    }

    @Override
    protected int getRadix(int index) {
	return this.elements.size();
    }

}
