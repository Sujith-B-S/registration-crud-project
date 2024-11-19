<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.sg.registrationmodelclass.Registration" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Page</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Lexend:wght@100..900&display=swap');
        
        body {
            font-family: "Lexend", sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 30px;
            width: 400px;
        }

        h1 {
            text-align: center;
            color: #007bff;
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
            color: #333;
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="email"],
        input[type="date"],
        input[type="tel"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            width: 100%;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <% 
        Registration reg = (Registration) request.getSession().getAttribute("reg");
    %>
    <div class="form-container">
        <h1>Edit Details</h1>
        <form action="UpdateDetails" method="post">
            <label for="id">ID</label>
            <input type="text" id="id" name="id" value="<%= reg.getId() %>" readonly="readonly">

            <label for="name">Name</label>
            <input type="text" id="name" name="name" value="<%= reg.getName() %>">

            <label for="email">Email</label>
            <input type="email" id="email" name="email" value="<%= reg.getEmail() %>">

            <label for="dob">Date of Birth</label>
            <input type="date" id="dob" name="dob" value="<%= reg.getDob() %>">

            
            
            <label for="phone">Phone</label>
			<input type="tel" id="phone" name="phone" value="<%= reg.getPhone() %>" required pattern="[0-9]{10,}" title="Please enter a valid phone number with at least 10 digits">
            

            <label for="address">Address</label>
            <input type="text" id="address" name="address" value="<%= reg.getAddress() %>">

            <input type="submit" value="Update Details">
        </form>
    </div>
</body>
</html>
