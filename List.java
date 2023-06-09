/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import javax.swing.JOptionPane;

/**
 * En esta clase se contienen las listas y sus métodos correspondientes utilizados a lo largo del proyecto
 * @authors Georgina Akel, Orveo Di Luca, Juan Nunes, Arianne Perret Gentil
 * @param <T>
 * @version 31/05/2023
 */
public class List<T> {

    private Node head;
    private Node tail;
    private int size;
    
    /**
     * Constructor 1 de la clase Lista, no recibe nada por parámetros
     */
    public List() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    /**
     * Constructor 2 de la clase Lista, recibe uno o mas datos para ser guardados en la lista cuando se inicialize
     * @param data
     */
    public List(T... data) {
        for (T elemento : data) {
            append(elemento);
        }
    }
    
    /**
     * Obtiene el primer nodo de la lista
     * @return el primero nodo de la lista
     */
    public Node getHead() {
        return head;
    }

    /**
     * Establece el primer nodo de la lista
     * @param head el nodo que se quiere establecer como primero
     */
    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * Retorna el último nodo de la lista
     * @return el último nodo de la lista
     */
    public Node getTail() {
        return tail;
    }

    /**
     * Establece el último nodo de la lista
     * @param tail el nodo que se quiere establecer como último
     */
    public void setTail(Node tail) {
        this.tail = tail;
    }

    /**
     * Obtiene el tamaño de la lista
     * @return tamaño de la lista
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la lista
     * @param size el tamaño a ser establecido
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    
    /**
     * Método que verifica si la lista está vacía
     * @return si la lista está vacía o hay elementos en ella
     */
    public boolean isEmpty(){
        return head == null;
    }
    
    /**
     * Método que obtiene el tamaño de la lista
     * @return el tamaño de la lista
     */
    public int len(){
        return getSize();
    }
    
    /**
     * Método que borra la lista
     */
    public void delete(){
        head = null;
        tail = null;
        size = 0;
    }
    
    /**
     * Método que agrega un elemento al final de la lista
     * @param data
     */
    public final void append(T data){
        Node newNode = new Node(data);
        if(isEmpty() == true){
            head = newNode;
            tail = newNode;
            size++;
        }
        else{
            tail.setNext(newNode);
            tail = newNode;
            size++;
        }
    }
    
    /**
     * Método que agrega un elemento al incio de la lista
     * @param data
     */
    public void preappend(T data){
        Node newNode = new Node(data);
        if(isEmpty() == true){
            head = newNode;
            tail = newNode;
            size++;
        }
        else{
            newNode.setNext(head);
            head = newNode;
            size++;
        }
    }
    
    /**
     * Método que obtiene un valor de la posición indicada de la lista
     * @param position posición de la lista cuya información se quiere saber
     * @return información del dato en la posición dada
     */
    public T get(int position){
        Node pointer = head;
        if(position < 0 || position >= len()){
            return null;
        }
        else if(position == 0){
            return (T) head.getData();
        }
        else if(position == len()-1){
            return (T) tail.getData();
        }
        else{
            for(int x = 1; x <= position; x++){
                pointer = pointer.getNext();
            }
            return (T) pointer.getData();
        }
    }
    
    /**
     * Método que imprime en pantalla una lista completa
     */
    public void print(){
        Node pointer = head;
        if(isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Lista vacia");
        }
        else{
            String list = "[";
            for(int x = 0; x < getSize(); x++){
                if(x != getSize()-1){
                    list = list + pointer.getData() + ", ";
                    pointer = pointer.getNext();
                }
                else{
                    list = list + pointer.getData() + "]";
                }
            }
            JOptionPane.showMessageDialog(null, list);
        }
    }
    
    /**
     * Método que inserta un elemento en una posición indicada de una lista
     * @param position posición de la lista en la cual se desea insertar el nuevo nodo
     * @param data información del nodo
     */
    public void insert(int position, T data){
        boolean run = true;
        Node newNode = new Node(data);
        while(run == true){
            if(position < 0 || position >= len()){
                run = false;
            }
            else{
                if(position == 0){
                    preappend(data);
                    run = false;
                }
                else{
                    Node pointer = head;
                    for(int x = 1; x < position; x++){
                        pointer = pointer.getNext();
                    }
                    newNode.setNext(pointer.getNext());
                    pointer.setNext(newNode);
                    size++;  
                    run = false;
                }
            }
        }
    }
    
