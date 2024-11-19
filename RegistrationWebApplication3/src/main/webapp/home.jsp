<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.sg.registrationmodelclass.Registration" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <style>
    
   @import url('https://fonts.googleapis.com/css2?family=Lexend:wght@100..900&display=swap');
    
        body {
            font-family: "Lexend", sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
        }
        
        .headings{
        	background-color: #79def2;
        	height:100px;
        	align-content: center;
        	
        }

        h1 {
            margin:auto 0;
            text-align: center;
            color: #333;
            font-size: 40px;
            
        }

        .btn {
            display: inline-block;
            background-color: #007bff;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            font-size: 16px;
            cursor: pointer;
            margin: 10px 0;
        }
        
	    .center-container {
		    display: flex;
		    justify-content: center;
		    align-items: center;
		    /* Full viewport height */
		    background-color: #f4f4f9; /* Match the page background */
}
        
        .reg-btn-container{
        	align-items: center;
        }
        
        .reg-btn{
         	display: inline-block;
        	background-color: #007bff;
        	color: #fff;
        	padding: 10px 15px;
        	border: none;
        	 border-radius: 5px;
            text-decoration: none;
            font-size: 16px;
            cursor: pointer;
            margin: 10px 0;
        	
        }
        .reg-btn:hover{
        	background-color: #7693DF;
        }
        
        
        .btn:hover {
            background-color: #0056b3;
        }

        .cards {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            gap: 20px;
        }

        .card {
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 300px;
            text-align: center;
        }

        .card h3 {
            color: #007bff;
            margin-bottom: 10px;
        }

        .card p {
            color: #555;
            margin: 5px 0;
        }

        .card .btn {
            margin-top: 10px;
        }

        .no-data {
            text-align: center;
            color: #777;
            font-size: 18px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class = "headings">
        	<h1>Registration List</h1>
        </div>
        <div class="center-container">
    <div class="reg-btn-container">
        <a href="newRegister.jsp" class="reg-btn">Register Here</a>
    </div>
</div>
        <div class="cards">
            <% 
                ArrayList<Registration> rList = (ArrayList<Registration>)request.getSession().getAttribute("rList");

                if (rList != null && !rList.isEmpty()) {
                    for (Registration reg : rList) {
            %>
                <div class="card">
                    <h3><%= reg.getName() %></h3>
                    <p><strong>ID:</strong> <%= reg.getId() %></p>
                    <p><strong>Email:</strong> <%= reg.getEmail() %></p>
                    <p><strong>Date of Birth:</strong> <%= reg.getDob() %></p>
                    <p><strong>Phone:</strong> <%= reg.getPhone() %></p>
                    <p><strong>Address:</strong> <%= reg.getAddress() %></p>
                    <a href="FetchOnId?id=<%= reg.getId() %>" class="btn">Edit</a>
                    <a href="DeleteOnId?id=<%= reg.getId() %>" class="btn" style="background-color: #dc3545;">Delete</a>
                </div>
            <% 
                    }
                } else { 
            %>
                <div class="no-data">No Registration found</div>
            <% } %>
        </div>
    </div>
</body>
</html>
