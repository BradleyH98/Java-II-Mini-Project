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
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InventoryHelper lih = new InventoryHelper();
		String reportName = request.getParameter("reportName");
		System.out.println("Report Name: "+ reportName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String dealerName = request.getParameter("dealerName");
		
		LocalDate ld;
			try {
				ld = LocalDate.of(Integer.parseInt(year),
				Integer.parseInt(month), Integer.parseInt(day));
			}catch(NumberFormatException ex) {
				ld = LocalDate.now();
			}
			
		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<Inventory> selectedItemsInList = new ArrayList<Inventory>();
		
		if (selectedItems != null && selectedItems.length > 0) {
			for(int i = 0; i<selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Inventory c = lih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
		}
		
		CarDealers dealer = new CarDealers(dealerName);
		InventoryReport sld = new InventoryReport(reportName, ld, dealer);
		
		sld.setListOfCars(selectedItemsInList);
		
		InventoryReportHelper slh = new InventoryReportHelper();
		slh.insertNewListDetails(sld);
		
		System.out.println("Success!");
		System.out.println(sld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
