/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import database.AccesoDB;
import entity.Linea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import service.ICrudDao;

/**
 *
 * @author GINA HUERTAS
 */
public class LineaDao implements ICrudDao<Linea> {
    //variables

    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    Linea linea;
    String sql;
    Linea lin;
    int res;
    int r = 0;

    @Override
    public int create(Linea c) throws Exception {
        try {
            //obtenemos la conexion a la bd
            cn = AccesoDB.getConnection();
            sql = "insert into lineas(nombre,fecha) values(?,?)";
            ps = cn.prepareStatement(sql);
            //preparar los valores de los parametros del comando
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getFecha());

            //ejecutar comando
            r = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (SQLException e1) {
            }
        }
        return r;
    }

    @Override
    public int update(Linea t) throws Exception {
        try {
            cn = AccesoDB.getConnection();
            sql = "update lineas set nombre=?,fecha=?"
                    + " where idlinea=?";
            ps = cn.prepareStatement(sql);
            //preparar los valores de los parametros del comando
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getFecha());
            ps.setInt(3, t.getIdlinea());
            //ejecutar
            res = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
            }
        }
        return res;
    }

    @Override
    public int delete(Linea t) throws Exception {
         try {
            cn = AccesoDB.getConnection();
            sql = "delete  from lineas where idlinea=?";
            ps = cn.prepareStatement(sql);
            //prepara el valor del parametro del comando
            ps.setInt(1, t.getIdlinea());
            //ejecuta
            res = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
            }
        }
        return res;
    }

    @Override
    public Linea findById(String t) throws Exception {
        lin = null;
        try {
            cn = AccesoDB.getConnection();
            ps = cn.prepareStatement("select * from lineas where idlinea=?");
            //preparar valor del parametro
            ps.setString(1, t);
            //ejecuta la consulta
            rs = ps.executeQuery();

            if (rs.next()) {
                lin = new Linea(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            cn.close();
        }
        return lin;
    }

    @Override
    public List<Linea> readAll() throws Exception {

        List<Linea> lista = new ArrayList<>();
        try {
            cn = AccesoDB.getConnection();
            ps = cn.prepareStatement("select * from lineas order by idlinea");
            rs = ps.executeQuery();
            while (rs.next()) {
                linea = new Linea(rs.getInt(1), rs.getString(2), rs.getString(3));
                lista.add(linea);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            cn.close();
        }
        return lista;

    }

}
