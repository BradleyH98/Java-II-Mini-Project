package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Inventory;

/**
 * Servlet implementation class EditItemsServlet
 */
@WebServlet("/editItemsServlet")
public class EditItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItemsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InventoryHelper dao = new InventoryHelper();
		String model = request.getParameter("vehicleModel");
		String year = request.getParameter("vehicleYear");
		String price = request.getParameter("price");
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Inventory itemToUpdate = dao.searchForItemById(tempId);
		itemToUpdate.setVehicleModel(model);
		itemToUpdate.setVehicleYear(year);
		itemToUpdate.setPrice(price);
		dao.updateItem(itemToUpdate);
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
		
	}

}
