
package Classes;

import Classes.Edge;
import DataStructures.List;

/**
 * Clase que contiene metodos sobre los objetos Vpersona utilizados en el proyecto
 * @authors Georgina Akel, Orveo Di Luca, Juan Nunes, Arianne Perret Gentil
 * @version 02/06/2023
 */
public class Vperson {
    private List<Edge> AdyList;
    private int Vnum;
    private String name;
    private boolean visited;

    public Vperson(int Vnum, String name) {
        this.AdyList = new List();
        this.Vnum = Vnum;
        this.name = name;
        this.visited = false;
        
    }

    /** 
    * Método que retorna la lista de adyacencia del vertice 
    * @return lista de adyacencia del vertice
    */
    public List getAdyList() {
        return AdyList;
    }
    
    /** 
    * Método que agrega una relacion a la lista de adyacencia de un vertice 
    * @param edge nueva relación
    */
    public void addToAdyList(Edge edge){
        this.AdyList.append(edge);
    }
    
    /** 
    * Método que cambia la lista de adyacencia de un vertice 
    * @param AdyList  lista de adyacencia
    */
    public void setAdyList(List AdyList) {
        this.AdyList = AdyList;
    }

    /** 
    * Método que retorna el número de un vertice
    * @return número de un vertice
    */
    public int getVnum() {
        return Vnum;
    }

    /** 
    * Método que cambia el número del vértice del usuario
    * @param Vnum nuevo número del vertice
    */
    public void setVnum(int Vnum) {
        this.Vnum = Vnum;
    }

    /** 
    * Método que retorna el nombre del vértice
    * @return el nombre del vértice
    */
    public String getName() {
        return name;
    }

    /** 
    * Método que cambia el nombre del vértice
    * @param name nuevo nombre del vértice
    */
    public void setName(String name) {
        this.name = name;
    }
    
    /** 
    * Método que retorna un valor booleano dependiendo de si el vertice fue visitado
    * @return true o false
    */
    public boolean isVisited() {
        return visited;
    }
    
    /** 
    * Método que cambia el valor booleano dependiendo de si fue visitado o no
    * @param visited nuevo valor booleano del vertice
    */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    
    
    
    
    
}