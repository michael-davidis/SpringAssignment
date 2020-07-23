<%--
    Document   : hi
    Created on : Jun 12, 2020, 8:58:26 PM
    Author     : Laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="/css/style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>Trainers</title>
</head>
<body background="img/6l0QrN.jpg">
<div>
    <h3 class="header">LACONDA PRIVATE SCHOOLS</h3>
    <h1 class="header">Trainers</h1>
</div>
<div class="container mainBody">
    <table class="opaque">
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Subject</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>

        <c:forEach items="${trainerList}" var="trainer">
            <tr>
                <td> ${trainer.firstName} </td>
                <td> ${trainer.lastName} </td>
                <td> ${trainer.subject} </td>
                <td class="td-alignment">
                    <form action="update" method="get">
                        <input type="hidden" id="id_update" name="id" value="${trainer.id}">
                        <input class="button" type="submit" value="Update">
                    </form>
                </td>
                <td class="td-alignment">
                    <form action="delete" onsubmit="return confirmDelete()" method="get">
                        <input type="hidden" id="id_delete" name="id" value="${trainer.id}">
                        <input class="button delete-button" type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="createButton opaque">
    <form action="create" method="get">
        <input class="button" type="submit" value="Create Trainer">
    </form>
</div>
<script src="js/scripts.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
</body>
</html>