package javaapplication19;

import data.Data;
import data.Docente;
import java.awt.Color;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jesus antonio
 */
public class Ventana_6 extends javax.swing.JFrame {

    Integer p1 = 0;
    Object[][] data;
    Docente docente;
    Color myColor1 = new Color(177, 205, 227);
    Color myColor2 = new Color(255, 175, 175);

    public Ventana_6(int docente) {
        this.docente = Data.docente.get(docente);
        this.docente.setRestrcciones(null);
        this.docente.iniRestricciones();
        this.getContentPane().setBackground(myColor1);
        
        String p= Integer.toString(docente);
        if(Data.valorDocente3.size()>0){
            Data.valorDocente3.remove(0);
        }
        Data.valorDocente3.add(p);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
//        if(Data.horarios.isEmpty()){
//                Conexion conexion = new Conexion();   
//                for (int i=0; i<Data.horarios.size();i++){
//                    conexion.insertarHorario(i);
//                }  
//        }
//        else{
//            int horariosSize=Data.horarios.size();
//            Data.horarios.removeAll(Data.horarios);
//            Conexion conexion = new Conexion();
//            for (int i=0; i<=horariosSize;i++){
//                    conexion.eliminarHorario(i);
//                }
//                for (int i=0; i<Data.horarios.size();i++){
//                    conexion.insertarHorario(i);
//                }
//            
//        }
        
        int size = Data.horarios.size();
        
        if (size >= 1) {
            initComponents();
            String c[] = new String[size];
            for (int i = 0; i < size; i++) {
                c[i] = Data.horarios.get(i);
            }
            jtable.setModel(new DefaultTableModel(this.docente.getRestrcciones(), c));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        jbuton = new javax.swing.JButton();
        jbuton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtable.setBackground(new java.awt.Color(255, 175, 175));
        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14"
            }
        ));
        jtable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jtable);

        jbuton.setText("GUARDAR");
        jbuton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutonActionPerformed(evt);
            }
        });

        jbuton1.setText("REGRESAR");
        jbuton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuton1ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(255, 175, 175));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"LUNES"},
                {"MARTES"},
                {"MIERCOLES"},
                {"JUEVES"},
                {"VIERNES"},
                {"SABADO"}
            },
            new String [] {
                "DIAS"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jbuton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(325, 325, 325)
                        .addComponent(jbuton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutonActionPerformed
        int p= Integer.parseInt(Data.valorDocente3.get(0));
        String nombreTabla = Data.docente.get(p).getClave();
        Conexion conexion = new Conexion();
        int claveDocente = Integer.parseInt(Data.docente.get(p).getClave());
        int valorPosicion = Integer.parseInt(Data.valorDocente3.get(0));
        String nombreTabla2="docente"+nombreTabla;
        String nombreTabla3="horario"+nombreTabla;
        
        
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < Data.horarios.size(); j++) {
                this.docente.getRestrcciones()[i][j] = this.jtable.getModel().getValueAt(i, j).toString();//ACTUALIZA EL MODELO CON LAS RESTRICCIONES DEL DOCENTE
            }
        }
        switch(Data.situacionTabla.get(valorPosicion)){
            case "SI": 
                    conexion.eliminarRestricciones("docente"+nombreTabla);
                    conexion.eliminarHorasDocente(nombreTabla3);
                    conexion.crearRestricciones("docente"+nombreTabla);
                    for(int i=0;i<Data.horarios.size();i++){
            String Dia = "LUNES";
            int j=0;
            conexion.insertarRestricciones(nombreTabla2, Dia, j,i, valorPosicion, claveDocente);
        }
        for(int i=0;i<Data.horarios.size();i++){
            String Dia = "MARTES";
            int j=1;
            conexion.insertarRestricciones(nombreTabla2, Dia, j,i, valorPosicion, claveDocente);
        }
        for(int i=0;i<Data.horarios.size();i++){
            String Dia = "MIERCOLES";
            int j=2;
            conexion.insertarRestricciones(nombreTabla2, Dia, j,i, valorPosicion, claveDocente);
        }
        for(int i=0;i<Data.horarios.size();i++){
            String Dia = "JUEVES";
            int j=3;
            conexion.insertarRestricciones(nombreTabla2, Dia, j,i, valorPosicion, claveDocente);
        }
        for(int i=0;i<Data.horarios.size();i++){
            String Dia = "VIERNES";
            int j=4;
            conexion.insertarRestricciones(nombreTabla2, Dia, j,i, valorPosicion, claveDocente);
        }
        for(int i=0;i<Data.horarios.size();i++){
            String Dia = "SABADO";
            int j=5;
            conexion.insertarRestricciones(nombreTabla2, Dia, j,i, valorPosicion, claveDocente);
        }
                    break; //sirve para no ejecutar los demas casos despues del correcto
            case "NO": 
                    conexion.crearRestricciones("docente"+nombreTabla);
                    
        for(int i=0;i<Data.horarios.size();i++){
            String Dia = "LUNES";
            int j=0;
            conexion.insertarRestricciones(nombreTabla2, Dia, j,i, valorPosicion, claveDocente);
        }
        for(int i=0;i<Data.horarios.size();i++){
            String Dia = "MARTES";
            int j=1;
            conexion.insertarRestricciones(nombreTabla2, Dia, j,i, valorPosicion, claveDocente);
        }
        for(int i=0;i<Data.horarios.size();i++){
            String Dia = "MIERCOLES";
            int j=2;
            conexion.insertarRestricciones(nombreTabla2, Dia, j,i, valorPosicion, claveDocente);
        }
        for(int i=0;i<Data.horarios.size();i++){
            String Dia = "JUEVES";
            int j=3;
            conexion.insertarRestricciones(nombreTabla2, Dia, j,i, valorPosicion, claveDocente);
        }
        for(int i=0;i<Data.horarios.size();i++){
            String Dia = "VIERNES";
            int j=4;
            conexion.insertarRestricciones(nombreTabla2, Dia, j,i, valorPosicion, claveDocente);
        }
        for(int i=0;i<Data.horarios.size();i++){
            String Dia = "SABADO";
            int j=5;
            conexion.insertarRestricciones(nombreTabla2, Dia, j,i, valorPosicion, claveDocente);
        }
                    break;
            default: 
                    JOptionPane.showMessageDialog(null, "Error");
                            
        }
        conexion.crearHorasDocente(nombreTabla3);
        
        for (int i=0; i<Data.horarios.size();i++){
                    conexion.insertarHorasDocente(i,nombreTabla3);
                }
        
        
        conexion.updateTablaDocenteRestriccionSI(claveDocente);
        Data.situacionTabla.set(valorPosicion, "SI");
        JOptionPane.showMessageDialog(null, "Guardado Exitoso");
    }//GEN-LAST:event_jbutonActionPerformed

    private void jbuton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuton1ActionPerformed
        // TODO add your handling code here:
        Vista7 v4 = new Vista7();
        v4.setVisible(true);
        dispose();
    }//GEN-LAST:event_jbuton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbuton;
    private javax.swing.JButton jbuton1;
    private javax.swing.JTable jtable;
    // End of variables declaration//GEN-END:variables

}
