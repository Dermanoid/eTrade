<%@page import="ge.mziuri.dao.TradeDAOImpl"%>
<%@page import="ge.mziuri.dao.TradeDAO"%>
<%@page import="ge.mziuri.model.Trade"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="public/css/style.css">
        <title>Trade</title>
    </head>
    <body>
        <%
            TradeDAO tradeDAO = new TradeDAOImpl();
            int userId = 0;
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("logedInUserId")) {
                    userId = Integer.parseInt(cookie.getValue());
                }
            }
            List<Trade> trades = tradeDAO.getAllNotTradedTrades(userId);
            %>
        
    </body>
</html>
