
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<form id="loginForm" name="loginForm" action="/login" method="post">
					<div class="form-group">
						<label for="email">Email address:</label> <input type="email"
							class="form-control" id="email" name="email">
					</div>
					<div class="form-group">
						<label for="password">Password:</label> <input type="password"
							class="form-control" id="password" name="password">
					</div>
					
					<div id="errorList">
					</div>
					<div class="modal-footer">
        				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        				<button type="button" class="btn btn-primary" id="validateLoginForm">Log In</button>
      				</div>
				</form>
			</div>
		</div>
	</div>