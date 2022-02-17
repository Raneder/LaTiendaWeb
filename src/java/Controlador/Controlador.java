/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Datos.MarcaDAO;
import Datos.ProductoDAO;
import Datos.RubroDAO;

import Modelo.Marca;
import Modelo.Producto;
import Modelo.Rubro;

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
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    Producto pro = new Producto();
    ProductoDAO pdao = new ProductoDAO();
   
    int idproducto;
    int idm;
    Rubro r =new Rubro();
    RubroDAO rdao = new RubroDAO();
    Marca mar = new Marca();
    MarcaDAO mdao = new MarcaDAO();
   
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String menu = request.getParameter("menu");
         String accion = request.getParameter("accion");
         if(menu.equals("Principal")){
             request.getRequestDispatcher("Principal.jsp").forward(request,response);
         }
         if(menu.equals("Vendedor")){
             request.getRequestDispatcher("Vendedor.jsp").forward(request,response);
         }
          if(menu.equals("Clientes")){
             request.getRequestDispatcher("Clientes.jsp").forward(request,response);
         }
           if(menu.equals("Compras")){
             request.getRequestDispatcher("Compras.jsp").forward(request,response);
         }
          if(menu.equals("Devoluciones")){
             request.getRequestDispatcher("Devoluciones.jsp").forward(request,response);
         }
           if(menu.equals("NuevaVenta")){
             request.getRequestDispatcher("NuevaVenta.jsp").forward(request,response);
         }
           
           if(menu.equals("Productos")){
                switch (accion) {
                    case "Listar":
                        List lista = pdao.listar();
                        List listarubros = rdao.listar();
                        List listamarcas = mdao.listar();
                        
                        request.setAttribute("productos", lista);
                        request.setAttribute("rubros", listarubros);
                        request.setAttribute("marcas",listamarcas);
                        request.getRequestDispatcher("Productos.jsp").forward(request,response);
                        break;
                    
                    case "Agregar":
                        String descripcion = request.getParameter("txtDescripcion");
                        double costo =Double.parseDouble(request.getParameter("txtCosto"));
                        double margenGanancia =Double.parseDouble(request.getParameter("txtMganancia" ));
                        double IVA =Double.parseDouble(request.getParameter("txtIVA" ));
                        double netoGravado =Double.parseDouble(request.getParameter("txtNgravado" ));
                        int idrubro = Integer.parseInt(request.getParameter("cbxRubro"));
                        int idmarca = Integer.parseInt(request.getParameter("cbxMarca"));
                      
                        
                        pro.setDescripcion(descripcion);
                        pro.setCosto(costo);
                        pro.setMargenGanancia(margenGanancia);
                        pro.setIVA(IVA);
                        //pro.setNetoGravado(netoGravado);
                        pro.setidRubro(idrubro);
                        pro.setidMarca(idmarca);
                        
                        pdao.agregar(pro);
                        request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                        break;

                    case "Editar":
                         idproducto = Integer.parseInt(request.getParameter("idProducto"));
                         Producto p = pdao.listarId(idproducto);
                         request.setAttribute("producto",p);
                         request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                    break;
                    
                    case "Actualizar":
                        String descripcion1 = request.getParameter("txtDescripcion");
                        double costo1 =Double.parseDouble(request.getParameter("txtCosto"));
                        double margenGanancia1 =Double.parseDouble(request.getParameter("txtMganancia" ));
                        double IVA1 =Double.parseDouble(request.getParameter("txtIVA" ));
                        double netoGravado1 =Double.parseDouble(request.getParameter("txtNgravado" ));
                        int idrubro1 = Integer.parseInt(request.getParameter("cbxRubro"));
                        int idmarca1 = Integer.parseInt(request.getParameter("cbxMarca"));
                      
                        pro.setDescripcion(descripcion1);
                        pro.setCosto(costo1);
                        pro.setMargenGanancia(margenGanancia1);
                        pro.setIVA(IVA1);
                        //pro.setNetoGravado(netoGravado1);
                        pro.setidRubro(idrubro1);
                        pro.setidMarca(idmarca1);
                        
                        pro.setIdproducto(idproducto);
                        pdao.modificar(pro);
                        request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                        break;
                        
                    case "Delete":
                        idproducto = Integer.parseInt(request.getParameter("idProducto"));
                        pdao.eliminar(idproducto);
                        request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                        break;
                  
                    case "ListarTalles":
                        request.getRequestDispatcher("productotalles.jsp").forward(request, response);
                        break;
                        
                    case "AgregarTalle":
                        break;
                }
           // request.getRequestDispatcher("Productos.jsp").forward(request,response);
         }
            if(menu.equals("Proveedores")){
            request.getRequestDispatcher("Proveedores.jsp").forward(request,response);
         }
             if(menu.equals("Marca")){
                 switch (accion) {
                    case "Listar":
                        List lista = mdao.listar();
                        request.setAttribute("listmarcas", lista);
                        break;
                    case "Agregar":
                        String descripcion = request.getParameter("txtDescripcion");
                        mar.setDescripcion(descripcion);
                        mdao.agregar(mar);
                        request.getRequestDispatcher("Controlador?menu=Marca&accion=Listar").forward(request, response);
                    break;
                    case "Editar":
                         idm = Integer.parseInt(request.getParameter("idMarca"));
                         Marca m = mdao.listarId(idm);
                         request.setAttribute("marca",m);
                         request.getRequestDispatcher("Controlador?menu=Marca&accion=Listar").forward(request, response);
                    break;
                        
                    case "Actualizar":
                        String descripcion1 = request.getParameter("txtDescripcion");
                        mar.setDescripcion(descripcion1);
                        
                        mar.setIdMarca(idm);
                        mdao.actualizar(mar);
                        request.getRequestDispatcher("Controlador?menu=Marca&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        idm = Integer.parseInt(request.getParameter("idMarca"));
                        mdao.eliminar(idm);
                        request.getRequestDispatcher("Controlador?menu=Marca&accion=Listar").forward(request, response);
                        break;
                       
             
             
         }
         request.getRequestDispatcher("Marca.jsp").forward(request,response);        
         }
             if(menu.equals("Ventas")){
             request.getRequestDispatcher("Ventas.jsp").forward(request,response);
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
