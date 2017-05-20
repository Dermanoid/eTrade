
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="ge.mziuri.model.Item"%>
<%@page import="ge.mziuri.dao.ItemDAOImpl"%>
<%@page import="ge.mziuri.dao.ItemDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Auction</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="public/css/style.css">
    </head >
    <body class="auctionBody">
        <div class="AUForm">
            <ul>
                <li><a href="auction.jsp">Main</a></li>
                <li><a href="PersonalAcc.jsp">My Account</a></li>
                <li><a href="AboutUs.html">About Us</a></li>
            </ul>
        </div>
        <button class="InboxBtnForm" type="button" id="InboxBtn">Inbox</button>
        <div id="myModal" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <p>

                </p>
            </div>

        </div>

        <script>
            var modal = document.getElementById('myModal');

            var btn = document.getElementById("InboxBtn");

            var span = document.getElementsByClassName("close")[0];

            btn.onclick = function () {
                modal.style.display = "block";
            };

            span.onclick = function () {
                modal.style.display = "none";
            };


        </script>  

        <form action="SearchServlet" method="post">
            <div class="Search">    
                <input type="text" name="search"  placeholder="Search..">
                <button type="submit" name="Submit ">S</button>
            <div/>
        </form>
        
        <%
            int id = 0;
            if (request.getAttribute("logedInUserId") != null) {
                id = (int)request.getAttribute("logedInUserId");
            }
            if (id == 0) {
                for (Cookie cookie : request.getCookies()) {
                    if (cookie.getName().equals("logedInUserId")) {
                        id = Integer.parseInt(cookie.getValue());
                    }
                }
            }
            ItemDAO itemDAO = new ItemDAOImpl();
            List<Item> itemlist;
            if (request.getAttribute("searchedName") != null) {
                itemlist = itemDAO.getAllItemByName((String)request.getAttribute("searchedName"), id);
            } else {
                itemlist = itemDAO.getAllItem(id);
            }
            for (Item item : itemlist) {
                out.write("<div class=\"AuctionForm\">");
                out.write("<h4>" + item.getName() + "</h4>");

                out.write("<img src=\"" + "images\\" + item.getPhotoes().get(0) + "\" alt=\"Cant Find Photo\" />");
                out.write("<textarea readonly rows=\"5\" cols=\"22.5\">" + item.getDescription() + "</textarea>");
                out.write("<a href=\"PersonalAcc.jsp\"> Offer </a>" + "<a href=\"DetailedInfo.jsp\">     More... </a>"  );
                out.write("<a  </a>");
                out.write("</div>");
            }
        %>
    </body>
</html>
