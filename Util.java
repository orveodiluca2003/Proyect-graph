/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import DataStructures.Grafo;
import DataStructures.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase con métodos que serán utilizados a lo largo del proyecto, relacionados al archivo TXT
 * @authors Georgina Akel, Orveo Di Luca, Juan Nunes, Arianne Perret Gentil
 * @version 31/05/2023
 */
public class  Util {
        
    /** 
    * Método que obtiene la ruta de acceso del archivo txt
    * @return string de la ruta de acceso del archivo txt
    */
    public String ObtenerRutaTXT() {
        String fileRoute; 
        JFileChooser fi = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        
        int option = fi.showOpenDialog(null);
        
        if (option == 0)
        {
            
            fileRoute = fi.getSelectedFile().getAbsolutePath();
            if (!fileRoute.endsWith("txt")) {
                JOptionPane.showMessageDialog(null, "formato de archivo no valido, intente de nuevo");
            }
            
        } else
        {
            fileRoute = "";
        }
        return fileRoute;
    }
    
    /** 
    * Método que escribe sobre el archivo txt
    * @param allPerson
    * @param fileRoute
    */
    public void WriteTxt(List allPerson,String fileRoute) {
        if ("".equals(fileRoute)){
            JOptionPane.showMessageDialog(null, "Error! No hay ruta de acceso.");
        } 
        else{
            String str = "Usuarios\n";
            if (allPerson.isEmpty() == false){
                for (int x = 0; x < allPerson.len(); x++){
                    Vperson person = (Vperson) allPerson.get(x);
                    str = str + person.getVnum() + ", " + person.getName() + "\n";
                }
                str = str + "Relaciones\n";
                for (int x = 0; x < allPerson.len(); x++){
                    Vperson person = (Vperson) allPerson.get(x);
                    List auxList = person.getAdyList();
                    for (int y = 0; y < auxList.len(); y++){
                        Edge edge = (Edge) auxList.get(y);
                        if(edge.isRead()){
                            str += Integer.toString(edge.getStart()) + ", " + Integer.toString(edge.getEnd()) + ", " + Integer.toString(edge.getWeight()) + "\n";                                             
                        }
                    }
                }
            }
            try{
               PrintWriter pw = new PrintWriter(fileRoute); 
               pw.print(str);
               pw.close();
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error! No se ha escrito sobre el archivo.");
            }
        }
    }
    
    /** 
    * Método que lee el archivo y agrega los usuarios a la lista de personas
    * @param fileRoute
    * @return lista de personas
    */
    public List read_users(String fileRoute){
        List persons = new List();
        
        String line;
        String str = "";
        
        File newFile = new File(fileRoute);
        try {
            if (newFile.exists() == false) {
                newFile.createNewFile();
            } else {
                FileReader fr = new FileReader(newFile);
                BufferedReader br = new BufferedReader(fr);

                while (!"Relaciones".equals(line = br.readLine())) {
                    if (line.isEmpty() == false && line.equals("Usuarios") == false) {
                        str += line + "\n";
                    }
                }
                if ("".equals(str) == false) {
                    String[] str_split = str.split("\n");
                    for (int x = 0; x < str_split.length; x++) {
                        String[] Str = str_split[x].split(", ");
                        Vperson person = new Vperson(Integer.parseInt(Str[0]), Str[1]);
                        persons.append(person);
                    }
                }
                br.close();

            }
        } catch (Exception e) {
            
        }
        return persons;
        
        
    }
    
    /** 
    * Método que lee y agrega las relaciones a la lista de relaciones
    * @param allPerson 
    * @param fileRoute
    * @return lista de relaciones
    */
    public List read_relations(List allPerson, String fileRoute) {
        List relations = new List();
        String line;
        String str = "";
        
        File newFile = new File(fileRoute);
        try {
            if (newFile.exists() == false) {
                newFile.createNewFile();
            } else {
                FileReader fr = new FileReader(newFile);
                BufferedReader br = new BufferedReader(fr);

                boolean run = false;
                while (null != (line = br.readLine())) {
                    if (line.isEmpty() == false && line.equals("Usuarios") == false && run == true) {
                        str += line + "\n";
                    }
                    if (line.equals("Relaciones") == true) {
                        run = true;
                    }

                }

                if ("".equals(str) == false) {
                    String[] str_split = str.split("\n");
                    for (int x = 0; x < str_split.length; x++) {
                        String[] Str = str_split[x].split(", ");
                        Edge newEdge = new Edge(Integer.parseInt(Str[0]), Integer.parseInt(Str[1]), Integer.parseInt(Str[2]));
                        newEdge.setRead(true);
                        relations.append(newEdge);
                    }
                }
                br.close();

            }
        } 
        catch (Exception e) {
            
        }
        return relations;
    }
    
    /** 
    * Método que identifica si un string es de carácter numérico 
    * @param str 
    * @return True si es numérico o False si no es numérico o es nulo
    */
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /** 
    * Método que genera un número de ID para un vertice en la libreria GraphStream 
    * @param graph 
    * @return el número generado 
    */
    public int generateID(Grafo graph){
        List allPerson = graph.getAllPerson();
        List allVnums = new List();
        int num = (int) (Math.random()*999+1);
        
        for(int x = 0; x < allPerson.len(); x++){
            Vperson person = (Vperson) allPerson.get(x);
            allVnums.append(person.getVnum());         
        }
        
        while(allVnums.exist(num)){
            num = (int) (Math.random()*999+1);
        }
        
        return num;
    }
    
    /** 
    * Método que genera un número de ID para el edge de la libreria GraphStream
    * @param graph 
    * @return el número generado
    */
    public int generateIDforEdge(Grafo graph){
        List allPerson = graph.getAllPerson();
        List allVnums = new List();
        int num = (int) (Math.random()*999+1);
        
        for(int x = 0; x < allPerson.len(); x++){
            Vperson person = (Vperson) allPerson.get(x);
            allVnums.append(person.getVnum());         
        }
        
        while(allVnums.exist(num)){
            num = (int) (Math.random()*999+1);
        }
        
        return num;
    }
    
}