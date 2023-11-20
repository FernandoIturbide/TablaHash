package org.example.Controlador;
import java.util.LinkedList;

class KeyValue<K, V> {
    K key;
    V value;

    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class HashTable<K, V> {
    private int size;
    private LinkedList<KeyValue<K, V>>[] table;

    public HashTable(int size) {
        this.size = size;
        this.table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(K key) {
        return key.hashCode() % size;
    }

    public void insert(K key, V value) {
        int index = hashFunction(key);
        LinkedList<KeyValue<K, V>> bucket = table[index];

        for (KeyValue<K, V> keyValue : bucket) {
            if (keyValue.key.equals(key)) {
                keyValue.value = value; // Actualizar el valor si la clave ya existe
                return;
            }
        }

        bucket.add(new KeyValue<>(key, value));
    }

    public V get(K key) {
        int index = hashFunction(key);
        LinkedList<KeyValue<K, V>> bucket = table[index];

        for (KeyValue<K, V> keyValue : bucket) {
            if (keyValue.key.equals(key)) {
                return keyValue.value; // Devolver el valor si la clave existe
            }
        }

        return null; // La clave no está presente en la tabla
    }

    public void remove(K key) {
        int index = hashFunction(key);
        LinkedList<KeyValue<K, V>> bucket = table[index];

        for (KeyValue<K, V> keyValue : bucket) {
            if (keyValue.key.equals(key)) {
                bucket.remove(keyValue);
                return;
            }
        }
    }

    
}
