<%-- 
    Document   : Producto
    Created on : 2 feb. 2022, 00:27:43
    Author     : Usuario
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">--%>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://bootswatch.com/3/flatly/bootstrap.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
               <div class="card-body">
                    <form action = "ControladorProductoTalle" METHOD = "POST">
                        <input type="hidden" name="idproducto" value="${idproducto}"> 
                        <div class ="form-group">
                        <label for="descripcionproducto">
                            Producto:
                        </label>
                        <input type="text" readonly name="descripcionproducto" value=" ${descripcionproducto}">
                        </div>
                        
                        <div class ="form-group">
                         <select name="cbxTalle" class="form-control">
                                        <option>
                                            Seleccionar Talle
                                        </option>
                                        <c:forEach var="ta" items="${talles}">
                                            <option value ="${ta.getNtalle()}">
                                                ${ta.getDescripcion()}--${ta.getTalle()}
                                            </option>
                                        </c:forEach>
                                      </select>
                        </div>
                        <div class ="form-group">
                         <input type ="submit" name="accion" value="Agregar" class="btn btn-info">
                         <a class="btn btn-warning" href="ControladorProducto?accion=Listar"> Volver </a>
                        </div>
                         </form>
                          </div>
            </div> 
        <div class="card col-md-6"> 
            <table class = "table table-bordered table-hover">
                <thead>
                    <tr>
                        
                        <th class="text-center">DESCRIPCION</th>
                        <th class="text-center">TALLES</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                  <tbody>
                    <c:forEach var="lpt" items="${listaTalles}">
                        <tr>
                            
                            <td>${lpt.getTalle().getDescripcion()}</td>
                            <td>${lpt.getTalle().getTalle()}</td>
                        
                            <td class="text-center"> 
                                    
         
                              <a class="btn btn-danger btn-sm  glyphicon glyphicon-trash" href="ControladorProductoTalle?accion=Delete&id=${lpt.getId()}&idproducto=${lpt.getIdproducto()}"></a>
                                 
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
               </table>
            </div>
        </div>
                           
                            
                            
                       
                
                        <%--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
                    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>--%>
                    
                    <!-- jquery 3.x -->
    <%--<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    

    <!-- script BootstrapCDN -->
    <!-- Version 3.3.7 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    --%>
</body>
</html>
