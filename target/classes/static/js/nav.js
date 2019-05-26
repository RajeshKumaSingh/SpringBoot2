$(document).ready(function() {
	
	$("#loginLink").click(function(e){
		$("#errorList").removeClass("alert alert-danger alert-dismissible fade show");
        $("#errorList").html("");
	});
	
	$("#validateLoginForm").click(function(e){
		$("#errorList").removeClass("alert alert-danger alert-dismissible fade show");
        $("#errorList").html("");
		$.ajax({
			type: "POST",
			url: "/validateLoginForm",
			data: $("#loginForm").serialize(),
			success: function (data) {
                console.log('Submission was successful.');
                console.log(data);
                var errorList ="";
                data.forEach(function(value){
                	console.log(value); 
                	if(value=="success"){
                		$("#loginForm").submit(); return;
                	}
                	else{
                		errorList += value+"<br />";
                	}
                });
                if(errorList.length>0){
                	 $("#errorList").addClass("alert alert-danger alert-dismissible fade show");
                     $("#errorList").html(errorList);
                }
            },
            error: function (data) {
                console.log('An error occurred.');
                console.log(data);
            }
		});
		
	});
	
	$("#signUpLink").click(function(e){
		$("#errorList").removeClass("alert alert-danger alert-dismissible fade show");
        $("#errorList").html("");
	});
	
	$("#validateSignUp").click(function(e){
		$("#errorList").removeClass("alert alert-danger alert-dismissible fade show");
        $("#errorList").html("");
		$.ajax({
			type: "POST",
			url: "/validateSignUp",
			data: $("#signUpForm").serialize(),
			success: function (data) {
                console.log('Submission was successful.');
                console.log(data);
                var errorList ="";
                data.forEach(function(value){
                	console.log(value); 
                	if(value=="success"){
                		$("#signUpForm").submit();return;
                	}
                	else{
                		errorList += value+"<br />";
                	}
                	
                });
                if(errorList.length>0){
               	 	$("#errorList").addClass("alert alert-danger alert-dismissible fade show");
                    $("#errorList").html(errorList);
                }              
            },
            error: function (data) {
                console.log('An error occurred.');
                console.log(data);
            }
		});
		
	});
});