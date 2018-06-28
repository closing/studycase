<!doctype html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajaxdemo</title>
<script type="text/javascript">
	function loadXMLDoc() {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveObject("Microsoft.XMLHttp");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
			}
		};

		// POST
		// xmlhttp.open("POST", "/ajax_info.txt", true);
		//xmlhttp.setRequestHeader("Content-type",
		//		"application/x-www-form-urlencoded");
		//xmlhttp.send("fname=Henry&lname=Ford");

		// GET
		xmlhttp.open("GET","/ajax_info.txt");
		xmlhttp.send();
	}
</script>
</head>
<body>
	<div id="myDiv"></div>
	<button type="button" onclick="loadXMLDoc();">Ajax</button>
</body>
</html>