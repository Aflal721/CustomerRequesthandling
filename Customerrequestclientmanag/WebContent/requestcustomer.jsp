<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="model.Customerrequest"%>
<%
//Save---------------------------------
if (request.getParameter("customerName") != null)
{
Customerrequest itemObj = new Customerrequest();
String stsMsg = "";
//Insert--------------------------
if (request.getParameter("hidItemIDSave") == "")
{
stsMsg = itemObj.insertcustomerdetails(request.getParameter("customerName"),
request.getParameter("customerEmail"),
request.getParameter("customerPhone"),
request.getParameter("projecttype"),
request.getParameter("Description"),
request.getParameter("Duration"));
}
else//Update----------------------
{
stsMsg = itemObj.updatecustomerdetails(request.getParameter("hidItemIDSave"),
request.getParameter("customerName"),
request.getParameter("customerEmail"),
request.getParameter("customerPhone"),
request.getParameter("projecttype"),
request.getParameter("Description"),
request.getParameter("Duration"));

}
session.setAttribute("statusMsg", stsMsg);
}
//Delete-----------------------------
if (request.getParameter("hidItemIDDelete") != null)
{
Customerrequest itemObj = new Customerrequest();
String stsMsg =
itemObj.deleteItem(request.getParameter("hidItemIDDelete"));
session.setAttribute("statusMsg", stsMsg);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/items.js"></script>
<title>Customer Management</title>
</head>
<body>
<h1>Customer Management</h1>

<form id="formItem" name="formItem" method="post" action="items.jsp">
 customerName:
<input id="customerName" name="customerName" type="text"
 class="form-control form-control-sm">
<br> customerEmail:
<input id="customerEmail" name="customerEmail" type="text"
 class="form-control form-control-sm">
<br> customerPhone:
<input id="customerPhone" name="customerPhone" type="text"
 class="form-control form-control-sm">
<br> project type:
<input id="projecttype" name="projecttype" type="text"
 class="form-control form-control-sm">
 <br> Description:
<input id="Description" name="Description" type="text"
 class="form-control form-control-sm">
 <br> Duration:
<input id="Duration" name="Duration" type="text"
 class="form-control form-control-sm">
<br>
<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>


<br>
<div id="divItemsGrid">
<%
Customerrequest itemObj = new Customerrequest();
 out.print(itemObj.readCustomerrequest());
%>
</div>
</body>
</html>