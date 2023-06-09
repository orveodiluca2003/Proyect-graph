/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 * Clase con metodos del objeto Edge que serán utilizados a lo largo del proyecto
 * @authors Georgina Akel, Orveo Di Luca, Juan Nunes, Arianne Perret Gentil
 * @version 31/05/2023
 */
public class Edge {

    private int start;
    private int end;
    private int weight;
    private boolean read;
    
    /**
    * Constructor de la clase Edge
    * @param start pasa el número de vértice de inicio
    * @param end pasa el número de vértice de final
    * @param weight pasa el peso de la relación
    */ 
    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
        this.read = false;
    }
    
    /** 
    * Método que retorna el valor de start
    * @return el valor de start 
    */
    public int getStart() {
        return start;
    }

    /** 
    * Método que establece el valor de start
    * @param start
    */
    public void setStart(int start) {
        this.start = start;
    }

    /** 
    * Método que retorna el valor de end
    * @return el valor de end 
    */
    public int getEnd() {
        return end;
    }

    /** 
    * Método que establece el valor de end
    * @param end 
    */
    public void setEnd(int end) {
        this.end = end;
    }

    /** 
    * Método que retorna el valor de weight
    * @return el valor de weight 
    */
    public int getWeight() {
        return weight;
    }

    /** 
    * Método que establece el valor de weight
    * @param weight 
    */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /** 
    * Método que verifica si un elemento ha sido leído 
    * @return 
    */
    public boolean isRead() {
        return read;
    }

    /** 
    * Método que cambia el valor del atributo read 
    * @param read 
    */
    public void setRead(boolean read) {
        this.read = read;
    }
    
    
    
    
    
    
}