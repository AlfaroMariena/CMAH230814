<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Nueva Tarea</title>
</head>
<body>
    <h1>Agregar Nueva Tarea</h1>
    <form action="TareasServlet" method="post">
        <input type="hidden" name="action" value="create">
        Título: <input type="text" name="titulo" required><br>
        Descripción: <input type="text" name="descripcion" required><br>
        <input type="submit" value="Agregar">
    </form>
    <br>
    <a href="TareasServlet">Volver a la Lista de Tareas</a>
</body>
</html>
