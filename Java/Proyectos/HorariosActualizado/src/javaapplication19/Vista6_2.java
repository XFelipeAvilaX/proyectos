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

public class Vista6_2 extends JFrame {
        Integer p1 = 0;
    Object[][] data;
        Integer v1;
    
    Docente docente;

    private Vista6_2 v6_2 = this;
    public JPanel panel;
    public JPanel panel2;
    JTable tabla;
    Color myColor1 = new Color(194, 190, 190);
    Color myColor2 = new Color(177, 205, 227);

    public static int columna, row;
    JButton boton1 = new JButton("Asociar Restriccion");
    JButton boton2 = new JButton("Asociar Materias");
    JButton boton3 = new JButton("Ver Materias");

    // private Object panel;
    public Vista6_2() {
        int docente = 0;
        this.v1 = docente;
        
        //super("Vista 7");
        this.setSize(1200, 500);//establecemos el tamaño de la ventana
        setTitle("Restricciones Guardadas");
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

        ColocarBotones();
    }

    private void ColocarBotones() {

        JButton btnR = new JButton("Regresar");

        

        panel2.add(btnR, BorderLayout.WEST);//
        

        ActionListener regresar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Vista7 v7 = new Vista7();
                v7.setVisible(true);
                dispose();
            }
        };
        btnR.addActionListener(regresar);

        

    }

    private void ColocarTablas() {
        
        this.docente = Data.docente.get(v1);
        this.docente.iniRestricciones();
        int size = Data.HorasDocente.size()+1;
       if (size >= 1) {
           
        String c[] = new String[size];
            c[0] = "Dias";
            for (int i = 1; i < size; i++) {
                c[i] = Data.HorasDocente.get(i-1);
            }   
           
       DefaultTableModel modelo = new DefaultTableModel(this.docente.getRestrcciones(), c);
       
       
    
//       String [ ] a ={"Lunes"};
//       String [ ] b ={"Martes"};
//       String [ ] c ={"Miercoles"};
//       String [ ]d ={"Jueves"};
//       String [ ] e ={"Viernes"};
//       String [ ] f ={"Sabado"};
//       
//       modelo.addRow(a);
//       modelo.addRow(b);
//       modelo.addRow(c);
//       modelo.addRow(d);
//       modelo.addRow(e);
//       modelo.addRow(f);
//       
//        
//        
//       modelo.addColumn("Lunes");
//        modelo.addColumn("Martes");
//        modelo.addColumn("Miercoles");
//        modelo.addColumn("Jueves");
//        modelo.addColumn("Viernes");
//        modelo.addColumn("Sabado");

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
        
        tabla.setValueAt("LUNES", 0, 0);
        tabla.setValueAt("MARTES", 1, 0);
        tabla.setValueAt("MIERCOLES", 2, 0);
        tabla.setValueAt("JUEVES", 3, 0);
        tabla.setValueAt("VIERNES", 4, 0);
        tabla.setValueAt("SABADO", 5, 0);
        
        
        int Total = 0;
        
        
        for(int i=1;i<=Data.HorasDocente.size();i++){
            tabla.setValueAt(Data.RestriccionesDocente.get(Total), 0, i);
            Total = Total+1;
        }
        for(int i=1;i<=Data.HorasDocente.size();i++){
            tabla.setValueAt(Data.RestriccionesDocente.get(Total), 1, i);
            Total = Total+1;
        }
        for(int i=1;i<=Data.HorasDocente.size();i++){
            tabla.setValueAt(Data.RestriccionesDocente.get(Total), 2, i);
            Total = Total+1;
        }
        for(int i=1;i<=Data.HorasDocente.size();i++){
            tabla.setValueAt(Data.RestriccionesDocente.get(Total), 3, i);
            Total = Total+1;
        }
        for(int i=1;i<=Data.HorasDocente.size();i++){
            tabla.setValueAt(Data.RestriccionesDocente.get(Total), 4, i);
            Total = Total+1;
        }
        for(int i=1;i<=Data.HorasDocente.size();i++){
            tabla.setValueAt(Data.RestriccionesDocente.get(Total), 5, i);
            Total = Total+1;
        }
        Total=0;
    }
    }
    
    ///miissssssssssaaaaaaaaa

}
