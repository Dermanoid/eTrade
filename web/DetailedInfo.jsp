
<%@page import="java.util.List"%>
<%@page import="ge.mziuri.dao.ItemDAOImpl"%>
<%@page import="ge.mziuri.dao.ItemDAO"%>
<%@page import="ge.mziuri.model.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="public/css/style.css">
    </head>
    <body class="detailedForm">
        <div class="AUForm1"  >
            <ul>
                <li><a href="auction.jsp">Main</a></li>
                <li><a href="PersonalAcc.jsp">My Account</a></li>
                <li><a href="AboutUs.html">About Us</a></li>
            </ul>
        </div>
        <div>
            <%
                int id = 0;
                if (request.getAttribute("logedInUserId") != null) {
                    id = (int) request.getAttribute("logedInUserId");
                }
                if (id == 0) {
                    for (Cookie cookie : request.getCookies()) {
                        if (cookie.getName().equals("logedInUserId")) {
                            id = Integer.parseInt(cookie.getValue());
                        }
                    }
                }
                ItemDAO itemDAO = new ItemDAOImpl();
                List<Item> itemlist = itemDAO.getAllItem(id);
                itemDAO.detailedItem(id);
                for (Item item : itemlist) {
                    out.write("<form class=\"Itemform\">");
                    out.write("<h2>" + item.getName() + "</h2>");
                    out.write("<img src=\"" + "images\\" + item.getPhotoes().get(0) + "\" alt=\"Cant Find Photo\" />");
                    out.write("<img src=\"" + "images\\" + item.getPhotoes().get(1) + "\" alt=\"Cant Find Photo\" />");
                    out.write("<img src=\"" + "images\\" + item.getPhotoes().get(2) + "\" alt=\"Cant Find Photo\" />");
                    out.write("<textarea readonly rows=\"5\" cols=\"22.5\">" + item.getDescription() + "</textarea>");
                    out.write("<form class=\"Itemform\"action=\"OfferServlet\" method=\"POST\">");
                    out.write("<button type=\"submit\">Offer</button>");
                    out.write("</form>");
                    out.write("<a  </a>");
                    out.write("</form>");
                }
            %>
        </div>
    </body>
</html>
