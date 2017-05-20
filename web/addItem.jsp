<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="background-color: #9e9e9e">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="public/css/style.css">
        <title>Item Add</title>
    </head>
    <body>
        <div class="UAForm">
            <form action="AddItemServlet" method="POST" enctype="multipart/form-data">
                <h5 style ="display: inline-block ">Name : </h5>  
                <input type="text" name="name"/> <br>
                <h5 style ="display: inline-block ">Type :</h5> 
                <select name="type">
                    <option value="FURNITURE">Furniture</option>
                    <option value="TECH">Tech</option>
                    <option value="CAR">Car</option>
                    <option value="LITLE_STUFF">Tiny Stuff</option>
                    <option value="GROUND">Ground</option>
                    <option value="HOUSE">House</option> 
                </select> <br>
                <h5 style ="display: inline-block">Condition :</h5>  
                <input type="number" name="condition" min="1" max="100"><br>
                <h5>Description : </h5>
                <textarea name="description" rows="5" cols="5"></textarea> <br>
                <h5>Add a Photo : </h5> 
                <img id="inp1" width="320" height="200"  src="Photo" alt="Photo 1" /> 
                <img width="320" height="200" id="inp2" src="Photo" alt="Photo 2" /> 
                <img width="320" height="200" id="inp3" src="Photo" alt="Photo 3" /> <br>
                         <h5 style="margin-top: 1px;margin-bottom: 6px">Max 3 Photos !!! </h5>
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
                            alert("Max 3 Photos ");
                            executeScript();
                        }
                    };
                </script>
                <input type="submit" value="ნივთის დამატება" />
            </form>
        </div>
    </body>
</html>



