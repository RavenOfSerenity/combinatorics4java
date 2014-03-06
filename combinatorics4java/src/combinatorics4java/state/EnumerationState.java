package combinatorics4java.state;

import java.util.List;

public final class EnumerationState<E> extends CombinatoricState<E> {

	private List<E> elements;

	public EnumerationState(List<E> elements) {
		super(elements.size());
		this.elements = elements;
	}

	@Override
	protected int getSize(int pos) {
		return this.elements.size();
	}

	@Override
	protected List<E> nextCombination() {
		return super.getCombination(elements);
	}

}
