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
	}

	public boolean hasNext() {
		return !this.atEnd;
	}

	protected void incrementState() {
		int index = state.length - 1;
		while (index >= 0 && this.state[index] >= this.getSize(index) - 1) {
			this.state[index] = 0;
			index--;
		}
		if (index >= 0) {
			this.state[index]++;
		} else {
			this.atEnd = true;
		}
	}

	public int getIndex(int position) {
		return this.state[position];
	}

	public int size() {
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

	protected abstract int getSize(int position);

}
