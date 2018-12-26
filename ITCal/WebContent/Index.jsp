<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.it.ReadTime" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script type="text/javascript"> 

function replaceAll(txt, replace, with_this) { 
return txt.replace(new RegExp(replace, 'g'),with_this); 
} 
function showSrc() { 
document.getElementById("myframe").href = document.getElementById("myfile").value; 
var theexa=document.getElementById("myframe").href.replace("file:///",""); 
var path=document.getElementById("myframe").href.replace("file:///",""); 
window.correctPath=replaceAll(path,"%20"," "); 
var proname=document.getElementById("database").value;

    if (!document.getElementById("myfile").value) {
        event.preventDefault();
        alert("Please choose a file!");
    } else {
window.location.replace("Run.jsp?pathname="+correctPath+"&name="+proname);
//alert(correctPath); 
    }
} 

</script>
<title>IT Security Calender</title>
<style>
body {
	background-image: url("images/bg.jpg");
}

.browse{
	padding-top: 150px;
	padding-left: 60px;
}

.display{
	padding-top: 100px;
}
#status{
    background-color: white;
    width: 400px; 
}
.dropdown {
	position: relative;
	display: inline-block;
	min-width: 160px;
	padding: 8px;
	font-size: 16px;
	cursor: pointer;
	border-color: #4CAF50;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.btn {
	width: 70px;
	height: 35px;
	cursor: pointer;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #f1f1f1
}

.dropdown:hover .dropdown-content {
	display: block;
}
</style>
</head>
<body>
	<center>
		<h1>IT Security Calender - Task 14</h1>
	
		<script>
			function myFunction() {
  			 /*  var x = document.createElement("INPUT");
  			  x.setAttribute("type", "file");
 			   document.body.appendChild(x); */
				var x = document.getElementById("myFile");
		 	  	 x.disabled = false;	   
			}
		function myFunction1() {
	    var x = document.getElementById("myFile");
 	  	 x.disabled = true;
		}
		</script>
		
		<div class="display">
		<label>Application: </label>	<select id="database" class="dropdown">
				
				<option value="pmweb" onclick="myFunction1()">PMWEB</option>
				<option  value="ops" onclick="myFunction1()">ONLINE PAYSLIP</option>
				<option  value="figtreewc" onclick="myFunction()">FIGTREE WC</option>
				<option  value="figtreepl" onclick="myFunction()">FIGTREE PL</option>
				<option  value="figtreemo" onclick="myFunction()">FIGTREE MO</option>
				<option  value="cams" onclick="myFunction1()">CAMS</option>
				<option  value="icms" onclick="myFunction1()">ICMS</option>
			</select> 
				
		<!-- 	<input type="file" id="myFile" disabled="disabled"> -->
			<div class="browse">
			 All Active Employee List: <input type="file" id="myfile" size = "50" border="5px"  />
		<button type="button" value="get" onclick="javascript:showSrc();">Submit</button>

		<br> 
		<a href="#" id="myframe"></a> 
	
            </div>   

         </div>
         <div id="status">
         <table >
         <%  ReadTime r=new ReadTime();
         	String pmweb=r.dat("pmweb");
         	String ops=r.dat("ops");
         	String figtreewc=r.dat("figtreewc");
         	String figtreepl=r.dat("figtreepl");
         	String figtreemo=r.dat("figtreemo");
         	String cams=r.dat("cams");
         	String icms=r.dat("icms");
         	
         	%>
              <tr><td>PMWEB          :  <%=pmweb%></td></tr>
              <tr><td>ONLINE PAYSLIP :  <%=ops%></td></tr>
              <tr><td>FIGTREE WC     :  <%=figtreewc%></td></tr>
              <tr><td>FIGTREE PL     :  <%=figtreepl%></td></tr>
              <tr><td>FIGTREE MO     :  <%=figtreemo%></td></tr>
              <tr><td>CAMS           :  <%=cams%></td></tr>
              <tr><td>ICMS           :  <%=icms%></td></tr>
         </table>                              
         </div>
		
	</center>
</body>