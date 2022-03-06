package com.koc.webapp;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.koc.webapp.utils.Action;
import com.koc.webapp.utils.MetaParser;
import com.koc.webapp.utils.Result;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Main Servlet", value = "/")
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Map<String, Action> actionMap;

	public MainServlet() throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		actionMap = MetaParser.parse(new File(MainServlet.class.getResource("/meta.xml").toURI()));
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		handleRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handleRequest(req, resp);
	}
	
	public String getPath(HttpServletRequest request) {
		return request.getRequestURL().substring(request.getRequestURL().indexOf(request.getContextPath()))
				.replace(request.getContextPath(), "");
	}

	public void showError(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
		request.setAttribute("error", message);
		request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
	}
	
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = getPath(request);
		response.getWriter().append(path);
		Action action = actionMap.get(path);
		if (action == null) {
			showError(request, response, "Page not found");
			return;
		}
		try {
			Class<?> clazz = Class.forName(action.getActionClassName());
			Object executor = clazz.getConstructor().newInstance();
			Method method = clazz.getDeclaredMethod(action.getMethodName(), Map.class);
			Result result = (Result) method.invoke(executor, request.getParameterMap());
			if (result instanceof Result.Success res) {
				request.setAttribute(action.getPayloadKey(), res.getPayload());
				request.getRequestDispatcher(action.getSuccessFile()).forward(request, response);
				return;
			} else if (result instanceof Result.Error err) {
				request.setAttribute("error", err.getMessage());
				request.getRequestDispatcher(action.getErrorFile()).forward(request, response);
				return;
			}else {
				showError(request, response, "Unkown or null resource type returned");
				return;
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		showError(request, response, "Configuration error");
	}
}
