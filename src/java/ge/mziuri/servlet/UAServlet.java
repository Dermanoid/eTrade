package ge.mziuri.servlet;

import ge.mziuri.model.Item;
import ge.mziuri.model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UAServlet", urlPatterns = {"/UAServlet"})
public class UAServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Condition = request.getParameter("Condition");
        String type = request.getParameter("Types");
        String photo = request.getParameter("photo");
        String point = request.getParameter("Point");
        String Name = request.getParameter("name");

        Item item = new Item();
        item.setName(Name);
        item.setPoint(Integer.parseInt(point));
        item.setPhoto(photo);
        User user = new User();
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("logedInUserId")) {
                user.setId(Integer.parseInt(cookie.getValue()));
            }
        }
        item.setUser(user);
        switch (type) {
            case "ავეჯი":
                item.setPoint(item.getPoint() + 10);
                break;
            case "ტექნიკა":
                item.setPoint(item.getPoint() + 20);
                break;
            case "მანქანა":
                item.setPoint(item.getPoint() + 30);
                break;
            case "მიწა":
                item.setPoint(item.getPoint() + 40);
                break;
            case "სახლი":
                item.setPoint(item.getPoint() + 50);
                break;
            case "წვრილმანი":
                item.setPoint(item.getPoint() + 60);
                break;

        }
        int con = Integer.parseInt(Condition);
        if (con >= 0 && con <= 10) {
            item.setPoint(item.getPoint() + 10);
        } else if (con >= 11 && con <= 20) {
            item.setPoint(item.getPoint() + 20);
        } else if (con >= 21 && con <= 30) {
            item.setPoint(item.getPoint() + 30);
        } else if (con >= 31 && con <= 40) {
            item.setPoint(item.getPoint() + 40);
        } else if (con >= 41 && con <= 50) {
            item.setPoint(item.getPoint() + 50);
        } else if (con >= 51 && con <= 60) {
            item.setPoint(item.getPoint() + 60);
        } else if (con >= 61 && con <= 70) {
            item.setPoint(item.getPoint() + 70);
        } else if (con >= 71 && con <= 80) {
            item.setPoint(item.getPoint() + 80);
        } else if (con >= 81 && con <= 90) {
            item.setPoint(item.getPoint() + 90);
        } else if (con >= 91 && con <= 100) {
            item.setPoint(item.getPoint() + 100);
        };

        processRequest(request, response);
    }

}
