<%-- 
    Document   : principaljsp
    Created on : 27 dic. 2021, 00:03:29
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
</head>
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
  <div class="container">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a style= " margin-left: 10px; border:none" class="btn btn-outline-light" href="#">Home</a>
      </li>
       <li class="nav-item">
        <a style= " margin-left: 10px; border:none" class="btn btn-outline-light" href="Controlador?menu=Compras" target="myFrame">Compras</a>
      </li>
      <li class="nav-item">
        <a style= " margin-left: 10px; border:none" class="btn btn-outline-light" href="ControladorProducto?accion=Listar" target="myFrame">Productos</a>
      </li>
       <li class="nav-item">
        <a style= " margin-left: 10px; border:none" class="btn btn-outline-light" href="Controlador?menu=Proveedores" target="myFrame">Proveedores</a>
      </li>
      <li class="nav-item">
        <a style= " margin-left: 10px; border:none" class="btn btn-outline-light" href="ControladorMarca?accion=Listar" target="myFrame">Marca</a>
      </li>  
       
    </ul>
      
      <div class="dropdown ">

  <button style = "border: none" class= "btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
      ${usuario.getEmpleado().getNombreCompleto()}
      
  </button>
  <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="#">
        <img src="Img/usuario.png" alt="60" width="60"/>
    </a>
      <p class="dropdown-item">${usuario.getNombreUsuario()}</p>
    <p class="dropdown-item">${usuario.getTipousuario().getDescripcion()}</p>
    <p class="dropdown-item">${usuario.getEmpleado().getSucursal().getDescripcion()}</p>
    
    
    
    <div class ="dropdown-divider"></div>
    <form action="index.jsp" method="POST">
    <button name = "accion" value="Salir" class= "dropdown-item" href="#">Salir</button>
    </form>
   </div>
</div>
  </div>
</nav>
    <div class="mt-4" style="height: 550px;">
        <iframe name="myFrame" style=" height:100%; width: 100%; border:none"></iframe>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
    </body>
</html>
