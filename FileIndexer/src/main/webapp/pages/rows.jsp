<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>All Data</title>
	
	<link type="text/css" href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	
	<link type="text/css" href="webjars/datatables/1.10.21/css/dataTables.bootstrap4.min.css" rel="stylesheet">
	
	<script src="webjars/datatables/1.10.21/js/jquery.dataTables.min.js"></script>
	<script src="webjars/datatables/1.10.21/js/dataTables.bootstrap4.min.js"></script>
	
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark navbar-fixed-top">
	    <a class="navbar-brand" href="#">LegendBois</a>
	</nav>
	<div class="container" style="padding-top:25px;">
		<main>
			<table id="filestable" class="table table-striped">	
				<thead>
			      <tr>
			      	<th>ID</th>
			        <th>Filename</th>
			        <th>Path</th>
			        <th>Content</th>
			      </tr>
			    </thead>
			    <tr>
				    <td>0</td>
				    <td>Test</td>
				    <td>Test</td>
				    <td>Test</td>
			    </tr>
			</table>
		</main>
	</div>
	
	<script>
		$(document).ready( function () {
			 var table = $('#filestable').DataTable({
				"sAjaxSource": "/all",
				"sAjaxDataProp": "",
				"order": [[ 0, "asc" ]],
				"columns": [
					{ "data": "id"},
					{ "data": "fname"},
					{ "data": "path"},
					{ "data": "content"},				    
				],
				 "columnDefs": [ {
				        targets: 2,
				        render: function ( data, type, row ) {
					        return data.replace("/home/darp_lord", "~");
				        }
				 },
				        {
					        targets: 3,
					        render: function ( data, type, row ) {
					        	return data.substr( 0, 60 )+"...";
					        }
				        }
				  ]
			 })
		});	
	</script>
</body>
</html>