/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Datos.EmpleadoDAO;
import Datos.SucursalDAO;
import Datos.TipousuarioDAO;
import Datos.UsuarioDAO;
import Modelo.Empleado;
import Modelo.Sucursal;
import Modelo.Tipousuario;
import Modelo.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
public class Validar extends HttpServlet {


    
    UsuarioDAO udao = new UsuarioDAO();
    Usuario us = new Usuario();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion;
        String accion= request.getParameter("accion");
        if(accion.equalsIgnoreCase("Ingresar")){
           
            String usuario= request.getParameter("txtusuario");
            String clave  = request.getParameter("txtclave");
            us=udao.validar(usuario, clave);
            if (us!=null){
                EmpleadoDAO eDAO = new EmpleadoDAO();
                //us.setEmpleado(eDAO.getEmpleado(us.getIdEmpleado()));
                Empleado em = eDAO.getEmpleado(us.getIdEmpleado());
                SucursalDAO sDAO = new SucursalDAO();
                Sucursal su = sDAO.getSucursal(em.getIdSucursal());
                TipousuarioDAO tuDAO = new TipousuarioDAO();
                Tipousuario tu = tuDAO.getTipousuario(us.getIdUsuario());
                us.setTipousuario(tu);
                em.setSucursal(su);
                us.setEmpleado(em);
                
                if( "administrador".equals(us.getTipousuario().getDescripcion())){
                   sesion = request.getSession();
                   request.setAttribute("usuario",us);
                   request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
                } 
                if("vendedor".equals(us.getTipousuario().getDescripcion())){
                    sesion = request.getSession();
                    request.setAttribute("usuario",us);
                    request.getRequestDispatcher("Controlador?menu=Vendedor").forward(request, response);
                }
            }
            else {request.getRequestDispatcher("index.jsp").forward(request, response);}
        }
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     *txt @throws IOException if an I/O error occurs
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
        HttpSession sesion;
        String accion= request.getParameter("accion");
        if(accion.equalsIgnoreCase("Ingresar")){
           
            String usuario= request.getParameter("txtusuario");
            String clave  = request.getParameter("txtclave");
            us=udao.validar(usuario, clave);
            if (us!=null){
                EmpleadoDAO eDAO = new EmpleadoDAO();
                //us.setEmpleado(eDAO.getEmpleado(us.getIdEmpleado()));
                Empleado em = eDAO.getEmpleado(us.getIdEmpleado());
                SucursalDAO sDAO = new SucursalDAO();
                Sucursal su = sDAO.getSucursal(em.getIdSucursal());
                TipousuarioDAO tuDAO = new TipousuarioDAO();
                Tipousuario tu = tuDAO.getTipousuario(us.getIdUsuario());
                us.setTipousuario(tu);
                em.setSucursal(su);
                us.setEmpleado(em);
                
                if( "administrador".equals(us.getTipousuario().getDescripcion())){
                   sesion = request.getSession();
                   request.setAttribute("usuario",us);
                   request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
                } 
                if("vendedor".equals(us.getTipousuario().getDescripcion())){
                    sesion = request.getSession();
                    request.setAttribute("usuario",us);
                    request.getRequestDispatcher("Controlador?menu=Vendedor").forward(request, response);
                }
            }
            else {request.getRequestDispatcher("index.jsp").forward(request, response);}
        }
    }


    /**
     * Returns a short description of the servlet.
        HttpSession sesion;
        String accion= request.getParameter("accion");
        if(accion.equalsIgnoreCase("Ingresar")){
           
            String usuario= request.getParameter("txtusuario");
            String clave  = request.getParameter("txtclave");
            us=udao.validar(usuario, clave);
            if (us!=null){
                EmpleadoDAO eDAO = new EmpleadoDAO();
                //us.setEmpleado(eDAO.getEmpleado(us.getIdEmpleado()));
                Empleado em = eDAO.getEmpleado(us.getIdEmpleado());
                SucursalDAO sDAO = new SucursalDAO();
                Sucursal su = sDAO.getSucursal(em.getIdSucursal());
                TipousuarioDAO tuDAO = new TipousuarioDAO();
                Tipousuario tu = tuDAO.getTipousuario(us.getIdUsuario());
                us.setTipousuario(tu);
                em.setSucursal(su);
                us.setEmpleado(em);
                
                if( "administrador".equals(us.getTipousuario().getDescripcion())){
                   sesion = request.getSession();
                   request.setAttribute("usuario",us);
                   request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
                } 
                if("vendedor".equals(us.getTipousuario().getDescripcion())){
                    sesion = request.getSession();
                    request.setAttribute("usuario",us);
                    request.getRequestDispatcher("Controlador?menu=Vendedor").forward(request, response);
                }
            }
            else {request.getRequestDispatcher("index.jsp").forward(request, response);}
        }
    }


    /**
     * Returns a short description of the servlet.
        HttpSession sesion;
        String accion= request.getParameter("accion");
        if(accion.equalsIgnoreCase("Ingresar")){
           
            String usuario= request.getParameter("txtusuario");
            String clave  = request.getParameter("txtclave");
            us=udao.validar(usuario, clave);
            if (us!=null){
                EmpleadoDAO eDAO = new EmpleadoDAO();
                //us.setEmpleado(eDAO.getEmpleado(us.getIdEmpleado()));
                Empleado em = eDAO.getEmpleado(us.getIdEmpleado());
                SucursalDAO sDAO = new SucursalDAO();
                Sucursal su = sDAO.getSucursal(em.getIdSucursal());
                TipousuarioDAO tuDAO = new TipousuarioDAO();
                Tipousuario tu = tuDAO.getTipousuario(us.getIdUsuario());
                us.setTipousuario(tu);
                em.setSucursal(su);
                us.setEmpleado(em);
                
                if( "administrador".equals(us.getTipousuario().getDescripcion())){
                   sesion = request.getSession();
                   request.setAttribute("usuario",us);
                   request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
                } 
                if("vendedor".equals(us.getTipousuario().getDescripcion())){
                    sesion = request.getSession();
                    request.setAttribute("usuario",us);
                    request.getRequestDispatcher("Controlador?menu=Vendedor").forward(request, response);
                }
            }
            else {request.getRequestDispatcher("index.jsp").forward(request, response);}
        }
    }


    /**
     * Returns a short description of the servlet.
        HttpSession sesion;
        String accion= request.getParameter("accion");
        if(accion.equalsIgnoreCase("Ingresar")){
           
            String usuario= request.getParameter("txtusuario");
            String clave  = request.getParameter("txtclave");
            us=udao.validar(usuario, clave);
            if (us!=null){
                EmpleadoDAO eDAO = new EmpleadoDAO();
                //us.setEmpleado(eDAO.getEmpleado(us.getIdEmpleado()));
                Empleado em = eDAO.getEmpleado(us.getIdEmpleado());
                SucursalDAO sDAO = new SucursalDAO();
                Sucursal su = sDAO.getSucursal(em.getIdSucursal());
                TipousuarioDAO tuDAO = new TipousuarioDAO();
                Tipousuario tu = tuDAO.getTipousuario(us.getIdUsuario());
                us.setTipousuario(tu);
                em.setSucursal(su);
                us.setEmpleado(em);
                
                if( "administrador".equals(us.getTipousuario().getDescripcion())){
                   sesion = request.getSession();
                   request.setAttribute("usuario",us);
                   request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
                } 
                if("vendedor".equals(us.getTipousuario().getDescripcion())){
                    sesion = request.getSession();
                    request.setAttribute("usuario",us);
                    request.getRequestDispatcher("Controlador?menu=Vendedor").forward(request, response);
                }
            }
            else {request.getRequestDispatcher("index.jsp").forward(request, response);}
        }
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
