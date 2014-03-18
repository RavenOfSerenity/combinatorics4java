package combinatorics4java.state;

import java.util.List;

public abstract class CombinatoricState<E> extends Generator<E> {

    private int[] state;
    private boolean atEnd;

    public CombinatoricState(int size) {
	if (size <= 0) {
	    throw new IllegalArgumentException("Invalid size specified");
	}
	this.state = new int[size];
	this.init();
    }

    public boolean hasNext() {
	return !this.atEnd;
    }

    private void incrementState() {
	int position = state.length - 1;
	while (position >= 0
		&& (this.state[position] >= this.getRadix(position) - 1 || !this.isValid(position))) {
	    this.state[position] = 0;
	    position--;
	}
	if (position >= 0) {
	    this.state[position]++;
	    this.fill(position);
	} else {
	    this.atEnd = true;
	}
    }

    /*
     * Optional method used to initialise the state
     */
    protected void init() {

    }

    /*
     * Determine if at a given iteration the state is valid starting at the
     * given index
     */
    protected boolean isValid(int fromPosition) {
	return true;
    }

    /*
     * Optional method used to fill the state after the normal increment of the
     * radix starting at the given index
     */
    protected void fill(int fromPosition) {

    }

    protected int getIndex(int position) {
	return this.state[position];
    }

    protected void setIndex(int position, int value) {
	this.state[position] = value;
    }

    protected int getStateSize() {
	return this.state.length;
    }

    public List<E> next() {
	if (!this.hasNext()) {
	    throw new IllegalStateException("Next state is not available");
	}
	List<E> nextCombination = this.getNextCombination();
	this.incrementState();
	return nextCombination;
    }

    protected abstract List<E> getNextCombination();

    protected abstract int getRadix(int position);

}
