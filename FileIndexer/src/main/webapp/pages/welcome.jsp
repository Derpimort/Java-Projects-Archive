<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>File Indexer</title>

    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <link rel="stylesheet" type="text/css" href="css/loading.css">

</head>

<body>

	<nav class="navbar navbar-expand-md navbar-dark bg-dark navbar-fixed-top">
	    <a class="navbar-brand" href="#">LegendBois</a>
	</nav>
	
	<div class="container" style="padding-top:25px;">
		<section class="home">
		    <div style="text-align:center;margin-top:10%;">
		        <a id="folder" class="btn danger" href=".?choose=folder">Choose folder</a>
		    </div>
		    <!--<div style="text-align:center;margin-top:20px;">
		        <a class="btn danger" href=".?choose=file">Choose file</a>
		    </div>-->
		    <br>
		    <p>OR</p>
		    <div style="text-align:center;margin-top:20px;">
		        <a class="btn danger" href="rows">Browse Files</a>
		    </div>
		</section>
		<section id="loading" class="loading">
		    <div class="box">
		        <div class="b b1"></div>
		        <div class="b b2"></div>
		        <div class="b b3"></div>
		        <div class="b b4"></div>
		        <!--<div class="b5">0%</div>-->
		    </div>
		</section>
	</div>
	<!-- /.container -->
	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<script>
	/*function getParameterByName(name, url) {
	    if (!url) url = window.location.href;
	    name = name.replace(/[\[\]]/g, '\\$&');
	    var regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
	        results = regex.exec(url);
	    if (!results) return null;
	    if (!results[2]) return '';
	    return decodeURIComponent(results[2].replace(/\+/g, ' '));
	}
    if (getParameterByName("choose")=="folder"){
    	$(".home").fadeOut();
        $(".loading").fadeIn();
        }
    */
    $(".danger").click(function(){
        $(".home").fadeOut();
        $(".loading").fadeIn();
    })
    
        
    
	</script>
</body>
</html>