package javaapplication19;

import data.Data;
import data.Docente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class Vista7 extends JFrame {

    private Vista7 v7 = this;
    public JPanel panel;
    public JPanel panel2;
    JTable tabla;
    Color myColor1 = new Color(194, 190, 190);
    Color myColor2 = new Color(177, 205, 227);

    public static int columna, row;
    JButton boton1 = new JButton("Asociar Restriccion");
    JButton boton2 = new JButton("Asociar Materias");
    JButton boton3 = new JButton("Ver Materias");
    JButton boton4 = new JButton("Ver Restriccion");
    
    // private Object panel;
    public Vista7() {
        //super("Vista 7");
        this.setSize(1200, 500);//establecemos el tamaño de la ventana
        setTitle("Vista 7");
        setLayout(new BorderLayout());

        setLocationRelativeTo(null);//posisiona la ventana en el medio
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
        //ColocarTablas();
    }

    private void iniciarComponentes() {
        ColocarPaneles();

        //ColocarTablas();
        //ColocarBotones();
    }

    private void ColocarPaneles() {
        panel = new JPanel();//creacion de un panel
        panel.setLayout(null);
        panel.setLayout(new BorderLayout());

        //panel.setLayout(new FlowLayout());
        this.getContentPane().add(panel, BorderLayout.NORTH);
        this.getContentPane().setBackground(myColor1);

        panel2 = new JPanel();
        panel.setLayout(null);
        panel.setLayout(new BorderLayout());
        this.getContentPane().add(panel2, BorderLayout.SOUTH);
        panel2.setBackground(myColor1);

        //panel2.setBackground(Color.blue);
        ColocarTablas();
        boton1.setName("bt1");
        boton2.setName("bt2");
        boton3.setName("bt3");
        boton4.setName("bt4");
        
        ColocarBotones();
    }

    private void ColocarBotones() {

        JButton btnR = new JButton("Regresar al menu");
        JButton asociar = new JButton("Asociar Materias");
        JButton verMaterias = new JButton("Ver Materias Asociadas");
        JButton restricciones = new JButton("Asociar Restricciones");
        JButton eliminar = new JButton("Eliminar Docente");
        JButton actualizar = new JButton("Actualizar Docente");
        JButton verRestricciones = new JButton("Ver Restricciones");

        //btnR.setBounds(160, 330, 150, 25);
        //panel.setLayout(null);
        panel2.add(btnR, BorderLayout.WEST);//

        panel2.add(asociar, BorderLayout.LINE_END);
        panel2.add(verMaterias, BorderLayout.LINE_END);
        panel2.add(restricciones, BorderLayout.LINE_END);
        panel2.add(eliminar, BorderLayout.LINE_END);
        panel2.add(actualizar, BorderLayout.LINE_END);
        panel2.add(verRestricciones,BorderLayout.LINE_END);
        
        
        ActionListener regresar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Vista0 menu = new Vista0();
                menu.setVisible(true);
                dispose();
            }
        };
        btnR.addActionListener(regresar);

        restricciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tabla.getSelectedRow() > -1) {
                    if (Data.horarios.size() > 0) {

                        Ventana_6 v6 = new Ventana_6(tabla.getSelectedRow());
                        v6.setVisible(true);
                        v7.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingrese los horarios para asociar restrcciones");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un docente para continuar");
                }
            }
        });
        

        asociar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tabla.getSelectedRow() > -1) {
                    // Docente d = Data.docente.get(tabla.getSelectedRow());
                    if (Data.materias.size() > 0) {

                        Vista4 v4 = new Vista4(tabla.getSelectedRow());
                        v4.setVisible(true);
                        v7.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Sin materias agregadas");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un docente para continuar");
                }

            }
        });
        
        verRestricciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tabla.getSelectedRow() > -1) {
                    // Docente d = Data.docente.get(tabla.getSelectedRow());
                    int a=tabla.getSelectedRow();
                    
                    switch(Data.situacionTabla.get(a)){
            case "SI": 
                    
                    break; //sirve para no ejecutar los demas casos despues del correcto
            case "NO": 
                    JOptionPane.showMessageDialog(null, "Primero Genera una restriccion para este docente");
                    return;
            default: 
                     JOptionPane.showMessageDialog(null, "Error");
                     return;
                            
        }
                    
                    String nombreTabla="horario"+Data.docente.get(a).getClave();
                    String nombreTabla2="docente"+Data.docente.get(a).getClave();
                    
                    Conexion conexion = new Conexion();
                    if(Data.HorasDocente.isEmpty()){
                        conexion.consultarHorasDocente(nombreTabla);
                        conexion.consultarRestriccionesDocente(nombreTabla2);
                    }
                    else{
                        Data.HorasDocente.clear();
                        Data.RestriccionesDocente.clear();
                        conexion.consultarHorasDocente(nombreTabla);
                        conexion.consultarRestriccionesDocente(nombreTabla2);
                    }
                    
                    Vista6_2 v6_2 = new Vista6_2();
                    v6_2.setVisible(true);
                    v7.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un docente para continuar");
                }
            }
        });
        
        
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tabla.getSelectedRow() > -1) {
                    
                int a;
                String nom,pate,mate,pues,cla;
                
                a=tabla.getSelectedRow();
                
                nom=tabla.getValueAt(a, 0).toString();
                pate=tabla.getValueAt(a, 1).toString();
                mate=tabla.getValueAt(a, 2).toString();
                pues=tabla.getValueAt(a, 3).toString();
                cla=tabla.getValueAt(a, 4).toString();
                
                Data.docente.get(a).setNombre(nom);
                Data.docente.get(a).setPaterno(pate);
                Data.docente.get(a).setMaterno(mate);
                Data.docente.get(a).setPuesto(pues);
                Data.docente.get(a).setClave(cla);
                
                String f1=Data.docente.get(a).getNombre();
                String f2=Data.docente.get(a).getPaterno();
                String f3=Data.docente.get(a).getMaterno();
                String f4=Data.docente.get(a).getPuesto();
                String f5=Data.docente.get(a).getClave();




                
                
                
                Conexion conexion = new Conexion();
         //       conexion.updateDocente((new Docente(Data));
         conexion.updateDoccente(new Docente(f1,f2,f3,f4,f5));
                
                JOptionPane.showMessageDialog(null, "Docente Actualizado");
                
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un docente para continuar");
                }

            }
        });
        
            eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
               int a, b;

                
                    a = tabla.getSelectedRow();
                    if (a == -1) {
                        JOptionPane.showMessageDialog(null, "Selecciones la fila.", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        b = JOptionPane.showConfirmDialog(null, "¿Esta Seguro?", "Eliminar", JOptionPane.YES_NO_OPTION);
                        if (b == JOptionPane.YES_OPTION) {

                            Conexion conexion = new Conexion();
                            String nombreTabla = Data.docente.get(a).getClave();
                            String clav = Data.docente.get(a).getClave();
                            conexion.eliminarDocente(clav);
                            String clav2= "horario"+clav;
                            if(Data.docente.get(a).getMateriasAsociadas().isEmpty()){
                                
                            }
                            else{
                                conexion.eliminarMateriaAsociadasDocente(clav);
                            }
                            
                            
                            
            switch(Data.situacionTabla.get(a)){
                
            case "SI": 
                    conexion.eliminarRestricciones("docente"+nombreTabla);
                    conexion.eliminarHorasDocente(clav2);
                    break; //sirve para no ejecutar los demas casos despues del correcto
            case "NO": 
                    
                    break;
            default: 
                    
                            
        }
                            
                            conexion.cerrarConexion();
                            
                            Data.situacionTabla.remove(a);
                            Data.docente.remove(a);

                            DefaultTableModel m = (DefaultTableModel) tabla.getModel();
                            m.removeRow(a);

                        }
                    }

            }
        });

        verMaterias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tabla.getSelectedRow() > -1) {

                    Docente d = Data.docente.get(tabla.getSelectedRow());

                    if (d.getMateriasAsociadas().size() > 0) {
                        // for (Materia m : d.getMateriasAsociadas()) {

                        //String var1 = m.getNombre();
                        Vista8 v8 = new Vista8(tabla.getSelectedRow());
                        v8.setVisible(true);
                        v7.dispose();

                        //System.out.println(m.getNombre() + " " + m.getClave() + " " + m.getSesiones());
                        // }
                    } else {
                        JOptionPane.showMessageDialog(null, "Sin materias asociadas");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un docente para continuar");
                }

            }
        });

    }

    private void ColocarTablas() {

        Object[][] o = new Object[Data.docente.size()][Data.SIZE_COL_DOCENTE];
        for (int i = 0; i < o.length; i++) {
            o[i][0] = Data.docente.get(i).getNombre();
            o[i][1] = Data.docente.get(i).getPaterno();
            o[i][2] = Data.docente.get(i).getMaterno();
            o[i][3] = Data.docente.get(i).getPuesto();
            o[i][4] = Data.docente.get(i).getClave();

        }

        DefaultTableModel modelo = new DefaultTableModel(
                o,
                Data.TITLE_COL_DOCENTE
        );

        tabla = new JTable(modelo);
        tabla.setFillsViewportHeight(true);
        tabla.setBackground(myColor2);

        
        tabla.setModel(modelo);
        tabla.setBounds(20, 20, 1170, 300);
        panel.setBackground(Color.blue);
        panel.add(tabla, BorderLayout.WEST);

        JScrollPane scroll = new JScrollPane(tabla, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(20, 20, 1100, 300);

        panel.add(scroll);
    }
    private void actualizar (){
        int fila = tabla.getSelectedRow();
        
        String nom = tabla.getValueAt(fila,1).toString();
        String pate = tabla.getValueAt(fila,2).toString();
        String mate = tabla.getValueAt(fila,3).toString();
        String pues = tabla.getValueAt(fila,4).toString();
        String clav = tabla.getValueAt(fila,5).toString();
        
        
    }
    
    ///miissssssssss

}
