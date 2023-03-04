package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Inventory;

/**
 * Servlet implementation class AddItemsServlet
 */
@WebServlet("/addItemsServlet")
public class AddItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vehicleModel = request.getParameter("vehicleModel");
		String vehicleYear = request.getParameter("vehicleYear");
		String price = request.getParameter("price");

		Inventory inv = new Inventory(vehicleModel, vehicleYear, price);
		InventoryHelper ih = new InventoryHelper();
		ih.insertItem(inv);

		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

}
