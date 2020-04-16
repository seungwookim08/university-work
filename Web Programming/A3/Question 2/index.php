<!DOCTYPE html>
<html>
<head>
	<title></title>
	<style type="text/css">
	/*
		As it requires some css style, I added some css style for it. 
	*/
	table{
		margin: 50px;
	}
	table,td,tr{
	    border: 1px solid black;
    	border-collapse: collapse;
	}
	td {
		height: 30px;
	}
	.col1{
		text-align: center;
		width:150px;
		font-weight: bold;
		background-color:#FFEBCD;
	}
	.col2{
		text-indent: 5px;
		width: 350px;
		background-color:#F0FFFF;
	}	
	</style>	
</head>
<body>
	<h3>
		Testing query string!
	</h3>
	Please enter proper query string in URL and it will show what you have passed.
	<table>
		<tr>
			<td class="col1">
				Name
			</td>
			<td class="col2">
				<?php 
					if (empty($_GET['name'])){
						echo "No query string data found";
					}
					else{
						echo $_GET['name'];
					}
				?>
			</td>
		</tr>
		<tr>
			<td class="col1">
				Age
			</td>
			<td class="col2">
				<?php
					if(empty($_GET['age'])){
						echo "No query string data found";
					}
					else{
						echo $_GET['age'];
					}
				?>
			</td>
		</tr>
		<tr>
			<td class="col1">
				Phone Number
			</td>
			<td class="col2">
				<?php
					if(empty($_GET['number'])){
						echo "No query string data found";
					}
					else{
						echo $_GET['number'];
					}		
				?>
			</td>			
		</tr>
	</table>
</body>
</html>