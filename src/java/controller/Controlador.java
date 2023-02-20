/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Linea;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.LineaDao;

/**
 *
 * no salia porque borre @WebServle no borre la linea de abajo
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    LineaDao dao;
    List<Linea> lineas = new ArrayList<>();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();
        String accion = request.getParameter("accion");
        try {
            switch (accion) {

                case "listar":
                    listar(request, response);
                    break;
                case "agregar":
                    agregar(request, response);
                    break;
                case "Actualizar":
                    actualizar(request, response);
                    break;
                case "Delete":
                    eliminar(request, response);
                    break;
                case "editar":
                    editar(request, response);
                    break;
                case "nuevo":
                    nuevo(request, response);
                    break;
            }
        } catch (Exception ex) {
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        dao = new LineaDao();
        lineas = dao.readAll();
        request.setAttribute("lista", lineas);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    private void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        int r = 0;
        String nombre = request.getParameter("txtnombre");
        String fecha = request.getParameter("txtfecha");

        Linea l = new Linea();
        l.setNombre(nombre);
        l.setFecha(fecha);

        dao = new LineaDao();
        r = dao.create(l);
        if (r != 0) {
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "linea registrado con exito!");
            request.getRequestDispatcher("mensaje.jsp").forward(request, response);
        } else {
            request.setAttribute("config", "alert alert-danger");
            request.setAttribute("mensaje", "Error al registrar linea en la BD");
            request.getRequestDispatcher("mensaje.jsp").forward(request, response);
        }
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        String codigo = request.getParameter("txtId");
        String nombre = request.getParameter("txtnombre");
        String fecha = request.getParameter("txtfecha");

        Linea lin = new Linea(Integer.parseInt(codigo), nombre,fecha);
        dao = new LineaDao();
        int respuesta = dao.update(lin);
        if (respuesta != 0) {
            request.setAttribute("config", "alert alert-success");
            request.setAttribute("mensaje", "Linea se actualizo con exito!");
            request.getRequestDispatcher("mensaje.jsp").forward(request, response);
        } else {
            request.setAttribute("config", "alert alert-danger");
            request.setAttribute("mensaje", "Error al actualizar linea en la BD");
            request.getRequestDispatcher("mensaje.jsp").forward(request, response);
        }

        
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        String codigo = request.getParameter("id");
       Linea lin = new Linea();
        lin.setIdlinea(Integer.parseInt(codigo));
        dao = new LineaDao();
        int res = dao.delete(lin);
        if (res != 0) {
            request.setAttribute("config", "alert alert-warning");
            request.setAttribute("mensaje", "Linea eliminado con exito!");
            request.getRequestDispatcher("mensaje.jsp").forward(request, response);
        } else {
            request.setAttribute("config", "alert alert-danger");
            request.setAttribute("mensaje", "Error al eliminar Linea de la BD...");
            request.getRequestDispatcher("mensaje.jsp").forward(request, response);
        }
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        dao = new LineaDao();
        Linea linea = dao.findById(id);

        request.setAttribute("linea", linea);
        request.getRequestDispatcher("editar.jsp").forward(request, response);
    }

    private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("add.jsp").forward(request, response);
    }

}
