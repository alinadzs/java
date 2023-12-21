import java.util.LinkedList;
import java.util.Map;

class Entry<K, V> {
    K key;
    V value;

    Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() { return key; }
    public void setValue(V value) { this.value = value; }

    public V getValue() {
        return value;
    }
}


public class HashTable<K, V> {
    private LinkedList<Entry<K, V>>[] table = new LinkedList[16];
    private int size;

    private int hash(K key) { return key.hashCode() % table.length; }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<Entry<K, V>>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<K, V>(key, value));
        size++;
    }

    public V  getValue(K key) {
        int index = hash(key);
        V value = null;
        if (table[index] == null) {
            return value;
        }
        for (Entry<K, V> entry: table[index]) {
            if (entry.getKey().equals(key)){
                value = entry.getValue();
                break;
            }
        }
        return value;
    }

    public void remoteKey(K key) {
        int index = hash(key);
        if (table[index] == null){
            return;
        }
        for (Entry<K, V> entry: table[index]) {
            if (entry.getKey().equals(key)) {
                table[index].remove(entry);
                size--;
                break;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

