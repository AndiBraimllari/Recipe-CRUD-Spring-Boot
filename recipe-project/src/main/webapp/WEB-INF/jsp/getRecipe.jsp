<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<link  href="<c:url value="css/get-recipe.css"/>" rel="stylesheet"/>
	<link href="https://fonts.googleapis.com/css?family=Karla" rel="stylesheet">
	<title>Show Recipe</title> 
</head>
<body>
	<jsp:include page="menu.jsp" />
	<c:choose>
		<c:when test="${recipe == null}">
	    	<h2>Search for a public Recipe!</h2>
	  	</c:when>
	  	<c:otherwise>
	  		<h2 class="getRecipeHeader">Recipe</h2>
	    	<div class="recipe" id="${recipe.ID}">
				<div class="recipe-title">${recipe.title}</div>
				<div class="recipe-ingredients"><label>Ingredients</label> ${recipe.ingredients}</div>
				<div class="recipe-steps"><label>Steps</label> ${recipe.steps}</div>
			</div>
	  	</c:otherwise>
	</c:choose>
</body>
</html>