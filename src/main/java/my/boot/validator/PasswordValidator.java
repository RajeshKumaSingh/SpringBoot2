package my.boot.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import my.boot.form.SignUpForm;

public class PasswordValidator implements ConstraintValidator<ValidPassword, SignUpForm>{

	@Override
	public boolean isValid(SignUpForm form, ConstraintValidatorContext context) {
		return form.getPassword().equals(form.getRetypePassword());
	}

}
