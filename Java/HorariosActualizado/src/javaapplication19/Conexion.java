/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;

import com.mysql.cj.jdbc.Driver;
import data.Data;
import data.Docente;
import data.Materia;
import data.Sesion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author damian
 */
public class Conexion {

    private Connection connect;
    private Statement st;
    private PreparedStatement pstmt;

    String database = "jdbc:mysql://localhost:3306/proyecto";
    String username = "root";
    String password = "123456789";

    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = (Connection) DriverManager.getConnection(database, username, password);
            System.out.println("Conexión realizada");
        } catch (SQLException e) {
            System.err.println("Error en la conexión a la base de datos");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al iniciar el controlador");
        }
    }

    public void cerrarConexion() {
        try {
            connect.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión");
        }
    }

    //METODOS PARA LA TABLA DE DOCENTES
    public void consultarDocentes() {

        try {
            st = (Statement) connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM docentes");
            while (rs.next()) {
                Data.docente.add(new Docente(
                        rs.getString("nombre"),
                        rs.getString("paterno"),
                        rs.getString("materno"),
                        rs.getString("puesto"),
                        rs.getString("clave"))
                );
                Data.situacionTabla.add(rs.getString("restriccionCreada"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            System.err.println("Error al consultar la tabla docentes");
        }
    }

    
    
    public Long insertarDocente(Docente s) {

        try {
            pstmt = (PreparedStatement) (Statement) connect.prepareStatement("INSERT INTO docentes(nombre,paterno,materno,puesto,clave,restriccionCreada) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, s.getNombre());
            pstmt.setString(2, s.getPaterno());
            pstmt.setString(3, s.getMaterno());
            pstmt.setString(4, s.getPuesto());
            pstmt.setString(5, s.getClave());
            pstmt.setString(6, "NO");
            return resultado(pstmt.executeUpdate());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al iniciar la conexión a base de datos");
        }
        return null;
    }

    private Long resultado(int filasAfectadas) throws SQLException {
        Long r = null;
        if (filasAfectadas > 0) {
            try ( ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    r = rs.getLong(1);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        pstmt.close();
        return r;
    }

    //METODOS PARA LA TABLA DE MATERIAS
    public void consultarMaterias() {

        try {
            st = (Statement) connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM materias");
            while (rs.next()) {

                Data.materias.add(new Materia(
                        rs.getString("materia"),
                        rs.getString("idclave"),
                        rs.getInt("sesiones"))
                );
            }

            rs.close();
            st.close();
        } catch (SQLException ex) {
            System.err.println("Error al consultar la tabla sesión");
        }

    }

    
    
    public Long insertarMaterias(Materia m) {
        try {
            pstmt = (PreparedStatement) (Statement) connect.prepareStatement("INSERT INTO materias(materia,idclave,sesiones) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, m.getNombre());
            pstmt.setString(2, m.getClave());
            pstmt.setInt(3, m.getSesiones());


            return resultado(pstmt.executeUpdate());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la materia.");
        }
        return null;
    }


    public Long insertarMateriasAsocidas(Materia s, int p) {
        try {
            pstmt = (PreparedStatement) (Statement) connect.prepareStatement("INSERT INTO materiasasociadas(materia,idclave,sesiones,claveDocente) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, s.getNombre());
            pstmt.setInt(2, Integer.parseInt(s.getClave()));
            pstmt.setInt(3, s.getSesiones());
            pstmt.setInt(4, Integer.parseInt(Data.docente.get(p).getClave()));

            return resultado(pstmt.executeUpdate());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al iniciar la conexión a base de datos materiaAsociada");
        }
        return null;
    }

    public void eliminarMateriaAsociada(String clav) {
        try {
            System.out.println(clav);
            pstmt = (PreparedStatement) (Statement) connect.prepareStatement("DELETE FROM materiasasociadas WHERE idclave = ?");
            pstmt.setInt(1, Integer.parseInt(clav));
            pstmt.executeUpdate();
            System.out.println("eliminado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al iniciar la conexión a base de datos. asocida");
        }
    }
    
    public void eliminarMateriaAsociadasDocente(String clav) {
        try {
            System.out.println(clav);
            pstmt = (PreparedStatement) (Statement) connect.prepareStatement("DELETE FROM materiasasociadas WHERE claveDocente = ?");
            pstmt.setInt(1, Integer.parseInt(clav));
            pstmt.executeUpdate();
            System.out.println("eliminado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al iniciar la conexión a base de datos. asocida");
        }
    }
    
    public void crearRestricciones(String nombreTabla) {
        try {
            
            pstmt = (PreparedStatement) (Statement) connect.prepareStatement("CREATE TABLE IF NOT EXISTS "+nombreTabla+"(id int NOT NULL AUTO_INCREMENT, dia varchar(60) NOT NULL,idHorarios int NOT NULL, valorRestriccion int NOT NULL, idDocente int NOT NULL, PRIMARY KEY(id))");
            pstmt.executeUpdate();
            System.out.println("creado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al iniciar la conexión a base de datos. L154");
        }
    }
    
    public void crearSesionesMateria(String nombreTabla) {
        try {
            
            pstmt = (PreparedStatement) (Statement) connect.prepareStatement("CREATE TABLE IF NOT EXISTS "+nombreTabla+"(id int NOT NULL AUTO_INCREMENT, Sesion varchar(60) NOT NULL,Hora int NOT NULL, PRIMARY KEY(id))");
            pstmt.executeUpdate();
            System.out.println("creado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al iniciar la conexión a base de datos. L154");
        }
    }
    
    public Long insertarSesionesMateria(String nombreTabla2, int i) {
        try {
            String strQuery = "INSERT INTO $tableName (Sesion, Hora) VALUES (?,?);";
            
            String query =strQuery.replace("$tableName",nombreTabla2);

            pstmt = (PreparedStatement) (Statement) connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
             
                pstmt.setString(1, "Sesion"+(i+1));
                pstmt.setInt(2, 0);


            return resultado(pstmt.executeUpdate());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la materia.");
        }
        return null;
    }
    
    public void eliminarSesionesMateria(String claveMateria) {
        try {
            pstmt = (PreparedStatement) (Statement) connect.prepareStatement("DROP TABLE "+claveMateria);
            pstmt.executeUpdate();
            System.out.println("eliminado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al iniciar la conexión a base de datos. L154");
        }
    }
    
    
    //////////////2
    public Long updateSesionesMateria(String nombreTabla2, int i, int horaPedida) {
        try {
            String strQuery = "Update $tableName SET Hora = ? WHERE id = ?;";
            
            String query =strQuery.replace("$tableName",nombreTabla2);

            pstmt = (PreparedStatement) (Statement) connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setInt(1, horaPedida);
            pstmt.setInt(2, i+1);
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la materia.");
        }
        return null;
    }
    
    public void consultarSesionesMateria(String nombreTabla2, int i) {

        try {
            st = (Statement) connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM "+nombreTabla2);
            while (rs.next()) {              
                Data.sesiones.add(new Sesion(Integer.parseInt(Data.materias.get(i).getClave()), "Sesion " + (rs.getString("id")), rs.getString("Hora")));
            }

            rs.close();
            st.close();
        } catch (SQLException ex) {
            System.err.println("Error al consultar la tabla horas docente");
        }

    }
    
    
    public void consultarHorasDocente(String nombreTabla) {

        try {
            st = (Statement) connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM "+nombreTabla);
            while (rs.next()) {
                Data.HorasDocente.add(rs.getString("hora"));
            }

            rs.close();
            st.close();
        } catch (SQLException ex) {
            System.err.println("Error al consultar la tabla horas docente");
        }

    }
    
    public void consultarRestriccionesDocente(String nombreTabla2) {

        try {
            st = (Statement) connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM "+nombreTabla2);
            while (rs.next()) {
                Data.RestriccionesDocente.add(rs.getString("valorRestriccion"));
            }

            rs.close();
            st.close();
        } catch (SQLException ex) {
            System.err.println("Error al consultar la tabla horas docente");
        }

    }
    
    
    public Long insertarRestricciones(String nombreTabla2, String Dia, int j,int i,int valorPosicion ,int claveDocente) {
        try {
            String strQuery = "INSERT INTO $tableName (dia,idHorarios,valorRestriccion,idDocente) VALUES (?,?,?,?);";
            
            String query =strQuery.replace("$tableName",nombreTabla2);

            pstmt = (PreparedStatement) (Statement) connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
             
                pstmt.setString(1, Dia);
                pstmt.setInt(2, i+1);
                pstmt.setInt(3, Integer.parseInt(Data.docente.get(valorPosicion).getRestrcciones()[j][i]));
                pstmt.setInt(4, claveDocente);
            
            

            return resultado(pstmt.executeUpdate());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la materia.");
        }
        return null;
    }
    
    
    public void eliminarRestricciones(String claveDocente) {
        try {
            pstmt = (PreparedStatement) (Statement) connect.prepareStatement("DROP TABLE "+claveDocente);
            pstmt.executeUpdate();
            System.out.println("eliminado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al iniciar la conexión a base de datos. L154");
        }
    }
    
    
    
    
    public void crearHorasDocente(String nombreTabla) {
        try {
            
            pstmt = (PreparedStatement) (Statement) connect.prepareStatement("CREATE TABLE IF NOT EXISTS "+nombreTabla+"(idhorarios int NOT NULL,hora varchar(60) NOT NULL, PRIMARY KEY(idhorarios))");
            pstmt.executeUpdate();
            System.out.println("creado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al iniciar la conexión a base de datos. L154");
        }
    }
    
    public Long insertarHorasDocente(int i,String nombreTabla2) {
        try {
            String strQuery = "INSERT INTO $tableName (idhorarios,hora) VALUES (?,?);";
            
            String query =strQuery.replace("$tableName",nombreTabla2);
            
                  
            String s = Integer.toString((i + 1));
            pstmt = (PreparedStatement) (Statement) connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, s);
            pstmt.setString(2, Data.horarios.get(i));
            
            return resultado(pstmt.executeUpdate());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la materia.");
        }
        return null;
    }
    
    
    public void eliminarHorasDocente(String claveDocente) {
        try {
            pstmt = (PreparedStatement) (Statement) connect.prepareStatement("DROP TABLE "+claveDocente);
            pstmt.executeUpdate();
            System.out.println("eliminado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al iniciar la conexión a base de datos. L154");
        }
    }
    

    public void updateMateria(Materia s) {
        try {

            pstmt = (PreparedStatement) (Statement) connect.prepareStatement("UPDATE materias SET sesiones = ?, materia = ? WHERE idclave = ?;", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, s.getSesiones().toString());
            pstmt.setString(2, s.getNombre());
            pstmt.setInt(3, Integer.parseInt(s.getClave()));
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al iniciar la conexión a base de datos. L128");
        }
    }
    
    
    public void updateTablaDocenteRestriccionSI(int claveDocente) {
        try {

            pstmt = (PreparedStatement) (Statement) connect.prepareStatement("UPDATE docentes SET restriccionCreada = ? WHERE clave = ?;", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, "SI");   
            pstmt.setInt(2, claveDocente);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al iniciar la conexión a base de datos. L128");
        }
    }

    public void eliminarMateria(String clav) {
        try {
            pstmt = (PreparedStatement) (Statement) connect.prepareStatement("DELETE FROM materias WHERE idclave = ?");
            pstmt.setInt(1, Integer.parseInt(clav));
            pstmt.executeUpdate();
            System.out.println("eliminado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al iniciar la conexión a base de datos. L154");
        }
    }

    public void consultarMateriasAsociadas() {
            
        try {
            st = (Statement) connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM materiasasociadas");
            
            while (rs.next()) {

                for (int i = 0; i < Data.docente.size(); i++) {
                    int comparativa = Integer.parseInt(Data.docente.get(i).getClave());
                    if (comparativa == rs.getInt("claveDocente")) {
                        
                        Docente d = Data.docente.get(i);
                        
                        int p = rs.getInt("idclave");
                        String c = String.valueOf(p);

                        d.addMateria(new Materia(rs.getString("materia"), c, rs.getInt("sesiones")));
                    }
                }

            }

            rs.close();
            st.close();
        } catch (SQLException ex) {
            System.err.println("Error al consultar la tabla materiasAsociadas");
        }

    }

    //METODOS PARA LA TABLA DE Horario
    public void consultarHorario() {

        try {
            st = (Statement) connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM horarios");
            while (rs.next()) {

                Data.horarios.add(rs.getString("hora"));

            }

            rs.close();
            st.close();
        } catch (SQLException ex) {
            System.err.println("Error al consultar la tabla sesión");
        }

    }

    public Long insertarHorario(int i) {
        try {
            String s = Integer.toString((i + 1));
            pstmt = (PreparedStatement) (Statement) connect.prepareStatement("INSERT INTO horarios(hora,idhorarios) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, Data.horarios.get(i));
            pstmt.setString(2, s);
            return resultado(pstmt.executeUpdate());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al iniciar la conexión a base de datos. L76");
        }
        return null;
    }

    public void eliminarHorario(int i) {
        try {
            pstmt = (PreparedStatement) (Statement) connect.prepareStatement("DELETE FROM horarios WHERE idhorarios = ?");
            pstmt.setInt(1, i);
            pstmt.executeUpdate();
            System.out.println("eliminado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al iniciar la conexión a base de datos. L154");
        }
    }

    public void eliminarDocente(String id) {
        try {
            pstmt = (PreparedStatement) (Statement) connect.prepareStatement("DELETE FROM docentes WHERE clave = ?");
            pstmt.setInt(1, Integer.parseInt(id));
            pstmt.executeUpdate();
            System.out.println("eliminado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al iniciar la conexión a base de datos. L154");
        }
    }
    
  
    public void eliminarUnaMateriaAsociada(int clav, String claveDocente) {
        try {

            pstmt = (PreparedStatement) (Statement) connect.prepareStatement("DELETE FROM materiasasociadas WHERE idclave = ? AND claveDocente = ?");

            pstmt.setInt(1, clav);
            pstmt.setInt(2, Integer.parseInt(claveDocente));

            System.out.println(clav);
            System.out.println(claveDocente);

            pstmt.executeUpdate();
            System.out.println("eliminado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al iniciar la conexión a base de datos. L154");
        }
    }

    public void updateDoccente(Docente s) {
        try {

            pstmt = (PreparedStatement) (Statement) connect.prepareStatement("UPDATE docentes SET nombre= ?, paterno = ? , materno= ?, puesto = ? WHERE clave = ?;", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, s.getNombre());
            pstmt.setString(2, s.getPaterno());
            pstmt.setString(3, s.getMaterno());
            pstmt.setString(4, s.getPuesto());
            pstmt.setInt(5, Integer.parseInt(s.getClave()));

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al iniciar la conexión a base de datos. L128");
        }
    }

}
