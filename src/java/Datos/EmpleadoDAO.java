package Datos;

import Modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class EmpleadoDAO {
   Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Empleado getEmpleado( int idEmpleado){
       Empleado em = new Empleado();
       String sql = "select *from empleado where idempleado=?";
       try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           ps.setInt(1, idEmpleado);
           rs=ps.executeQuery();
           while (rs.next()){
               /*em = new Empleado(
               rs.getInt("idempleado"),
               rs.getString("Nombre"),        
               rs.getString("Apellido"),
               rs.getString("DNI"),
               rs.getString("Domicilio"),
               rs.getString("Telefono"),
               rs.getInt("idSucursal")
               );*/
                //return em;
               em.setIdEmpleado(rs.getInt("idempleado"));
               em.setNombre(rs.getString("Nombre"));
               em.setApellido(rs.getString("Apellido"));
               em.setDNI(rs.getString("DNI"));
               em.setIdSucursal(rs.getInt("idSucursal"));
           } 
            }catch ( SQLException e){
            }
       return em;
    }
}
