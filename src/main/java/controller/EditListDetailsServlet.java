package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarDealers;
import model.Inventory;
import model.InventoryReport;

/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InventoryReportHelper dao = new InventoryReportHelper();
		InventoryHelper lih = new InventoryHelper();
		CarDealerHelper sh = new CarDealerHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		InventoryReport listToUpdate = dao.searchForListDetailsById(tempId);
		
		String newReportName = request.getParameter("reportName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String dealerName = request.getParameter("dealerName");
		
		CarDealers newFisher = sh.findCarDealers(dealerName);
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year),
			Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		try {
			//items are selected in list to add
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<Inventory> selectedItemsInList = new ArrayList<Inventory>();
			for (int i = 0; i < selectedItems.length; i++) {
				System.out .println(selectedItems[i]);
				Inventory c = lih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
			
			listToUpdate.setListOfCars(selectedItemsInList);
		} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<Inventory> selectedItemsInList = new
			ArrayList<Inventory>();
			listToUpdate.setListOfCars(selectedItemsInList);
		}
		
		listToUpdate.setInventoryTitle(newReportName);
		listToUpdate.setInventoryDate(ld);
		listToUpdate.setCarDealer(newFisher);
		dao.updateReport(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
