<%-- 
    Document   : index
    Created on : 18 dic. 2021, 04:15:17
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container mt-5 col-lg-4">
            <div class="card col-sm-10">
                <div class="card-body ">
                    <form class="form-sign" action="Validar" method="POST" >
                        <div class="form-group text-center">  
                            <h3><strong>Inicio de Sesión</strong></h3>
                            <img src="Img/Logo tdeportivo.jpg" alt="" width="170" height="70">
                            
                            <label><strong>Bienvenidos al sistema</label></strong>
                        </div>
                        <div class= "form-group">
                            <label>Usuario: </label>
                            <input type="text" name="txtusuario" placeholder = "Ingrese usuario" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Contraseña: </label>
                            <input type="password" name="txtclave" placeholder = "Ingrese clave" class="form-control">
                        </div>
                        <div class = "form-group">
                        <input type="submit" name="accion" value="Ingresar" class= "btn btn-primary btn-block"/>
                        </div> 
                        </form> 
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>