/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 * En esta clase se almacenan los nodos y sus métodos, que serán utilizados a lo largo del proyecto
 * @authors Georgina Akel, Orveo Di Luca, Juan Nunes, Arianne Perret Gentil
 * @param <T>
 * @version 23/05/2023
 */
public class Node<T> {
    //Atributos de la clase
    private Node next;
    private T data;
    
    /**
     * Constructor de la clase Node, recibe por parámetro la información del nodo
     * @param data Corresponde al valor del nodo
     */
    public Node(T data) {
        this.next = null;
        this.data = data;
    }
    
    /**
     * Devuelve el nodo próximo del nodo que está siendo llamado
     * @return El nodo siguiente
     */
    public Node getNext() {
        return next;
    }

    /**
     * Establece el nodo siguiente del nodo con el que se llama al método
     * @param next Nodo que se busca establecer como siguiente
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Método que retorna el valor del Nodo
     * @return el valor del nodo
     */
    public T getData() {
        return data;
    }

    /**
     * Método que establece el valor del nodo o lo cambia
     * @param data el nuevo valor del nodo
     */
    public void setData(T data) {
        this.data = data;
    }

    
}
