 
 
package ge.mziuri.servlet;

import ge.mziuri.dao.ItemDAO;
import ge.mziuri.dao.ItemDAOImpl;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet(name = "DeleteItemServlet", urlPatterns = {"/DeleteItemServlet"})
public class DeleteItemServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("itemId"));
        ItemDAO itemDAO = new ItemDAOImpl();
        itemDAO.deleteItem(id);
        RequestDispatcher rd = request.getRequestDispatcher("PersonalAcc.jsp");
        rd.forward(request, response);
    }
}
