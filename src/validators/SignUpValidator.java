package validators;

import org.apache.commons.validator.routines.EmailValidator;

public class SignUpValidator {
	public boolean validate(String userName,String email,String phone,String pass,String address){
		EmailValidator validator=EmailValidator.getInstance();
		if(userName.trim()==""||email.trim()==""||address.trim()==""||pass.trim()=="")
			return false;
		if(!validator.isValid(email))
			return false;
		if(phone.length()!=10) return false;
		try{
			Integer.parseInt(phone);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		if(pass.length()>40) return false;
		return true;
	}
}
