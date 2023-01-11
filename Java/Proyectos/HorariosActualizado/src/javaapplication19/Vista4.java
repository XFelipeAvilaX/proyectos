package javaapplication19;

import data.Data;
import data.Docente;
import data.Materia;
import data.Sesion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Vista4 extends JFrame {

    static void setText(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static void setText(List<String> Horas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public JPanel panel;
    public JPanel panel2;
    JTable tabla;
    Color myColor1 = new Color(194, 190, 190);
    Color myColor2 = new Color(177, 205, 227);
    private Connection connect;
    private Statement st;
    private PreparedStatement pstmt;
    public static int columna, row;
    JButton boton1 = new JButton("Asociar Restriccion");
    JButton boton2 = new JButton("Asociar Materias");
    JButton boton3 = new JButton("Ver Materias");

    JButton save;
    Integer indexDocente;
    
    public Vista4() {
        
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setExtendedState(MAXIMIZED_BOTH);
        this.setResizable(false);
        //this.setDefaultCloseOperation(false);
        //this.setVisible(true);
        this.setSize(1200, 500);//establecemos el tamaño de la ventana
        setTitle("Vista 4");
        setLayout(new BorderLayout());

        setLocationRelativeTo(null);//posisiona la ventana en el medio
        
        iniciarComponentes();
        set_table_add_sesiones();
        
    }
    private Vista4 v4 = this;

    public Vista4(int docente) {
        this.indexDocente = docente;
        this.setResizable(false);
        this.setSize(1200, 500);//establecemos el tamaño de la ventana
        setTitle("Vista 4");
        setLayout(new BorderLayout());

        setLocationRelativeTo(null);//posisiona la ventana en el medio

        iniciarComponentes();
        set_table_show_topics();
        
        String p= Integer.toString(docente);
        if(Data.valorDocente.size()>0){
            Data.valorDocente.remove(0);
        }
        Data.valorDocente.add(p);
        
    }

    private void iniciarComponentes() {
        ColocarPaneles(); 

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

        boton1.setName("bt1");
        boton2.setName("bt2");
        boton3.setName("bt3");

        ColocarBotones();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void ColocarBotones() {

    }

    public void set_table_add_sesiones() {

        Object[][] o = new Object[Data.materias.size()][Data.SIZE_COL_MATERIAS];
        for (int i = 0; i < o.length; i++) {
            o[i][0] = Data.materias.get(i).getNombre();
            o[i][1] = Data.materias.get(i).getClave();
            o[i][2] = Data.materias.get(i).getSesiones().toString();
            //o[i][3] = "btn";

        }
        DefaultTableModel modelo = new DefaultTableModel(
                o,
                Data.cabezera
        );

        tabla = new JTable(modelo);
        tabla.setFillsViewportHeight(true);
        tabla.setBackground(myColor2);
        
        tabla.setModel(modelo);

        tabla.setBounds(20, 20, 1170, 300);
        panel.add(tabla, BorderLayout.WEST);

        JScrollPane scroll = new JScrollPane(tabla, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scroll.setBounds(20, 20, 1100, 300);

        panel.add(scroll);

        JButton Volver = new JButton("Volver");
        Volver.setBounds(40, 30, 200, 20);
        panel2.add(Volver);

        JButton Ir = new JButton("Ir");
        Ir.setBounds(80, 30, 200, 20);
        panel2.add(Ir);
        
        JButton Guardar = new JButton("Guardar");
        Guardar.setBounds(120, 30, 200, 20);
        panel2.add(Guardar);
        
        JButton Eliminar = new JButton("Eliminar");
        Eliminar.setBounds(120, 30, 200, 20);
        panel2.add(Eliminar);

        Volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Vista0 v0 = new Vista0();   
                v0.setVisible(true);
                v4.dispose();
            }
        });
        
        Eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              int a;
              
                a=tabla.getSelectedRow();
                
                try {
                    
                    if (a == -1) {
                        JOptionPane.showMessageDialog(null, "Selecciones una materia.", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        
                    Conexion conexion = new Conexion();
                    
                    String clav = tabla.getValueAt(a, 1).toString();
                    String nombreTabla = "SesionMateria"+Data.materias.get(a).getClave();
                    conexion.eliminarMateria(clav);
                    conexion.eliminarMateriaAsociada(clav);
                    conexion.eliminarSesionesMateria(nombreTabla);
                    
                    
                    Data.materias.remove(a);
                    v4.dispose();
                    Vista4 v4 = new Vista4();
                    v4.setVisible(true);
                    
                    //usar doble ciclo for de la vista 4 guardada
                for (int i = 0; i < Data.docente.size(); i++) {
                    //int tamaño = Data.docente.get(i).getMateriasAsociadas().size();
                    Docente d = Data.docente.get(i);//i //posicion de docente
                    
                for (int fd = 0; fd < d.getMateriasAsociadas().size(); fd++) {
 
                 d.getMateriasAsociadas().get(fd).getNombre();//valor fd materias asociadas de docente
                    //System.out.println(d.getMateriasAsociadas().get(fd).getNombre());
                    //System.out.println(tabla.getValueAt(a, 0));
                if(tabla.getValueAt(a, 0)== d.getMateriasAsociadas().get(fd).getNombre()){
                    d.getMateriasAsociadas().remove(fd);//valor fd
                }
                
                //String fd= "";
                //d.getMateriasAsociadas();
                
               // Materia m = Data.materias.get(tabla.getSelectedRow());//valor a//materia seleccionada entre todas
               //d.addMateria(m); //añadir al docente la materia seleccionada
                        
            }
                }
                
                    }
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(rootPane, "Error al eliminar las materias asociadas");

                }
                JOptionPane.showMessageDialog(rootPane, "Materia eliminada con exito");
                
            }
        });
        
        Ir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    int a;
                    
                    a=tabla.getSelectedRow();
                try {
                    
                    if (a == -1) {
                        JOptionPane.showMessageDialog(null, "Selecciones una fila.", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                     new Ventana5(tabla.getSelectedRow());
                    dispose();
        
               
                    }
                } catch (Exception exc) {
                    JOptionPane.showConfirmDialog(null, "No se elimino.", "Error", JOptionPane.ERROR_MESSAGE);

                }
 
            }
        });
        
        Guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a,d,n;
                String b,c;
                int tamaño;
                int pos=0;
                a=tabla.getSelectedRow();
                tamaño = Data.materias.get(a).getSesiones();
                
                try {
                    
                    if (a == -1) {
                        JOptionPane.showMessageDialog(null, "Selecciones una fila.", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        
                    if (tabla.getValueAt(a, 1) != Data.materias.get(a).getClave()){
                          JOptionPane.showMessageDialog(null, "La clave no puede ser modificada");
                          tabla.setValueAt(Data.materias.get(a).getClave(), a, 1);
                          return;
                        }
                    
                    
                    
                    
                
                b=tabla.getValueAt(a, 0).toString();
                c=tabla.getValueAt(a, 1).toString();
                d=Integer.parseInt(tabla.getValueAt(a, 2).toString());
                n=Integer.parseInt(tabla.getValueAt(a, 1).toString());
                
                //System.out.println(Data.materias.get(a).getSesiones());
                
               
            //Data.sesiones;
            
                        
            
                
                Data.materias.get(a).setNombre(b);
//                Data.materias.get(a).setClave(c);
                Data.materias.get(a).setSesiones(d);
                
//                pstmt = (PreparedStatement) (Statement) connect.prepareStatement("UPDATE materias SET sesiones = ?, materia = ? WHERE idclave = ?;", Statement.RETURN_GENERATED_KEYS);
//                pstmt.setString(1, Data.materias.get(a).getSesiones().toString());
//                pstmt.setString(2, Data.materias.get(a).getNombre());
//                pstmt.setInt(3, Integer.parseInt(Data.materias.get(a).getClave()));
//                pstmt.executeUpdate();
                
                
                //Data.sesiones.get(a).setClaveMateria(n);
             
                //(1,1,1,1,2,2,2)
                //(1,1,1,2,2,2)
                
                //Data.sesiones.clear();
                //Sesion s = Data.sesiones.get(a);
                
                //s.getHoras();
                
//            for(int i = 0;i < tamaño; i++){
//                Data.sesiones.remove(a);
//            } 
        
               
                for(int i = 0;i < a; i++){
                pos=pos+Data.materias.get(i).getSesiones();
            }    
//                for(int i = 0;i < tamaño; i++){
//                Data.sesiones.remove(pos);
//            }
//            int cont=0;
            int i;
            int cont=0;
            Sesion se;
            
            if(tamaño==d){
              for(i = 0;i < tamaño; i++){
                
                se =new Sesion(Integer.parseInt(tabla.getValueAt(a, 1).toString()),"Sesion " + (i+1), 0 + "");
                
                //Data.sesiones.add(new Sesion(pos, "Sesion " + (i+1), 0 + ""));
                
                Data.sesiones.set(pos,se);
                
                pos=pos+1;
            }
            }
            if(tamaño<d){
                int añadir= d-tamaño;
            
                for(i = 0;i < tamaño; i++){
                
                se =new Sesion(Integer.parseInt(tabla.getValueAt(a, 1).toString()),"Sesion " + (i+1), 0 + "");
                
                //Data.sesiones.add(new Sesion(pos, "Sesion " + (i+1), 0 + ""));
                
                Data.sesiones.set(pos,se);
                
                pos=pos+1;
                cont=cont+1;
                      }
                for(i = 0;i < añadir;i++){
                   se =new Sesion(Integer.parseInt(tabla.getValueAt(a, 1).toString()),"Sesion " + (cont+1), 0 + "");
                   Data.sesiones.add(pos, se);
                   //Data.sesiones.remove(pos);
                   pos=pos+1;
                   cont=cont+1;
                   
                }   
            }
            
            if(tamaño>d){
                int quitar= tamaño-d;
                
                for(i = 0;i < tamaño; i++){
                
                se =new Sesion(Integer.parseInt(tabla.getValueAt(a, 1).toString()),"Sesion " + (i+1), 0 + "");
                
                //Data.sesiones.add(new Sesion(pos, "Sesion " + (i+1), 0 + ""));
                
                Data.sesiones.set(pos,se);
                
                pos=pos+1;
            }
                pos=pos-quitar;
                for(i = 0;i < quitar;i++){
                   Data.sesiones.remove(pos);  
                }  
            }
            
                
            
//            for(i = 0;i < tamaño; i++){
//                
//                se =new Sesion(Integer.parseInt(tabla.getValueAt(a, 1).toString()),"Sesion " + (i+1), 0 + "");
//                
//                //Data.sesiones.add(new Sesion(pos, "Sesion " + (i+1), 0 + ""));
//                
//                Data.sesiones.set(pos,se);
//                System.out.println("ciclo "+i);
//                System.out.println("valor de pos "+pos);
//                pos=pos+1;
//            }
//            pos=pos-1;







            //cont=cont+pos;
            
//             for (int i = 0; i < Integer.parseInt(tabla.getValueAt(a, 2).toString()); i++) {
//  
//                            Data.sesiones.add(new Sesion(pos, "Sesion " + (i+1), 0 + ""));
//                            pos=pos+1;
//                }   
           
//            for(int i = 0;i < a; i++){
//                pos=pos+Data.materias.get(i).getSesiones();
//            } 
//            //Data.sesiones;
//            //System.out.println(pos);
//                        
//            for(int i = 0;i < Data.materias.get(a).getSesiones(); i++){
//                Data.sesiones.remove(pos);
//            }
            
//            for (int i = 0; i < Integer.parseInt(tabla.getValueAt(a, 2).toString()); i++) {
//  
//                            Data.sesiones.add(new Sesion(Integer.parseInt(tabla.getValueAt(a, 1).toString()), "Sesion " + (i+1), 0 + ""));
//                }
        
                
                
                
                
//                Data.sesiones.clear();
//   
//                for (int i = 0; i < o.length; i++) {
//            for (int fd = 0; fd < Integer.parseInt(tabla.getValueAt(i, 2).toString()); fd++) {
//                
//                            Data.sesiones.add(new Sesion(Integer.parseInt(tabla.getValueAt(i, 1).toString()), "Sesion " + (fd+1), 0 + ""));
//                }
//        }
                 Conexion conexion = new Conexion();
                conexion.updateMateria(new Materia(Data.materias.get(a).getNombre(),Data.materias.get(a).getClave(),Data.materias.get(a).getSesiones()));
                
                String nombreTabla = "SesionMateria"+Data.materias.get(a).getClave();
                conexion.eliminarSesionesMateria(nombreTabla);
                conexion.crearSesionesMateria(nombreTabla);
                
                for(int jk=0;jk<Data.materias.get(a).getSesiones();jk++){
                    conexion.insertarSesionesMateria(nombreTabla, 0);
                }
                
                
                Data.sesiones.clear();               
                for(int jk=0;jk<Data.materias.size();jk++){
            String ClaveBuscada = "SesionMateria"+Data.materias.get(jk).getClave();
            conexion.consultarSesionesMateria(ClaveBuscada, jk);
                }
                
                JOptionPane.showMessageDialog(rootPane, "Datos Guardados con Exito");
               
                    }
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(rootPane, "Error al guardar");

                }
               
                
            }   
                
        });
    }

    public void set_table_show_topics() {
        Object[][] o = new Object[Data.materias.size()][Data.SIZE_COL_MATERIAS_2];
        for (int i = 0; i < o.length; i++) {
            o[i][0] = Data.materias.get(i).getNombre();
            o[i][1] = Data.materias.get(i).getClave();
            o[i][2] = Data.materias.get(i).getSesiones().toString();

        }
        DefaultTableModel modelo2 = new DefaultTableModel(
                o,
                Data.cabezera_2
        );
        tabla = new JTable(modelo2);
        tabla.setFillsViewportHeight(true);
        tabla.setBackground(myColor2);
         
        tabla.setModel(modelo2);

        tabla.setBounds(20, 20, 1170, 300);
        panel.add(tabla, BorderLayout.WEST);

        JScrollPane scroll = new JScrollPane(tabla, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scroll.setBounds(20, 20, 1100, 300);

        panel.add(scroll);

        JButton Guardar = new JButton("Guardar");
        Guardar.setBounds(140, 30, 200, 20);
        panel2.add(Guardar);
        //this.save = new JButton("Guardar");

        JButton Regresar = new JButton("Regresar");
        Regresar.setBounds(80, 30, 200, 20);
        panel2.add(Regresar);
        //this.save = ne333w JButton("Guardar");

        //af.setVisible(false);
          Guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tabla.getSelectedRow() > -1) {
                    //Data.docente.get(indexDocente).addMateria(Data.materias.get(tabla.getSelectedRow()));
                    Docente d = Data.docente.get(indexDocente);
                    
                    int a = tabla.getSelectedRow();
                    //String p= Data.valorDocente.get(0);
                    int p= Integer.parseInt(Data.valorDocente.get(0));
                    
                    
                    
                    for (Materia aux : d.getMateriasAsociadas()) {
                        System.out.println(aux.getNombre());
                    }
                    
                    Materia m = Data.materias.get(tabla.getSelectedRow());
                    boolean repeat = false;
                    for (Materia aux : d.getMateriasAsociadas()) 
                    
                    {
                        if (aux.getNombre().equals(m.getNombre())) {
                            repeat = true;
                            break;
                        }
                    }

                    if (!repeat) {
                        d.addMateria(m);
                        JOptionPane.showMessageDialog(null, " Materia guardada ");
                        
                        
                        //Integer.parseInt(p);
                        
                        Conexion conexion = new Conexion();
                        conexion.insertarMateriasAsocidas(new Materia(Data.materias.get(a).getNombre(),Data.materias.get(a).getClave(),Data.materias.get(a).getSesiones()),p);
                    } else {
                        JOptionPane.showMessageDialog(null, "La materia ya esta asociada, no se puede repetir");
                    }
                    //for (Materia aux : d.getMateriasAsociadas()) {
                    //    System.out.println(aux.getNombre());
                    //}
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una opción");
                }
            }
        });
          
        Regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vista7 ven = new Vista7();
                ven.setVisible(true);
                dispose();
            }
        });
    }

}
