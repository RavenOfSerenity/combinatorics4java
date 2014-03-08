package combinatorics4java.state;

import java.util.Iterator;
import java.util.List;

public abstract class CombinatoricState<E> implements Iterator<List<E>> {

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
		int index = state.length - 1;
		while (index >= 0 && this.state[index] >= this.getRadix(index) - 1
				&& this.isValid(index)) {
			this.state[index] = 0;
			index--;
		}
		if (index >= 0) {
			this.state[index]++;
			this.fill(index);
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
	protected void fill(int fromIndex) {

	}

	protected int getIndex(int index) {
		return this.state[index];
	}

	protected void setIndex(int position, int value) {
		this.state[position] = value;
	}

	protected int size() {
		return this.state.length;
	}

	public void remove() {

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

	protected abstract int getRadix(int index);

}
