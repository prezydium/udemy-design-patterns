package org.prezydium.composite;

import java.util.*;
import java.util.function.Consumer;

public class CompositeTask {
}

interface ValueContainer extends Iterable<Integer> {

    default int sumValues() {
        int sum = 0;
        for (Integer v : this
        ) {
            sum += v;
        }
        return sum;
    }
}

class SingleValue implements ValueContainer {
    public int value;

    // please leave this constructor as-is
    public SingleValue(int value) {
        this.value = value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return Collections.singleton(this.value).iterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        action.accept(this.value);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return Collections.singleton(this.value).spliterator();
    }
}

class ManyValues extends ArrayList<Integer> implements ValueContainer {
}


class MyList extends ArrayList<ValueContainer> {
    // please leave this constructor as-is
    public MyList(Collection<? extends ValueContainer> c) {
        super(c);
    }

    public int sum() {
        int sum = 0;
        for (ValueContainer value : this) {
            sum += value.sumValues();
        }
        return sum;
    }
}
