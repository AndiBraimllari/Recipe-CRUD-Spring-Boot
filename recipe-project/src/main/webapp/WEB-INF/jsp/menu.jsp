<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value="css/menu.css"/>" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css?family=Lato:700" rel="stylesheet">
<div class="menu-div">

    <a href="/welcome" class="welcome-class">Home</a>  
    <a href="/addRecipe">Add Recipe</a>
    <a href="/updateRecipe">Update Recipe</a>  
    <a href="/getRecipe">Recipe Results</a>  
    
    <div class="search-class">
    	<form class="search-form" action="/getRecipe" method="POST">
		  <input type="text" name="search-recipe" placeholder="Search...">
		</form>
    </div>
    
    <a class="settings" href="/settings">Settings</a>
    <a onclick="document.forms['logoutForm'].submit()">Logout</a>
            
    <form id="logoutForm" method="POST" action="/logout">
    </form>

</div>