<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>alumnos</title>
</head>
<body>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Id del alumno</th>
      <th scope="col">Nombre del alumno</th>
      <th scope="col">Telefono del alumno</th>
      <th scope="col">IdPortatil</th>
      <th scope="col">Marca</th>
      <th scope="col">Modelo</th>
    </tr>
  </thead>
  <tbody>
       <tr>
       	   <td><c:out value="${miModelo.idAlumno}"/></td>
       	   <td><c:out value="${miModelo.nombre}"/></td>
       	   <td><c:out value="${miModelo.telefono}"/></td>
           <td><c:out value="${miModelo.idPortatil}"/></td>
           <td><c:out value="${miModelo.marca}"/></td>
           <td><c:out value="${miModelo.modelo}"/></td>
       </tr>
  </tbody>
</table>
</body>
</html>