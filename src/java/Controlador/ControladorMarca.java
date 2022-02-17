/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Datos.MarcaDAO;
import Modelo.Marca;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ControladorMarca", urlPatterns = {"/ControladorMarca"})
public class ControladorMarca extends HttpServlet {

    int idm;
    Marca mar = new Marca();
    MarcaDAO mdao = new MarcaDAO();
   
         
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      String accion = request.getParameter("accion");
      switch (accion) {
                    case "Listar":
                        List lista = mdao.listar();
                        request.setAttribute("listmarcas", lista); 
                        request.getRequestDispatcher("Marca.jsp").forward(request,response);
                        break;
                    case "Agregar":
                        String descripcion = request.getParameter("txtDescripcion");
                        mar.setDescripcion(descripcion);
                        mdao.agregar(mar);
                        request.getRequestDispatcher("ControladorMarca?accion=Listar").forward(request, response);
                    break;
                    case "Editar":
                         idm = Integer.parseInt(request.getParameter("idMarca"));
                         Marca m = mdao.listarId(idm);
                         request.setAttribute("marca",m);
                         request.getRequestDispatcher("ControladorMarca?accion=Listar").forward(request, response);
                    break;
                        
                    case "Actualizar":
                        String descripcion1 = request.getParameter("txtDescripcion");
                        mar.setDescripcion(descripcion1);
                        
                        mar.setIdMarca(idm);
                        mdao.actualizar(mar);
                        request.getRequestDispatcher("ControladorMarca?accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        idm = Integer.parseInt(request.getParameter("idMarca"));
                        mdao.eliminar(idm);
                        request.getRequestDispatcher("ControladorMarca?accion=Listar").forward(request, response);
                        break;
                       
             
             
         }
         //request.getRequestDispatcher("Marca.jsp").forward(request,response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
