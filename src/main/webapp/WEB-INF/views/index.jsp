<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h3>Person정보입력</h3>
    <hr>
    <!-- <form method="post" action="/person/form"> -->
    <!-- <form method="post" action="form"> -->
    <form action="/user" method="post">
        <label for="gender">Gender:</label>
        <input type="hidden" name="userId">
        <select id="gender" name="gender">
            <option value="MALE">Male</option>
            <option value="FEMALE">Female</option>
        </select><br>

        <label for="bloodType">Blood Type:</label>
        <select id="bloodType" name="bloodType">
            <option value="A">A</option>
            <option value="B">B</option>
            <option value="AB">AB</option>
            <option value="O">O</option>
        </select><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age"><br>

        <button type="submit">Register</button>
    </form>
    <br>
</body>
</html>