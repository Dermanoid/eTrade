<%@page import="java.util.List"%>
<%@page import="ge.mziuri.dao.ItemDAOImpl"%>
<%@page import="ge.mziuri.model.Item"%>
<%@page import="ge.mziuri.dao.ItemDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Personal Acc.</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="public/css/style.css">
    </head>
    <body class="PaBody">
        <div class="AUForm1"  >
            <ul>
                <li><a href="auction.jsp">Main</a></li>
                <li><a href="PersonalAcc.jsp">My Account</a></li>
                <li><a href="AboutUs.html">About Us</a></li>
            </ul>
        </div>
        <%
            int id = 0;
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("logedInUserId")) {
                    id = Integer.parseInt(cookie.getValue());
                }
            }
            ItemDAO itemDAO = new ItemDAOImpl();
            List<Item> itemList = itemDAO.getAllMyItems(id);
            for (Item item : itemList) {
                out.write("<form action=\"DeleteItemServlet\" method=\"POST\" class=\"AuctionForm\">");
                out.write("<h4>" + item.getName() + "</h4>");
                out.write("<img src=\"" + "images\\" + item.getPhotoes().get(0) + "\" alt=\"Cant Find Photo\" />");
                out.write("<textarea readonly rows=\"5\" cols=\"22.5\">" + item.getDescription() + "</textarea>");
                out.write("<input name=\"itemId\" type=\"hidden\" value=\"" + item.getId() + "\"> </input>");
                out.write("<input type=\"Submit\" value = \"Delete\"></input>");
                out.write("<a  </a>");
                out.write("</form>");
            }
        %>
          <a name="Additemlink"  href="addItem.jsp">Add Item</a>
    </body>
</html>
