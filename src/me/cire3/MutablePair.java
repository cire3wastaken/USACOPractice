package me.cire3;

public class MutablePair<V, K> extends Pair<V, K> {
    public MutablePair(V first, K second) {
        super(first, second);
    }

    public MutablePair<V, K> setFirst(V first) {
        this.first = first;
        return this;
    }

    public MutablePair<V, K> setSecond(K second) {
        this.second = second;
        return this;
    }

    public MutablePair<V, K> set(V first, K second) {
        this.first = first;
        this.second = second;
        return this;
    }
}
