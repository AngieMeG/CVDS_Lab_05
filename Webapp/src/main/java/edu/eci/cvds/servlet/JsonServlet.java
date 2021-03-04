package edu.eci.cvds.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.eci.cvds.servlet.model.Todo;
import edu.eci.cvds.servlet.Service;

@WebServlet(
    urlPatterns = "/jsonServlet"
)
public class JsonServlet extends HttpServlet{
    static final long serialVersionUID = 35L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        String message = "";
        try{
            Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
            Todo todo = Service.getTodo(Integer.parseInt(optId.get()));
            resp.setStatus(HttpServletResponse.SC_OK);
            ArrayList<Todo> todos = new ArrayList<>();
            todos.add(todo);
            message = Service.todosToHTMLTable(todos);
        }
        catch(NoSuchElementException e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            message = Service.getHTMLErrorPage(resp.getStatus(), "Requerimiento Invalido. Parametro no pasado");
        }
        catch(NumberFormatException e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            message = Service.getHTMLErrorPage(resp.getStatus(), "Requerimiento Invalido. Formato de parametro");
        }
        catch(MalformedURLException e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            message = Service.getHTMLErrorPage(resp.getStatus(), "Error Interno en el Servidor.");
        }
        catch(Exception e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            message = Service.getHTMLErrorPage(resp.getStatus(), "Requerimiento Invalido.");
        }
        finally{
            responseWriter.write(message);
            responseWriter.flush();   
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        String message = "";
        try{
            Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
            Todo todo = Service.getTodo(Integer.parseInt(optId.get()));
            resp.setStatus(HttpServletResponse.SC_OK);
            ArrayList<Todo> todos = new ArrayList<>();
            todos.add(todo);
            message = Service.todosToHTMLTable(todos);
        }
        catch(NoSuchElementException e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            message = Service.getHTMLErrorPage(resp.getStatus(), "Requerimiento Invalido. Parametro no pasado");
        }
        catch(NumberFormatException e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            message = Service.getHTMLErrorPage(resp.getStatus(), "Requerimiento Invalido. Formato de parametro");
        }
        catch(MalformedURLException e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            message = Service.getHTMLErrorPage(resp.getStatus(), "Error Interno en el Servidor.");
        }
        catch(Exception e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            message = Service.getHTMLErrorPage(resp.getStatus(), "Requerimiento Invalido.");
        }
        finally{
            responseWriter.write(message);
            responseWriter.flush();   
        }
    }
}