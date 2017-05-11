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
            <form action="AddItemServlet" method="POST" enctype="multipart/form-data">
                <h5 style ="display: inline-block ">სახელი : </h5>  
                <input type="text" name="name"/> <br>
                <h5 style ="display: inline-block ">ნივთის ტიპი :</h5> 
                <select name="type">
                    <option value="FURNITURE">ავეჯი</option>
                    <option value="TECH">ტექნიკა</option>
                    <option value="CAR">მანქანა</option>
                    <option value="LITLE_STUFF">წვრილმანი</option>
                    <option value="GROUND">მიწა</option>
                    <option value="HOUSE">სახლი</option> 
                </select> <br>
                <h5 style ="display: inline-block">ნივთის მდგომარეობა :</h5>  
                <input type="number" name="condition" min="1" max="100"><br>
                <h5>ტექსტის ინფორმაცია : </h5>
                <textarea name="description" rows="5" cols="5"></textarea> <br>
                <h5>დაამატეთ ფოტო : </h5> 
                <img id="inp1" width="320" height="200"  src="Photo" alt="Error: 404" /> 
                <img width="320" height="200" id="inp2" src="Photo" alt="Error: 404" /> 
                <img width="320" height="200" id="inp3" src="Photo" alt="Error: 404" /> <br>
                <input id="FileUpload" style="margin-bottom: 20px; margin-left: 90px" type="file" name="file" accept="image/*" onchange="loadFile(event)" multiple  > <br>
                <script>
                    var loadFile = function (event) {
                        var output = document.getElementById('inp1');
                        output.src = URL.createObjectURL(event.target.files[0]);
                        var output = document.getElementById('inp2');
                        output.src = URL.createObjectURL(event.target.files[1]);
                        var output = document.getElementById('inp3');
                        output.src = URL.createObjectURL(event.target.files[2]);
                        var files = document.getElementById('FileUpload').files;
                        if (files.length > 3) {
                            alert("Files count is more then 3");
                          executeScript();
                        }
                    };
                </script>        
             
                <input  type="submit" value="ნივთის დამატება" />
            </form>
        </div>
    </body>
</html>



