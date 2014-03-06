package combinatorics4java.state;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class CombinatoricState<E> implements Iterator<List<E>> {

	private int[] state;
	private boolean atEnd;

	public CombinatoricState(int size) {
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

	protected List<E> getCombination(List<E> elements) {
		List<E> combinationList = new ArrayList<>();
		for (int i = 0; i < this.state.length; i++) {
			combinationList.add(elements.get(this.state[i]));
		}
		return combinationList;
	}

	public void remove() {

	}

	public List<E> next() {
		List<E> nextCombination = this.getNextCombination();
		this.incrementState();
		return nextCombination;
	}

	protected abstract List<E> getNextCombination();

	protected abstract int getSize(int pos);

}
