<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
	<link href="<c:url value="css/login.css"/>" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Lato:700" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
	
</head>
<body>
	<div class="login-box-img">
		<div class="wrapper">
		    <form class="form-signin" action="/login" method="POST">       
		      <h2 class="form-signin-heading">Please login</h2>
		      <input type="text" class="form-control" name="username" placeholder="Name" required="" autofocus="" />
		      <input type="password" class="form-control" name="password" placeholder="Password" required=""/>      
		      <button class="login-button" type="submit">Login</button>   
		    </form>
	  </div>
	  <div class="vertical-line"></div> 
	  <div class="img-homer"><img class="homer" src="images/homer-minidonut-flip.png"></div> 
	</div>
</body>
</html>