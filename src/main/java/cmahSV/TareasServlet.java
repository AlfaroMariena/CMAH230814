package cmahSV;

import cmahjsp.Tarea;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TareasServlet")
public class TareasServlet extends HttpServlet {
    private Map<Integer, Tarea> tareasMap = new HashMap<>();
    private int nextId = 1;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Tarea> tareasList = new ArrayList<>(tareasMap.values());
        request.setAttribute("tareas", tareasList);
        request.getRequestDispatcher("tareas.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            response.sendRedirect("TareasServlet");
            return;
        }

        switch (action) {
            case "create":
                String titulo = request.getParameter("titulo");
                String descripcion = request.getParameter("descripcion");
                Tarea nuevaTarea = new Tarea(nextId, titulo, descripcion);
                tareasMap.put(nextId, nuevaTarea);
                nextId++;
                break;

            case "update":
                int tareaId = Integer.parseInt(request.getParameter("id"));
                Tarea tareaActualizada = tareasMap.get(tareaId);
                if (tareaActualizada != null) {
                    tareaActualizada.setTitulo(request.getParameter("titulo"));
                    tareaActualizada.setDescripcion(request.getParameter("descripcion"));
                }
                break;

            case "delete":
                int tareaIdEliminar = Integer.parseInt(request.getParameter("id"));
                tareasMap.remove(tareaIdEliminar);
                break;
        }

        response.sendRedirect("TareasServlet");
    }
}
