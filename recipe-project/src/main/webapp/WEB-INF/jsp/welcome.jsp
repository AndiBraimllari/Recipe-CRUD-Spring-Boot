<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<link href="<c:url value="css/welcome.css"/>" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Karla" rel="stylesheet">
	<script src="js/jQuery.js"></script>
	<title>Welcome</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	
	<div class="welcome-div">
		<div class="welcome-recipes">
			<h2>Recipes</h2>
			<ul>
				<c:forEach var="recipe" items="${recipes}">
					<div class="recipe" id="${recipe.ID}">
						<div class="recipe-title">${recipe.title}</div>
						<div class="recipe-ingredients"><label>Ingredients</label> ${recipe.ingredients}</div>
						<div class="recipe-steps"><label>Steps</label> ${recipe.steps}</div>
						<hr class="recipe-horizontal-line"/>
						<div class="editDelete">
							<div class="editRecipe"><img class="editImg" src="images/edit.png"></div>
							<div class="delete-recipe"><img class="trash-can" src="images/trash-can.png"></div>
						</div>
					</div>
					<br/>
				</c:forEach> 
			</ul>
		</div>
	  <div class="welcome-vertical-line"></div>
	  <div class="welcome-homer"><img class="homer" src="images/Homer_Simpson.png"></div>
	</div>
	<script>
		$(".editImg").click(function(){
			var number = $(this).parent().parent().parent().attr("id");
			$.ajax({
				type:"POST",
				url:"/updateRecipeID",
				data:{
					mynum:number
				},
				success:function(response){
					console.log("Update succ");
				}
			})
			console.log("going now to")
			window.setTimeout(function(){ // We need the give the server some time to provide us with the id to update
				console.log("222");
				window.location = "http://localhost:8080/updateRecipe";
            }, 200);
		});
	</script>
	<script>
			$(".trash-can").click(function(){
				var recipeID = $(this).parent().parent().parent().attr('id');
				$.ajax({
				    type : "POST",
				    url : "/welcome",
				    data : {
				        id: recipeID 
				    },
				    success : function(response) {
				       console.log("Successful");
				    },
				    error : function(e) {
				       console.log('Error: ' + e);
				    }
				}); 
				window.setTimeout(function(){
					location.reload();
				}, 300);
			});
		</script>
</body>
</html>