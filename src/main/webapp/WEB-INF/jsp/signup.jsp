
<div class="container">
		<div class="row">
			<div class="col-md-12">
				<form id="signUpForm" name="signUpForm" action="/signUp" method="post">
					<div class="form-group">
						<label for="userName">User Name:</label> <input type="text"
							class="form-control" id="userName" name="userName">
					</div>
					<div class="form-group">
						<label for="email">Email address:</label> <input type="email"
							class="form-control" id="email" name="email">
					</div>
					<div class="form-group">
						<label for="password">Password:</label> <input type="password"
							class="form-control" id="password" name="password">
						
						<label for="retypePassword">Re-type Password:</label> <input
							type="password" class="form-control" id="retypePassword"
							name="retypePassword" >
					</div>
					<div id="errorList">
					</div>
					<div class="modal-footer">
        				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        				<button type="button" class="btn btn-primary" id="validateSignUp">Sign Up</button>
      				</div>
				</form>
			</div>
		</div>
	</div>
	
