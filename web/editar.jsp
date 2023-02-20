<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container mt-4">
            <form action="Controlador" method="POST">
                <div class="card border-info mb-3" style="max-width: 18rem;">
                    <div class="card-header">Actualizar Linea</div>
                    <div class="card-body text-info">
                         <div class="form-group">
                            <label>Codigo</label>
                            <input type="text" value="${linea.idlinea}" name="txtId" readonly="" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" value="${linea.nombre}" name="txtnombre"  class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Fecha</label>
                            <input type="text" value="${linea.fecha}" name="txtfecha" class="form-control">
                        </div>
                        
                    </div>
                    <div class="card-footer">
                        <input type="submit" value="Actualizar" name="accion" class="btn btn-outline-success">
                        <a href="Controlador?accion=listar" class="btn-link ml-2">Listar</a>
                    </div>
                </div>
            </form>

        </div>
    </body>
</html>
