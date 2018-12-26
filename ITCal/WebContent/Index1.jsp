<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

<!-- <script type="text/javascript"> 
/* 
function replaceAll(txt, replace, with_this) { 
return txt.replace(new RegExp(replace, 'g'),with_this); 
} 
function showSrc() { 
document.getElementById("myframe").href = document.getElementById("myfile").value; 
var theexa=document.getElementById("myframe").href.replace("file:///",""); 
var path=document.getElementById("myframe").href.replace("file:///",""); 
var correctPath=replaceAll(path,"%20"," "); 

window.location.replace("Run.jsp?name="+correctPath);

//alert(correctPath); 

}  */



</script>  -->
</head>
<body>
<!-- <form method="get" action="Run.jsp" >  -->
<!-- <input type="file" id="myfile"  size="30"> 
<input type="button" value="get" onclick="javascript:showSrc();">
<br> 
<a href="#" id="myframe"></a> 
<input type="submit" value="submit" onChange=""/> -->
<!-- </form>  -->

<script type="text/javascript">

function file1() {
	var path1=document.getElementById("myfile1").value;
//	alert(path1);
}

function file2() {
	var path2=document.getElementById("myfile2");
}

function pass(){
	window.location.replace("Run.jsp?path1="+path1+"&path2="+path2);
}

</script>


<!-- <input type="file" id="myfile1">
<input type="file" id="myfile2">

<input type="button" value="Submit" onclick="pass()">
<button onclick="file1()">Click me</button>
 -->


<div ng-app="">
 
<p>Input something in the input box:</p>
<p>Name: <input type="file" ng-model="name"></p>

<p>Input something in the input box:</p>
<p>Name: <input type="file" ng-model="x"></p>
<!-- <p ng-bind="name+';'+x"></p> -->

<a href="try.jsp?parm={{name+x}}">try</a>

</div>



</body>
</html>