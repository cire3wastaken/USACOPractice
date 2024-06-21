package me.cire3;

import me.cire3.drafts.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<byte[]> vboentries = new ArrayList<>();
        List<byte[]> indexablevboentries = new ArrayList<>();

        for (int i = 0; i < 65535; i++) {
            vboentries.add(new byte[] {1, 2, 3});
            indexablevboentries.add(new byte[]{3, 2, 1});
        }

        long start1 = System.nanoTime();

        Pair<List<Integer>, List<byte[]>> lax = doLax(vboentries, indexablevboentries);

        System.out.println("lax took: " + (System.nanoTime() - start1) + " nanoseconds.");

        vboentries.clear();
        IndexLinkedHashSet<ByteArray> indexablevboentries1 = new IndexLinkedHashSet<>();
        for (int i = 0; i < 65535; i++) {
            vboentries.add(new byte[] {1, 2, 3});
            indexablevboentries1.add(ByteArray.of((byte) 3, (byte) 2, (byte) 1));
        }

        long start2 = System.nanoTime();

        Pair<List<Integer>, IndexLinkedHashSet<ByteArray>> cire = doCire(vboentries, indexablevboentries1);

        System.out.println("cire took: " + (System.nanoTime() - start2) + " nanoseconds.");

        assert cire.getFirst().equals(lax.getFirst());

        for (ByteArray byteArray : cire.getSecond()) {
            assert lax.getSecond().contains(byteArray.array);
        }
    }

    public static Pair<List<Integer>, IndexLinkedHashSet<ByteArray>> doCire(List<byte[]> vboentries, IndexLinkedHashSet<ByteArray> indexablevboentries) {
        List<Integer> indexbuffer = new ArrayList<>();

        for (byte[] v : vboentries) {
            int l = indexablevboentries.size();
            // TreeSet has O(log n) contains
            if (indexablevboentries.contains(ByteArray.of(v))) {
                // "hacky" way to get index of elem in a treeset
                indexbuffer.add(indexablevboentries.indexOf(ByteArray.of(v)));
            } else {
                if (l > 65535)
                    throw new RuntimeException("Too many vertices!");
                indexbuffer.add(l);
                indexablevboentries.add(ByteArray.of(v));
            }
        }

        return new Pair<>(indexbuffer, indexablevboentries);
    }

    public static Pair<List<Integer>, List<byte[]>> doLax(List<byte[]> vboentries, List<byte[]> indexablevboentries) {
        List<Integer> indexbuffer = new ArrayList<>();

        for(int j = 0; j < vboentries.size(); ++j) {
            byte v[] = vboentries.get(j);
            int l = indexablevboentries.size();
            boolean flag = true;
            for(int i = 0; i < l; i++) {
                if(Arrays.equals(v, indexablevboentries.get(i))) {
                    indexbuffer.add(i);
                    flag = false;
                    break;
                }
            }
            if(flag) {
                if(l > 65535) {
                    throw new RuntimeException("Too many vertices!");
                }
                indexbuffer.add(l);
                indexablevboentries.add(v);
            }
        }

        return new Pair<>(indexbuffer, indexablevboentries);
    }

    /*
    * Copied from https://stackoverflow.com/a/77179230
    * */
    public static final class IndexLinkedHashSet<E> implements Set<E> {
        private final ArrayList<E> list = new ArrayList<>( );
        private final HashSet<E>   set  = new HashSet<>  ( );

        public synchronized boolean add(E e) {
            if ( set.add(e) ) {
                return list.add(e);
            }
            return false;
        }

        public synchronized boolean remove(Object o) {
            if ( set.remove(o) ) {
                return list.remove(o);
            }
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return set.containsAll(c);
        }

        public synchronized void clear() {
            set.clear();
            list.clear();
        }

        public synchronized E get(int index) {
            return list.get(index);
        }


        // Added this function
        public synchronized int indexOf(E element) {
            return list.indexOf(element);
        }
        //

        public synchronized boolean removeAll(Collection<?> c) {
            if ( set.removeAll(c) ) {
                return list.removeAll(c);
            }
            return true;
        }

        public synchronized boolean retainAll(Collection<?> c) {
            if ( set.retainAll(c) ) {
                return list.retainAll(c);
            }
            return false;
        }

        public synchronized boolean addAll(Collection<? extends E> c) {
            boolean modified = false;
            for (E e : c)
                if (add(e))
                    modified = true;
            return modified;
        }

        @Override
        public synchronized int size() {
            return set.size();
        }

        @Override
        public synchronized boolean isEmpty() {
            return set.isEmpty();
        }

        @Override
        public synchronized boolean contains(Object o) {
            return set.contains(o);
        }

        @Override
        public synchronized Iterator<E> iterator() {
            return list.iterator();
        }

        @Override
        public synchronized Object[] toArray() {
            return list.toArray();
        }

        @Override
        public synchronized <T> T[] toArray(T[] a) {
            return list.toArray(a);
        }
    }

    public static class ByteArray {
        public final byte[] array;

        public ByteArray(byte[] array) {
            this.array = array;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ByteArray byteArray = (ByteArray) o;
            return Arrays.equals(array, byteArray.array);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(array);
        }

        public static ByteArray of(byte... bytes) {
            return new ByteArray(bytes);
        }
    }

    public static class Pair<V, K> {
        private V first;
        private K second;

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
    }
}