<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <title>JSP Page</title>
        <style>

            body{
                background: #4b6cb7;  /* fallback for old browsers */
                background: -webkit-linear-gradient(to right, #182848, #4b6cb7);  /* Chrome 10-25, Safari 5.1-6 */
                background: linear-gradient(to right, #182848, #4b6cb7); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

            }

        </style>
    </head>
    
        <div class="container mt-4">
            <form action="Controlador" method="POST">
                <div class="card border-info mb-3" style="max-width: 18rem;">
                    <div class="card-header">Agregar Linea</div>
                    <div class="card-body text-info">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" name="txtnombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Fecha</label>
                            <input type="text" name="txtFecha" class="form-control">
                        </div>

                    </div>
                    <div class="card-footer">
                        <input type="submit" value="agregar" name="accion" class="btn btn-outline-success">
                        <a href="Controlador?accion=listar" class="btn-link ml-2">Listar</a>


                    </div>
                </div>
          

        </div>
    
</html>
