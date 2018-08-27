<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<link href="<c:url value="css/settings.css"/>" rel="stylesheet"/>
	<script src="js/jQuery.js"></script>
	<title>Settings</title>
</head>
<body>
	<jsp:include page="menu.jsp"/>
	<h2>Settings</h2>
	<div class="updateUser"> 
		<form class="updateUserForm" action="/updateUser" method="POST"> 
			<div>Favourite Dish</div>
			<input class="favDish" type="text" name="dish" value="${user.dish}"/></br></br>
			<div>Address</div>
			<input class="address" type="text" name="address" value="${user.address}"/></br></br>
			<div>Password</div>
			<input class="passwordInput" type="password" name="password" value="${user.password}"/></br>
			<input type="submit" value="Update User"/>
		</form>
	</div>
	<script>
		$(".updateUserForm").submit(function(event){
			event.preventDefault();
			var pass = $(".passwordInput").val();
			var dish = $(".favDish").val();
			var address = $(".address").val();
			$.ajax({
				url:"/settings",
				type:"POST",
				data:{
					passParam:pass,
					dishParam:dish,
					addressParam:address
				}
			});
			window.location = "http://localhost:8080/welcome";
		});
	</script>
</body>
</html>