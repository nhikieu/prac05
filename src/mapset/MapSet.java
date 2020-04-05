package mapset;

import java.util.*;

public class MapSet<K, V> extends AbstractMap<K, HashSet<V>> implements Iterable<V> {
    private HashMap<K, HashSet<V>> mapset = new HashMap<K, HashSet<V>>();

    public class MapListIterator<V> implements Iterator<V> {
        int key = 0;
        int value = 0;
        ArrayList<HashSet<V>> keys;
        HashSet<V> currentValues;
        Iterator<V> currentValuesIterator;

        public MapListIterator() {
            ArrayList a = new ArrayList(mapset.values());
            Collections.sort(a, (HashSet<V> z, HashSet<V> x) -> x.size() - z.size());
            keys = a;
            currentValues = keys.get(key);
            currentValuesIterator = currentValues.iterator();
        }

        @Override
        public boolean hasNext() {
            return key < keys.size() - 1 || currentValuesIterator.hasNext();
        }

        @Override
        public V next() {
            if(!currentValuesIterator.hasNext())
            {
                HashSet<V> newValuesSet = keys.get(++key);
                currentValuesIterator = newValuesSet.iterator();
            }
            return currentValuesIterator.next();
        }
    }
    @Override
    public Set<Entry<K, HashSet<V>>> entrySet() {
        return mapset.entrySet();
    }

    public void addValue(K key, V value) {
        if (!containsKey(key)) {
            mapset.put(key, new HashSet<>());
        }
        ;
        get(key).add(value);
    }

    @Override
    public Iterator iterator() {
        return new MapListIterator<V>();
    }
}
