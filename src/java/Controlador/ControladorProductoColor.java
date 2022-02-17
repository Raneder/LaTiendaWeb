/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Datos.ColorDAO;
import Datos.ProductocolorDAO;
import Modelo.Productocolor;
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
@WebServlet(name = "ControladorProductoColor", urlPatterns = {"/ControladorProductoColor"})
public class ControladorProductoColor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          String accion = request.getParameter("accion");
       ProductocolorDAO pcdao = new ProductocolorDAO();
       ColorDAO cdao = new ColorDAO();
       String descripcionproducto;
       
       Productocolor pc = new Productocolor();
       int idproducto;
       int idColor;
       
      switch (accion) {
                    case "Listarcolores":
                        
                        idproducto=Integer.parseInt(request.getParameter("idproducto"));
                       
                        descripcionproducto=request.getParameter("descripcionproducto");
                        List listaColores = pcdao.listarColores(idproducto);
                        List colores = cdao.listar();
                        request.setAttribute("listaColores", listaColores);
                        request.setAttribute("descripcionproducto", descripcionproducto);
                        request.setAttribute("idproducto",idproducto);
                        request.setAttribute("colores", colores);
                        request.getRequestDispatcher("ProductoColor.jsp").forward(request,response);
                    break;
                    case "Agregar":
                        idproducto=Integer.parseInt(request.getParameter("idproducto"));
                        
                        idColor=Integer.parseInt(request.getParameter("cbxColor"));
                        
                        descripcionproducto=request.getParameter("descripcionproducto");
                        
                        pc.setIdColor(idColor);
                        pc.setIdproducto(idproducto);
                        
                        pcdao.agregar(pc);
                        
                        
                        request.setAttribute("idproducto",idproducto);
                        request.setAttribute("descripcionproducto", descripcionproducto);
                        //request.getRequestDispatcher("ControladorProductoTalle?accion=ListarTalles").forward(request, response);
                        request.getRequestDispatcher("ControladorProductoColor?accion=Listarcolores").forward(request, response);
                        //request.getRequestDispatcher("ProductoTalle.jsp").forward(request,response);
                    break;
                    case "Delete":
                        idproducto=Integer.parseInt(request.getParameter("idproducto"));
                        descripcionproducto=request.getParameter("descripcionproducto");
                        int idpc = Integer.parseInt(request.getParameter("id"));
                        pcdao.eliminar(idpc);
                        request.setAttribute("idproducto",idproducto);
                        request.setAttribute("descripcionproducto", descripcionproducto);
                        request.getRequestDispatcher("ControladorProductoColor?accion=ListarColores").forward(request, response);
                        break;
                    
    }

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
