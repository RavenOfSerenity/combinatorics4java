package combinatorics4java.state;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class CombinatoricState<E> implements Iterator<List<E>> {

	private int[] state;
	private int index;
	private boolean atEnd;

	public CombinatoricState(int size) {
		this.state = new int[size];
		this.index = size - 1;
	}

	public boolean hasNext() {
		return !this.atEnd;
	}

	protected void incrementState() {
		while (this.index >= 0 && this.state[index] > this.getSize(index)) {
			this.state[index] = 0;
			this.index--;
		}
		if (this.index <= 0) {
			this.atEnd = true;
		}
	}

	protected List<E> getCombination(List<E> elements) {
		assert (this.state.length == elements.size());
		List<E> combinationList = new ArrayList<>();
		for (int i = 0; i < this.state.length; i++) {
			combinationList.add(elements.get(i));
		}
		return combinationList;
	}

	public void remove() {

	}

	public List<E> next() {
		this.next();
		return this.nextCombination();
	}

	protected abstract List<E> nextCombination();

	protected abstract int getSize(int pos);

}
