package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.IServiceProduit;
import DAO.ServiceProduit;
import entities.Produit;

/**
 * Servlet implementation class firstservlet
 */
@WebServlet("/index.php")
public class firstservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public firstservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */

	IServiceProduit sp;

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		sp = new ServiceProduit();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		List<Produit> liste=sp.getAllProducts();

		PrintWriter out=response.getWriter();

		out.println("<html><body><table>");

		for (Produit p:liste)

			out.println("<tr><td>"+p.getNom()+"</td><td>"+p.getPrix()+"</td></tr>");

		out.println("</table></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}