package ge.mziuri.servlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuctionServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Name = request.getParameter("Name");
        String TextDescription = request.getParameter("TextDescription");
        String Photo = request.getParameter("photo");
        RequestDispatcher rd = request.getRequestDispatcher("auction.html");
        rd.forward(request, response);
    }

}
