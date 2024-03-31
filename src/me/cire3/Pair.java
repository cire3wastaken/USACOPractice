package me.cire3;

public class Pair<V, K> {
    protected V first;
    protected K second;

    public Pair(V first, K second) {
        this.first = first;
        this.second = second;
    }

    public V getFirst() {
        return first;
    }

    public K getSecond() {
        return second;
    }

    @Override
    public int hashCode() {
        return first.hashCode() + second.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pair))
            return false;
        Pair pair = (Pair) obj;

        return (pair.hashCode() == hashCode() || (this.first == pair.first && this.second == pair.second));
    }
}
