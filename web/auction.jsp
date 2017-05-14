
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="ge.mziuri.model.Item"%>
<%@page import="ge.mziuri.dao.ItemDAOImpl"%>
<%@page import="ge.mziuri.dao.ItemDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>აუქციონი</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="public/css/style.css">
    </head >
    <body class="auctionBody">
        <div class="AUForm">
            <ul>
                <li><a href="auction.jsp">მთავარი</a></li>
                <li><a href="PersonalAcc.jsp">ჩემი ანგარიში</a></li>
                <li><a href="AboutUs.html">ჩვენ შესახებ</a></li>
            </ul>
        </div>
        <button class="InboxBtnForm" type="button" id="InboxBtn">Inbox</button>
        <div id="myModal" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <p>Nothing To Show</p>
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

        <form action="" method="post">
            <div class="Search">    
                <input type="text" name="search"  placeholder="Search..">
                <button type="submit" name="Submit ">S</button>
                <div/>
        </form>
        <%
            ItemDAO itemDAO = new ItemDAOImpl();
            List<Item> itemlist = itemDAO.getAllItem();
            for (Item item : itemlist) {
                out.write("<div class=\"AuctionForm\">");
                out.write("<img src=\"" + "images\\" + item.getPhotoes().get(0) + "\" alt=\"ფოტო ვერ მოიძებნა\" />");
                out.write("<textarea readonly rows=\"5\" cols=\"22.5\">" + item.getDescription() + "</textarea>");
                out.write("<a href=\"PersonalAcc.jsp\"> შეთავაზება </a>");
                out.write("<a  </a>");
                out.write("</div>");
            }
        %>
    </body>
</html>
