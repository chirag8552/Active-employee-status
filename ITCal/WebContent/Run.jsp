<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.it.DBread" %>
    <%@page import="com.it.ActiveEmpExcel" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
		<script type="text/javascript"> 

function replaceAll(txt, replace, with_this) { 
return txt.replace(new RegExp(replace, 'g'),with_this); 
} 
function showSrc() { 
document.getElementById("myframe").href = document.getElementById("myfile").value; 
var theexa=document.getElementById("myframe").href.replace("file:///",""); 
var path=document.getElementById("myframe").href.replace("file:///",""); 
window.correctPath=replaceAll(path,"%20"," "); 
if (!document.getElementById("myfile").value) {
    event.preventDefault();
    alert("Please choose a file!");
} else {
window.location.replace("ResultPage.jsp?pathname="+correctPath);
} 
}
</script>

<style type="text/css">
body {
	background-image: url("images/bg.jpg");
}

</style>

</head>
<body>
<%	
	String path1=request.getParameter("pathname");
//	out.println(path1);
	session.setAttribute("path1", path1);

	String proname=request.getParameter("name");
//	out.println(proname);
	session.setAttribute("proname", proname); 
	if (proname.equals("figtreewc") || proname.equals("figtreepl") || proname.equals("figtreemo") )
	{
	%>

<input type="file" id="myfile" size = "50" border="5px"  />
<button type="button" value="get" onclick="javascript:showSrc();">Submit</button>
<a href="#" id="myframe"></a> 

<br>
<%}
	else
	{
		DBread x=new DBread(); 
		x.SetConn(proname,path1);
		response.sendRedirect("ResultPage.jsp");
	}
// 
%>
<a href="Index.jsp">home</a>

</body>
</html>