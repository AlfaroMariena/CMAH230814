<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Tareas</title>
</head>
<body>
    <h1>Lista de Tareas</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Título</th>
            <th>Descripción</th>
            <th>Acciones</th>
        </tr>
        <c:forEach var="tarea" items="${tareas}">
            <tr>
                <td>${tarea.id}</td>
                <td>${tarea.titulo}</td>
                <td>${tarea.descripcion}</td>
                <td>
                    <a href="editarTarea.jsp?id=${tarea.id}">Editar</a>
                    <a href="TareasServlet?action=delete&id=${tarea.id}">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="agregarTarea.jsp">Agregar Nueva Tarea</a>
</body>
</html>

