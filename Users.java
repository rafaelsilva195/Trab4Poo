package client;

public class Users {
		
	String name;
	String adress;
	String fone;
	String email;
	String ID;
	String senha;
	
	public Users(String name, String adress, String fone, String email, String ID, String senha){
		this.name = name;
		this.adress = adress;
		this.fone = fone;
		this.email= email;
		this.ID = ID;
		this.senha = senha;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getAdress(){
		return this.adress;
	}
	
	public String getFone(){
		return this.fone;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getID(){
		return this.ID;
	}
	
	public String getSenha(){
		return this.senha;
	}
}	
