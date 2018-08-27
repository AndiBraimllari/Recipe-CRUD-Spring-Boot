<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<link href="<c:url value="css/update-recipe.css"/>" rel="stylesheet"/>
	<script src="js/jQuery.js"></script>
	<title>Update Recipe</title> 
</head>
<body>
	<jsp:include page="menu.jsp" />
	<c:choose>
		<c:when test="${idToUpdate == -1}">
	    	<h2 class="chooseUpdateHeader">Choose a recipe to update!</h2>
	  	</c:when>
	  	<c:otherwise>
	  		<div class="update-recipe-div">
	  			<h2 class="updateHeader">Update Recipe</h2>
	  			<form action="/updateRecipe" method="POST" class="updateForm">
			    	<div class="recipe" id="${recipe.ID}">
						<div class="recipe-title">Title<br/><br/>
							<input type="text" value="${recipe.title}" name="titleToUpdate"/><br/>
						</div><br/>
						<div class="recipe-ingredients">Ingredients<br/><br/>
							<input type="text" value="${recipe.ingredients}" name="ingToUpdate"/><br/>
						</div><br/>
						<div class="recipe-steps">Steps<br/><br/>
							<input type="text" value="${recipe.steps}" name="stepsToUpdate"/><br/>
						</div><br/>
						
						<input class="updateButton" type="submit" value="Update Recipe" />
					</div>
				</form>
			</div>
	  	</c:otherwise>
	</c:choose>
	<script>
		$(".updateForm").submit(function(event) {
			event.preventDefault();
			var inputTitle = $(".recipe-title input").val();
			var inputIng = $(".recipe-ingredients input").val();
			var inputSteps = $(".recipe-steps input").val();
			$.ajax({
				type: "POST",
				url: "updateRecipe",
				data: {
					titleToUpdate:inputTitle,
					ingToUpdate:inputIng,
					stepsToUpdate:inputSteps
				}
			});
			window.setTimeout(function(){
				window.location = "http://localhost:8080/welcome";
			}, 100);
		});
	</script>
</body>
</html>