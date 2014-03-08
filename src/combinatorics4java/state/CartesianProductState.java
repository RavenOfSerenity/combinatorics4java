package combinatorics4java.state;

import java.util.ArrayList;
import java.util.List;

public final class CartesianProductState<E> extends CombinatoricState<E> {

	private List<List<E>> elements;

	public CartesianProductState(List<List<E>> elements) {
		super(elements.size());
		if (!this.isValid(elements)) {
			throw new IllegalArgumentException("Elements list is invalid");
		}
		this.elements = elements;
	}

	private boolean isValid(List<List<E>> elements) {
		if (elements == null) {
			return false;
		}
		for (List<E> item : elements) {
			if (item.size() == 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	protected List<E> getNextCombination() {
		List<E> combinationList = new ArrayList<>();
		for (int i = 0; i < this.size(); i++) {
			combinationList.add(elements.get(i).get(this.getIndex(i)));
		}
		return combinationList;
	}

	@Override
	protected int getRadix(int position) {
		return this.elements.get(position).size();
	}

}
