package noval.surya.mandala.validation.container;

public class Entry<K, V> {

    private K key;

    private V value;

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }
}
