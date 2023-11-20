package org.example.Controlador;

public class ControladorTabla {
    
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(10);

        hashTable.insert("uno", 1);
        hashTable.insert("dos", 2);
        hashTable.insert("tres", 3);

        System.out.println("Valor asociado a 'dos': " + hashTable.get("dos"));

        hashTable.remove("dos");

        System.out.println("Valor asociado a 'dos' después de eliminarlo: " + hashTable.get("dos"));
    }
    
}
