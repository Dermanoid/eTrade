 
 
package ge.mziuri.servlet;

import ge.mziuri.dao.ItemDAO;
import ge.mziuri.dao.ItemDAOImpl;
import ge.mziuri.dao.TradeDAO;
import ge.mziuri.dao.TradeDAOImpl;
import ge.mziuri.model.Item;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet(name = "DeleteItemServlet", urlPatterns = {"/DeleteItemServlet"})
public class DeleteItemServlet extends HttpServlet {
    
    private TradeDAO tradeDAO = new TradeDAOImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Boolean.valueOf(request.getParameter("trade")) == true) {
            int receiveItemId = Integer.parseInt(request.getParameter("itemId"));
            int sendItemId = Integer.parseInt(request.getParameter("sendItemId"));
            tradeDAO.addOffer(sendItemId, receiveItemId);
            RequestDispatcher rd = request.getRequestDispatcher("auction.jsp");
            rd.forward(request, response);
        } else {
            int id = Integer.parseInt(request.getParameter("itemId"));
            ItemDAO itemDAO = new ItemDAOImpl();
            itemDAO.deleteItem(id);
            RequestDispatcher rd = request.getRequestDispatcher("PersonalAcc.jsp");
            rd.forward(request, response);
        }
    }
}
