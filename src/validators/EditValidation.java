package validators;

import org.apache.commons.validator.routines.EmailValidator;

public class EditValidation {
	public boolean validate(String pass,String email,String phone){
		EmailValidator validator=EmailValidator.getInstance();
		if(pass.trim()==""||email.trim()==""||phone.trim()=="")
			return false;
		if(!validator.isValid(email))
			return false;
		if(pass.length()>40) return false;
		if(phone.length()!=10) return false;
		try{
			Integer.parseInt(phone);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
