package web;

import java.io.IOException;

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

 * Servlet implementation class controlleur

 */

@WebServlet("/controlleur")

public class controlleur extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IServiceProduit sp;

    /**

     * @see HttpServlet#HttpServlet()

     */

    public controlleur() {

        super();

        // TODO Auto-generated constructor stub

    }

	/**

	 * @see Servlet#init(ServletConfig)

	 */

	public void init(ServletConfig config) throws ServletException {

		// TODO Auto-generated method stub

		sp=new ServiceProduit();

	}

	/**

	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub

		//response.getWriter().append("Served at: ").append(request.getContextPath());

		String mc = request.getParameter("motCle");

		List<Produit> liste;

		if (mc == null)

			liste = sp.getAllProducts();

		else if (mc.trim().isEmpty())

			liste = new java.util.ArrayList<Produit>();

		else

			liste = sp.getProductsByMC(mc);
		request.setAttribute("products", liste);

		request.getRequestDispatcher("acceuil.jsp").forward(request, response);

	}

	/**

	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub

		doGet(request, response);

	}

}