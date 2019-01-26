package es.salesianos.servlet;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.model.Director;
import es.salesianos.model.Film;
import es.salesianos.service.OwnerService;

/**
 * Servlet implementation class addOwnerServlet
 */
public class AddDirectorServlet extends HttpServlet {
private OwnerService service = new OwnerService();

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Director director = service.assembleDirectorFromRequest(req);
		service.addDirector(director);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addDirector.jsp");
		dispatcher.forward(req,resp);
	}
}
