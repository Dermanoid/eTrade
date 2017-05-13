package ge.mziuri.servlet;

import ge.mziuri.dao.UserDAO;
import ge.mziuri.dao.UserDAOImpl;
import ge.mziuri.model.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(403);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserDAO userDAO = new UserDAOImpl();
            User user = userDAO.login(username, String.valueOf(password.hashCode()));
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            if (user == null) {
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                request.setAttribute("incorrectPassword", true);
                rd.forward(request, response);
            } else {
                Cookie cookie = new Cookie("logedInUserId", String.valueOf(user.getId()));
                response.addCookie(cookie);
                RequestDispatcher rd = request.getRequestDispatcher("auction.jsp");
                rd.forward(request, response);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
