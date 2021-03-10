package ex1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HashTableTest {
    @ParameterizedTest
    //Las parejas que damos lo que hará será repetir 4 veces el juego de prueba
    @CsvSource({"1,3", "2,4", "3,5", "4,6"})
    void put(String key, String value){
        HashTable hashTable = new HashTable();
        //se añade key y value
        hashTable.put(key, value);
        //El "get" hace uso de la key para buscar el elemento value
        Assertions.assertEquals(value, hashTable.get(key));
    }
    @ParameterizedTest
    @CsvSource({"1,3"})
    void get(String key, String value){
        HashTable hashTable = new HashTable();
        hashTable.put(key, value);
        Assertions.assertEquals(value, hashTable.get(key));
    }

    @org.junit.jupiter.api.Test
    void count(){
        HashTable hashTable = new HashTable();
        hashTable.put("10", "20");
        //Aqui el count esperara un valor de 1 debido a que se ha añadido valores
        Assertions.assertEquals(1, hashTable.count());
    }

    @org.junit.jupiter.api.Test
    void size(){
        HashTable hashTable = new HashTable();
        //Aqui se implementa un esperado de 16 debido a que es el maximo size, si implementaramos uno menor nos daria error
        Assertions.assertEquals(16, hashTable.size());
    }
    @ParameterizedTest
    @CsvSource({"10"})
    void drop(String key){
        HashTable hashTable = new HashTable();
        hashTable.put(key, "4");
        //Comprobamos que hay uno
        Assertions.assertEquals(1, hashTable.count());
        //Se elimina el valor
        hashTable.drop(key);
        //Comprobamos que no hay ninguno
        Assertions.assertEquals(null, hashTable.get(key));
    }
}
