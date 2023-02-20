<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <style>
            body{
                background: #FFEFBA;  /* fallback for old browsers */
                background: -webkit-linear-gradient(to right, #FFFFFF, #FFEFBA);  /* Chrome 10-25, Safari 5.1-6 */
                background: linear-gradient(to right, #FFFFFF, #FFEFBA); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

            }
        </style> 
    </head>
   
</html>
<div class="container mt-4">
    <h3>Crud de Tabla Lineas</h3>
    <div class="d-flex">
        <a class="btn btn-outline-primary ml-2" href="Controlador?accion=listar">Listar</a>
        <a class="btn btn-outline-primary ml-2" href="Controlador?accion=nuevo">Nueva Linea</a>
    </div>
    <hr>
    <table class="table">
        <tr>
            <th>Codigo</th>
            <th>Nombre</th>
            <th>Fecha</th>
            <th>Aciones</th>
        </tr>

        <c:forEach var="lis" items="${lista}"> 
            <tr>

                <td>${lis.idlinea}</td>
                <td>${lis.nombre}</td>
                <td>${lis.fecha}</td>

                <td>
                    <a href="Controlador?accion=editar&id=${lis.idlinea}" class="btn btn-outline-danger">Editar</a>
                    <a href="Controlador?accion=Delete&id=${lis.idlinea}" class="btn btn-outline-danger">Eliminar</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>