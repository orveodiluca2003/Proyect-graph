/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 * En esta clase se contienen las colas y sus métodos correspondientes utilizados a lo largo del proyecto
 * @param <T>
 * @authors Georgina Akel, Orveo Di Luca, Juan Nunes, Arianne Perret Gentil
 * @version 02/06/2023
 */
public class Queue<T> {
    private Node start;
    private Node end;
    private int size;

    /**
     * Constructor de la clase Queue
     */
    public Queue() {
        this.start = null;
        this.end = null;
        this.size = 0;
    }

    /**
     * Método que retorna el primer nodo de la cola
     * @return primer nodo de la cola
     */
    public Node getStart() {
        return start;
    }

    /**
     * Método que asigna el primer nodo de la cola
     * @param start el nodo a ser asignado al principio de la cola
     */
    public void setStart(Node start) {
        this.start = start;
    }

    /**
     * Método que retorna el último nodo de la cola
     * @return último elemento de la cola
     */
    public Node getEnd() {
        return end;
    }

    /**
     * Método que asigna el último nodo de la cola
     * @param end el nuevo nodo a ser asignado al final
     */
    public void setEnd(Node end) {
        this.end = end;
    }

    /**
     * Método que retorna el tamaño de la cola
     * @return tamaño de la cola
     */
    public int getSize() {
        return size;
    }

    /**
     * Método que asigna el tamaño de la cola
     * @param size el tamaño que se quiere asignar
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * Método que indica si la cola está vacía
     * @return 
     */
    public boolean isEmpty(){
        return start == null;
    }
    
    /**
     * Método para encolar un valor en la cola
     * @param data valor para ser encolado
     */
    public void enqueue(T data){
        Node newNode = new Node(data);
        if(isEmpty()){
            start = newNode;
            end = newNode;
        }
        else{
            end.setNext(newNode);
            end = newNode;
        }
        size++;
    }
    
    /**
     * Método que desencola el primer valor de la cola y retorna su información.
     * @return información del primer elemento de la cola
     */
    public T dequeue(){
        if(isEmpty()){
            return null;
        }
        else{
            T data = (T) start.getData();
            Node newStart = start.getNext();
            start.setNext(null);
            start = newStart;
            return data;
        }
    }
}
