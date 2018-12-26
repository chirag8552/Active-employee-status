<%@page import="java.util.ArrayList"%>
<%@page import="com.it.XlRead"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-image: url("images/bg.jpg");
}

</style>
</head>
<body>
<h1><%String noDBfile=request.getParameter("pathname");
		//out.println(x);%></h1>
<h1><%String activempfile=(String)session.getAttribute("path1"); // out.println(z); %></h1>
<h1><%String projname=(String)session.getAttribute("proname"); %>  Updated successfully</h1>

<%  XlRead y=new XlRead();
	ArrayList<String> a=y.cmpxl(activempfile,noDBfile,projname);
	
	for(Object k:a)
	{
		out.println(k);
	} 
%>

<h1><a href="Index.jsp">home</a></h1>
</body>
</html>