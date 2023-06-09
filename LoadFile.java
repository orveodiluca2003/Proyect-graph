/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicInterface;

import Classes.Edge;
import Classes.Util;
import Classes.Vperson;
import DataStructures.Grafo;
import DataStructures.List;
import javax.swing.JOptionPane;

/**
 * En esta interfaz se carga el archivo TXT necesario para inicializar el programa
 * @authors Georgina Akel, Orveo Di Luca, Juan Nunes, Arianne Perret Gentil
 * @version 31/05/2023
 */
public class LoadFile extends javax.swing.JFrame {
    private String fileRoute; 
    private Grafo graph;
    private boolean loaded;
    
    /**
     * Creates new form Inter1
     */
    public LoadFile() {
        initComponents();
        this.graph = new Grafo();
        this.loaded = false;
        setLocationRelativeTo(null);
    }
    
    /**
     * Esta función obtiene la ruta del archivo TXT
     * @return un string con la ruta del archivo TXT
     */
    public String getFileRoute() {
        return fileRoute;
    }
    
    /**
     * Esta función cambia la ruta del archivo TXT
     * @param fileRoute  ruta del archivo TXT
     */
    public void setFileRoute(String fileRoute) {
        this.fileRoute = fileRoute;
    }
    
    /**
     * Esta función obtiene el grafo
     * @return el grafo 
     */
    public Grafo getGraph() {
        return graph;
    }

    /**
     * Esta función cambia el grafo
     * @param graph 
     */
    public void setGraph(Grafo graph) {
        this.graph = graph;
    }
 
    /**
     * Esta función obtiene la ruta del archivo TXT 
     */
    public void getRoute(){       
        Util u = new Util();
        loaded = false;
        fileRoute = u.ObtenerRutaTXT();
        if(fileRoute.endsWith("txt")){
            System.out.println(fileRoute);
            loaded = true;
        }
        
    }
    
    /**
     * Esta función procesa el archivo TXT seleccionado, leyendo su información
     */
    public void loadTXT(){       
        Util u = new Util();
        List newAllPerson = u.read_users(fileRoute);       
        List allEdge = u.read_relations(newAllPerson, fileRoute);
              
        for(int x = 0; x < allEdge.len(); x++){
            Edge edge = (Edge) allEdge.get(x);
            for(int y = 0; y < newAllPerson.len(); y++){
                Vperson person = (Vperson) newAllPerson.get(y);
                if(edge.getStart() == person.getVnum()){
                    List adyList = person.getAdyList();
                    adyList.append(edge);
                    person.setAdyList(adyList);
                    newAllPerson.replace(y, person);
                }
            }
        }              
        graph.setAllPerson(newAllPerson);       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loadFile = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        loadFile.setBackground(new java.awt.Color(0, 153, 204));
        loadFile.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 36)); // NOI18N
        loadFile.setForeground(new java.awt.Color(255, 204, 0));
        loadFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Archivo.png"))); // NOI18N
        loadFile.setText("Cargar archivo");
        loadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFileActionPerformed(evt);
            }
        });
        getContentPane().add(loadFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, 320, 110));

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 0));
        jLabel5.setText("para inicializar su programa.");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, -1, -1));

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("la información necesaria");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, -1, -1));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 0));
        jLabel3.setText("el archivo que contendrá ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, -1, -1));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("A continuación debe cargar ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, -1, -1));

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 0));
        jLabel6.setText("¡Bienvenido Usuario!");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Conduce a la interfaz de InterfaceMain si el archivo se carga con exito
     * @param evt 
     */
    private void loadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFileActionPerformed
        getRoute();
        loadTXT();
//        System.out.println(graph.findName(608));
        if(loaded == true){
            JOptionPane.showMessageDialog(null, "Archivo cargado exitosamente!");
            InterfaceMain inter2 = new InterfaceMain(graph, fileRoute);
            inter2.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_loadFileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoadFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoadFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoadFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoadFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoadFile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loadFile;
    // End of variables declaration//GEN-END:variables
}