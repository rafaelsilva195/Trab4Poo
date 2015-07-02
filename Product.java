package client;

public class Product {

	String name;
	String price;
	String validate;
	String provider;
	
	public Product(String name, String price, String validate, String provider){
		this.name = name;
		this.price = price;
		this.validate = validate;
		this.provider = provider;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getPrice(){
		return this.price;
	}
	
	public String getValidate(){
		return this.validate;
	}
	
	public String getProvider(){
		return this.provider;
	}
	
	
}
