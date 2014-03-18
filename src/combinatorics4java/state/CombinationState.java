package combinatorics4java.state;

import java.util.List;

public final class CombinationState<E> extends EnumerationState<E> {

    private int maxIndex;
    private int maxPosition;

    public CombinationState(List<E> elements, int size) {
	super(elements, size);
	if (size > elements.size()) {
	    throw new IllegalArgumentException("Size can't exceed the number of elements");
	}
	this.maxIndex = elements.size() - 1;
	this.maxPosition = this.getStateSize() - 1;
    }

    private int halfFactorial(int start, int end) {
	int fact = 1;
	for (int i = start + 1; i <= end; i++) {
	    fact = fact * i;
	}
	return fact;
    }

    @Override
    protected int calculateSize(int requestedSize) {
	int len = this.elements.size();
	int max = Math.max(requestedSize, len - requestedSize);
	int min = Math.min(requestedSize, len - requestedSize);
	return this.halfFactorial(max, len) / this.halfFactorial(1, min);
    }

    @Override
    protected void init() {
	for (int i = 0; i < this.getStateSize(); i++) {
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
	for (int i = fromPosition + 1; i < this.getStateSize(); i++) {
	    this.setIndex(i, ++index);
	}
    }

}
