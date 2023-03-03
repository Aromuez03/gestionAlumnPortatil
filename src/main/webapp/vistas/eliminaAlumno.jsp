<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<title>Borrar Alumno</title>

</head>
<body>

<form method="post" action="eliminaAlumno">
      <div>
          <br/>
          <br/>
          <div class="form-group row">
              <div style="text-align: center; font-size: 1cm;">Borrar alumno</div>
          </div>
          <br/>
          <br/>
          <div class="form-group row">
              <div class="col-form-label">Id del alumno</div>
          </div>
          <div class="form-group row">
              <div class="col-sm-4">
                  <input type="number" class="form-control" name="idAlumno" placeholder="Introduce el id del alumno, ejemplo: 1" required>
              </div>
          </div>
          <br/>
          <br/>
          <div class="form-group row">
               <div class="col-sm-4">
                   <button type="submit" class="button btn btn-primary">Buscar</button>
               </div>
          </div>
      </div>
</form>
</body>
</html>