<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

    <title>Login</title>
  </head>
  <body>
	<div class="container">
		<div class="row">
			<div class="offset-3 col-6">
				<form action="LoginServlet" method="post">
					<div class="card">
						<div class="card-header">
							<h3>Login to System</h3>
						</div>
						<div class="card-body">
							<div class="form-group">
								<label for="username">Username</label>
								<input type="text" class="form-control" name="username" id="username" />
							</div>
							<div class="form-group">
								<label for="password">Password</label>
								<input type="password" class="form-control" name="password" id="password" />
							</div>
							<div class="form-check form-check-inline">
								<input type="checkbox" class="form-check-input" name="remember" id="remember" />
								<label for="remember" class="form-check-label">Remember me</label>
							</div>
							<br /><br />
							<div class="form-group" ><i class="alert text-danger">${message }</i></div>
						</div>
						<div class="card-footer">
							<input type="submit" class="btn btn-primary" value="Login" />
						</div>
					</div>
				</form>
			</div>
		</div>
		
	</div>
   
    
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
   
  </body>
</html>