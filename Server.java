package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
public class Server{
	
	public Server (){
	}
	
	//-----------------   Login   ------------------
	
	//Essa parte do código faz o login
	
	public int Login(String login, String senha){
		
		BufferedReader br1 = null;
    	String sID = null;
    	String sLine = null;
    	String auxLine = null;
    	String sSenha = null;
    	int begin;
    	int end;
    	int n = 0;
    	
    	try {
    		br1 = new BufferedReader(new FileReader("User.csv"));
    		
    		sLine = br1.readLine();
    		while(sLine != null){
    			//while que procura no arquivo Users
    			
    			begin = auxLine.indexOf(",");
    			end = auxLine.length();
    			auxLine = sLine.substring(begin + 1, end);
    			while(n < 3){
        			begin = auxLine.indexOf(",");
        			end = auxLine.length();
        			auxLine = auxLine.substring(begin + 1, end);
        			n++;
    			}
    			
    			begin = 0;
    			end = auxLine.indexOf(",");
    			sID = auxLine.substring(begin, end - 1);
    			
    			if(sID == login){
    				//Entra nesse If caso encontra a ID descrita no login
    				
    				begin = auxLine.indexOf(",");
    				end = auxLine.length();
    				sSenha = auxLine.substring(begin, end - 1);
    				if(sSenha == senha){
    					br1.close();
    					return 3;
    				}
    				else{
    					br1.close();
    					return 2;
    				}
    			}
    		}
    		br1.close();
    		return 1;
    	}
	    catch (IOException ioe) {
	        ioe.printStackTrace();
	    } finally { // always close the file
	        if (br1 != null) {
	            try {
	                br1.close();
	            } catch (IOException ioe2) {
	            	
	            }
	        }
	    }
		return 0;
	}
	
	//--------------------------   Cadastro de um novo Cliente   ----------------------
	
	//Ele cadastra um novo cliente
	
	
	public int CadNewUser(String nome, String adress, String fone, String email, String ID, String senha){
		BufferedWriter bwU = null;
		Users usuario = new Users(nome, adress, fone, email, ID, senha);
        try {        	
            bwU = new BufferedWriter(new FileWriter("Users.csv", true));
            bwU.write(usuario.getName() + "," + usuario.getAdress() + "," + usuario.getFone() + "," + 
            				usuario.getEmail()+ "," + usuario.getID() + "," + usuario.getSenha());
            bwU.newLine();
            bwU.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally { // always close the file
            if (bwU != null) {
                try {
                    bwU.close();
                } catch (IOException ioe2) {
                	
                }
            }
        }
		return 0;
	}
	
	//------------------------------   Novo Produto   ----------------------------------
	
	//Grava no arquivo Product o novo produto
	
	public void NewProduct(String nome, String preco, String validade, String fornecedor){
		Product produto = new Product(nome, preco, validade, fornecedor);
	    
	    BufferedWriter bwP = null;
	    try {
	        bwP = new BufferedWriter(new FileWriter("Product.csv", true));
	        bwP.write(produto.getName() + "," + produto.getPrice() + "," + produto.getValidate() + "," + produto.getProvider());
	        bwP.newLine();
	        bwP.flush();
	    } catch (IOException ioe) {
	        ioe.printStackTrace();
	    } finally { // always close the file
	        if (bwP != null) {
	            try {
	                bwP.close();
	            } catch (IOException ioe2) {
	            	
	            }
	        }
	    }
	}
	
	//------------------------   Listar  -----------------------------------
	
	//Lista todos os produtos
	
	public void ListStock(ListView<String> lvList1){
		String bufferU;
    	BufferedReader brU = null;
        try {
        	List<String> list = new ArrayList<String>();
        	brU = new BufferedReader(new FileReader("Products.csv"));
            bufferU = brU.readLine();
            
            while(bufferU != null){							//Ele deixa pronto para a listagem
            	bufferU = bufferU.replaceAll(","," ");
            	bufferU = bufferU.toUpperCase();
            	list.add(bufferU);
            	bufferU = brU.readLine();
            }
            ObservableList<String> ol1 = FXCollections.observableList(list);
            lvList1.setItems(ol1);
        
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally { // always close the file
            if (brU != null) {
                try {
                    brU.close();
                } catch (IOException ioe2) {
                	
                }
            }
        }
	}
}
