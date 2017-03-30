<%-- 
    Document   : Useradd
    Created on : Mar 23, 2017, 7:15:59 PM
    Author     : C4C2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="public/css/style.css">
        <title>ნივთის დამატება</title>
    </head>
    <body>
        <div class="UAForm">
            <h5 style ="display: inline-block ">სახელი : </h5>  <input type="text" name="Name" /> <br>
            <h5 style ="display: inline-block ">ნივთის ტიპი :</h5> 
            <select name="Types">
                <option value="Furniture">ავეჯი</option>
                <option value="Tech">ტექნიკა</option>
                <option value="Car">მანქანა</option>
                <option value="Ok">წვრილმანი</option>
                <option value="Area">მიწა</option>
                <option value="House">სახლი</option> 
            </select> <br>
            <h5 style ="display: inline-block">
                ნივთის მდგომარეობა :</h5>  <input type="number" name="Condition" min="1" max="100"><br>
            <h5>ტექსტის ინფორმაცია : </h5>
            <textarea  rows="5" cols="5">
                    
            </textarea> <br>

            <h5>დაამატეთ ფოტო : </h5> <img src="Photo" alt="Error: 404" /> <img src="Photo" alt="Error: 404" /> <img src="Photo" alt="Error: 404" /> <br>
            <button style="margin-bottom: 20px; margin-left: 5px" type = "button" name = "addbutton">ფოტოს ჩამატება</button> <br>          
            <input  type="submit" value="ნივთის დამატება" />
        </div>
    </body>
</html>
