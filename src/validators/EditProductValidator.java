package validators;

public class EditProductValidator {
	public boolean validate(String pret,String stoc,String descriere,String nrStoc){
		if(descriere.length()>600) return false;
		if(!stoc.toLowerCase().equals("in stoc")&&!stoc.toLowerCase().equals("stoc limitat")&&!stoc.toLowerCase().equals("stoc epuizat"))
			return false;
		if(pret.matches("^[0-9]+$")==false) return false;
		if(nrStoc.matches("^[0-9]+$")==false) return false;
		return true;
	}
}
