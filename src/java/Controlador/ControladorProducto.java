/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Datos.MarcaDAO;
import Datos.ProductoDAO;
import Datos.RubroDAO;
import Datos.TalleDAO;
import Modelo.Marca;
import Modelo.Producto;
import Modelo.Rubro;
import Modelo.Talle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class ControladorProducto extends HttpServlet {

    Producto pro = new Producto();
    ProductoDAO pdao = new ProductoDAO();
     
    
   
    int idproducto;
    
    Rubro r =new Rubro();
    RubroDAO rdao = new RubroDAO();
    Marca mar = new Marca();
    MarcaDAO mdao = new MarcaDAO();
    Talle t = new Talle();
    TalleDAO tdao = new TalleDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
         String accion = request.getParameter("accion");
         
           
           
                switch (accion) {
                    case "Listar":
                        List listaproductos = pdao.listar();
                        List listarubros = rdao.listar();
                        List listamarcas = mdao.listar();
                        //List listatalles = tdao.listar();
                        
                        request.setAttribute("productos", listaproductos);
                        request.setAttribute("rubros", listarubros);
                        request.setAttribute("marcas",listamarcas);
                        //request.setAttribute("talles", listatalles);
                        request.getRequestDispatcher("Producto.jsp").forward(request,response);
                        break;
                    
                    case "Agregar":
                        String descripcion = request.getParameter("txtDescripcion");
                        Double costo =Double.parseDouble(request.getParameter("txtCosto"));
                        Double margenGanancia =Double.parseDouble(request.getParameter("txtMganancia" ));
                        Double IVA =Double.parseDouble(request.getParameter("txtIva" ));
                        Double netoGravado =Double.parseDouble(request.getParameter("txtNGravado" ));
                        int idRubro = Integer.parseInt(request.getParameter("cbxRubro"));
                        int idMarca = Integer.parseInt(request.getParameter("cbxMarca"));
                      
                        
                        pro.setDescripcion(descripcion);
                        pro.setCosto(costo);
                        pro.setMargenGanancia(margenGanancia);
                        pro.setIVA(IVA);
                        pro.setNetoGravado(netoGravado);
                        pro.setidRubro(idRubro);
                        pro.setidMarca(idMarca);
                        
                        pdao.agregar(pro);
                        request.getRequestDispatcher("ControladorProducto?accion=Listar").forward(request, response);
                        break;

                    case "Editar":
                         idproducto = Integer.parseInt(request.getParameter("idProducto"));
                         Producto p = pdao.listarId(idproducto);
                         request.setAttribute("producto",p);
                         request.getRequestDispatcher("ControladorProducto?accion=Listar").forward(request, response);
                    break;
                    
                    case "Actualizar":
                        idproducto = Integer.parseInt(request.getParameter("idProducto"));
                        String descripcion1 = request.getParameter("txtDescripcion");
                        Double costo1 =Double.parseDouble(request.getParameter("txtCosto"));
                        Double margenGanancia1 =Double.parseDouble(request.getParameter("txtMganancia" ));
                        Double IVA1 =Double.parseDouble(request.getParameter("txtIva" ));
                        Double netoGravado1 =Double.parseDouble(request.getParameter("txtNGravado" ));
                        int idRubro1 = Integer.parseInt(request.getParameter("cbxRubro"));
                        int idMarca1 = Integer.parseInt(request.getParameter("cbxMarca"));
                        //pro=new Producto();
                        pro.setIdproducto(idproducto);
                        pro.setDescripcion(descripcion1);
                        pro.setCosto(costo1);
                        pro.setMargenGanancia(margenGanancia1);
                        pro.setIVA(IVA1);
                        pro.setNetoGravado(netoGravado1);
                        pro.setidRubro(idRubro1);
                        pro.setidMarca(idMarca1);
                        
                        
                        pdao.modificar(pro);
                        request.getRequestDispatcher("ControladorProducto?accion=Listar").forward(request, response);
                        break;
                        
                    case "Delete":
                        idproducto = Integer.parseInt(request.getParameter("idProducto"));
                        pdao.eliminar(idproducto);
                        request.getRequestDispatcher("ControladorProducto?accion=Listar").forward(request, response);
                        break;
                  
                    /*case "ListarTalles":
                        request.getRequestDispatcher("ControladorProducto?accion=ListarTalles").forward(request, response);
                        break;*/
                        
                   /* case "AgregarTalle":
                        break;*/
                }
           // request.getRequestDispatcher("Productos.jsp").forward(request,response);
         
            
           
         
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
        //Producto pro = new Producto();
        //pro.setDescripcion(request.getParameter("txtDescripcion"));
        //pro.setCosto(Double.parseDouble(request.getParameter("txtCosto")));
        //pro.setMargenGanancia(Double.parseDouble(request.getParameter("txtMganancia")));
        //pro.setIVA(Double.parseDouble(request.getParameter("txtIVA")));
        //pro.setPrecioVenta(Double.parseDouble(request.getParameter("txtPventa")));
        //pro.getNetoGravado();
        //pro.calcularIVA();
        //pro.getPrecioVenta();
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
