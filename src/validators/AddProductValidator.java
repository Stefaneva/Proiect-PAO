package validators;

public class AddProductValidator {
	public boolean validate(String productName, String stoc, String price, String category, String description, String nrStoc){
		if(productName.trim()==""||stoc.trim()==""||price.trim()==""||category.trim()==""||description.trim()==""||nrStoc.trim()=="")
			return false;
		return true;
	}
}