    /**
     * Método que reemplaza un elemento de la posición indicada de la lista por otro
     * @param position posición de la lista en la cual se desea reemplazar el nodo
     * @param data nueva información del nodo
     */
    public void replace(int position, T data){
        boolean run = true;
 
        while(run == true){
            if(position < 0 || position >= len()){
                run = false;
            }
            else{
                if(position == 0){
                    head.setData(data);
                    run = false;
                }
                else if(position == len()-1){
                    tail.setData(data);
                    run = false;
                }
                else{
                    Node pointer = head;
                    for(int x = 0; x < position; x++){
                        pointer = pointer.getNext();
                    }
                    pointer.setData(data);
                    run = false;
                }
            }
        }
    }
    
    /**
     * Método que elimina un elemento de la posición indicada de la lista
     * @param position posición de la lista en la cual se encuentra el nodo que se quiere eliminar
     */
    public void pop(int position){
        Node pointer = head;
        if(position == 0){
            head = head.getNext();
            size--;
        }
        else if(position == len()-1){
            for(int x = 2; x < len(); x++){
                pointer = pointer.getNext();
            }
            pointer.setNext(null);
            tail = pointer;
            size--;
        }
        else{
            for(int x = 0; x < position-1; x++){
                pointer = pointer.getNext();
            }
            pointer.setNext(pointer.getNext().getNext());
            size--;
        }
    }
    
    /**
     * Método que con la información del nodo busca su posición en la lista
     * @param data información del nodo cuya posición de la lista se quiere encontrar
     * @return posición del nodo de acuerdo a la información dada
     */
    public int find(T data){
        if(head.getData() == data){
            return 0;
        }
        else if(tail.getData() == data){
            return size-1;
        }
        else{
            Node pointer = head;
            for(int x = 0; x < len(); x++){
                if(pointer.getData() == data){
                    return x;
                }
                pointer = pointer.getNext();
            }
        }
        return 0;
    }
    
    /**
     * Método que con la información dada busca su posición en la lista
     * @param data información del nodo cuya posición de la lista se quiere encontrar
     * @return posición del nodo de acuerdo a la información dada
     */
    public int findVperson(String data){
        if(head.getData().equals(data)){
            return 0;
        }
        else if(tail.getData().equals(data)){
            return size-1;
        }
        else{
            Node pointer = head;
            for(int x = 0; x < len(); x++){
                if(pointer.getData().equals(data)){
                    return x;
                }
                pointer = pointer.getNext();
            }
        }
        return -1;
    }
    
    /**
     * Método que identifica si un string pasado por parametro existe en la lista
     * @param data string que se quiere saber si está o no en la lista
     * @return booleano dependiendo de si existe o no el string en la lista
     */
    public boolean existStr(String data){
        if(head.getData().equals(data) == true){
            return true;
        }
        else if(tail.getData().equals(data) == true){
            return true;
        }
        else{
            Node pointer = head;
            for(int x = 0; x < len(); x++){
                if(pointer.getData().equals(data)){
                    return true;
                }
                pointer = pointer.getNext();
            }
        }
        return false;
    }
    
    /**
     * Método que identifica si un valor pasado por parametro existe en la lista
     * @param data información que se quiere saber si está o no en la lista
     * @return booleano dependiendo de si existe o no el valor en la lista
     */
    public boolean exist(T data){
        if(head.getData() == data){
            return true;
        }
        else if(tail.getData() == data){
            return true;
        }
        else{
            Node pointer = head;
            for(int x = 0; x < len(); x++){
                if(pointer.getData() == data){
                    return true;
                }
                pointer = pointer.getNext();
            }
        }
        return false;
    }
    
    
    
    
    
    
    
    
}
