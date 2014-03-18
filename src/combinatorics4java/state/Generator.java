package combinatorics4java.state;

import java.util.Iterator;
import java.util.List;

public abstract class Generator<E> implements Iterator<List<E>> {

    /**
     * Returns the number of elements to be generated
     * 
     * @return
     */
    public abstract int size();

    public void remove() {

    }
}
