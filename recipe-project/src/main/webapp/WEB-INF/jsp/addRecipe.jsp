<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<link href="<c:url value="css/add-recipe.css"/>" rel="stylesheet"/>
	<title>Add Recipe</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<h2>Create Recipe</h2><br/>
	<div class="addRecipe"> 
		<form action="/addRecipe" method="POST"> 
			<div class="addIDdiv">ID</div>
			<div class=IDNote>You can leave this empty, our chefs will ID it for you.</div>
			<input type="text" name="id"/></br></br>
			<div class="addTitlediv" maxlength="50">Title</div>
			<input type="text" name="title" /></br></br>
			<div class="addIngdiv" maxlength="200">Ingredients</div>
			<input type="text" name="ing"/></br></br>
			<div class="addStepsdiv">Steps</div>
			<input type="text" name="steps" maxlength="1000"/></br><br/>
			<hr class="hrAddRecipe"/>
			<input class="privateCheckBox" type="checkbox" value="private" name="privateCheckbox"/><label>Private</label>
			<div class="privateNote">Private recipe means you have a recipe as secret as Krabby Patty and no one can find it!</div>
			<input type="hidden" value="public" name="privateCheckbox"/>
			<input type="submit" value="Add Recipe"/>
		</form>
	</div>
</body>
</html>
