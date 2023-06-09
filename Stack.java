/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import javax.swing.JOptionPane;

/**
 * En esta clase se contienen las pilas y sus métodos correspondientes utilizados a lo largo del proyecto
 * @authors Georgina Akel, Orveo Di Luca, Juan Nunes, Arianne Perret Gentil
 * @param <T>
 * @version 31/05/2023
 */
public class Stack<T> {

    private Node top;
    private Node bottom;
    private int size;

    /**
     *Constructor de la clase Stack
     */
    public Stack() {
        this.top = null;
        this.bottom = null;
        this.size = 0;
    }
    
    /**
     * Método que retorna el nodo que se encuentra en la cima
     * @return Nodo de la cima
     */
    public Node getTop() {
        return top;
    }

    /**
     * Método que establece la cima de la pila
     * @param top Nodo que se quiere establecer en la cima
     */
    public void setTop(Node top) {
        this.top = top;
    }

    /**
     * Método que retorna el nodo que se encuentra en el fondo
     * @return Nodo de la cima
     */
    public Node getBottom() {
        return bottom;
    }

    /**
     * Método que establece la cima de la pila
     * @param bottom Nodo que se quiere establecer en el fondo
     */
    public void setBottom(Node bottom) {
        this.bottom = bottom;
    }

    /**
     * Método que retorna el tamaño de la pila
     * @return tamaño de la pila
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la pila
     * @param size el tamaño que se quiere asignar
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    
    /**
     * Método que indica si la pila está vacía
     * @return valor booleano dependiendo de si la pila esta vacia o no
     */
    public boolean isEmpty(){
        return top == null;
    }
    
    /**
     * Método que retorna el valor del primer elemento de la pila
     * @return valor del primer elemento
     */
    public T peek(){
        if(isEmpty() == true){
            return null;
        }
        else{
            return (T) top.getData();
        }
    }
    
    /**
     * Método para apilar en la pila
     * @param data El valor que quiere ser apilado
     */
    public void push(T data){
        Node newNode = new Node(data);
        if(isEmpty() == true){
            top = newNode;
            bottom = newNode;
            size++;
        }
        else{
            top.setNext(newNode);
            top = newNode;
            size++;
        }
    }
    
    /**
     * Método que desapila y retorna el valor del nodo desapilado
     * @return valor del nodo desapilado
     */
    public Node pop(){
        Node pAux = null;
        if(isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Error: pila vacia");
        }
        else{
            Node pointer = bottom;
            while(pointer.getNext().getNext() != null){
                pointer = pointer.getNext();
            }
            pAux = top;
            pointer.setNext(null);
            top = pointer;
            size--;
        }
        return pAux;
    }
    
    
    
}
