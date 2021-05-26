<%-- 
    Document   : roles
    Created on : 25-may-2021, 20:50:21
    Author     : Intel i5
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <head>
   <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet" >
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <title>Punto de roles</title>
    </head>
    <body>
      <div class="container">
            <h1>Roles</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="roles" />
            </jsp:include>            
            <br>
            <a href="RolControlador?action=add" class="btn btn-primary btn-sm"> <i class="fas fa-plus-circle"></i>Nuevo </a>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Rol</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${roles}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.descripcion}</td>
                    <td><a href="RolControlador?action=edit&id=${item.id}"><i class="fas fa-user-edit"></i></a></td>
                    <td><a href="RolControlador?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro ???'))"><i class="fas fa-trash"></i></a></td>
                </tr>                    
                </c:forEach>
            </table>
            <p class="mt-5 mb-3 text-muted">&copy; WILLIANS ALBERT LEYVA JIMENEZ</p>
        </div>


         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

    </body>
</html>