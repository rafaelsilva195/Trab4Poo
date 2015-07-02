package client;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class client extends Application{
	
	public client(){
		
	}
	
	public void start(Stage primaryStageM) {
		
		Stage primaryStageCad = new Stage();
		Stage primaryStageList = new Stage();
		Stage primaryStageCadPessoas = new Stage();
		Stage primaryStageClient = new Stage();
		
		//-----------------------------------------------------------------------------------
		//--------------------------------   Menu   -----------------------------------------
		//-----------------------------------------------------------------------------------
		
		//Menu onde seria o cliente
		//
		//Ele Pode seguir para cadastrar produtos ou Listar os produtos
		
		VBox vbMenu = new VBox();
		HBox hbMenu1 = new HBox();
		HBox hbMenu2 = new HBox();
		
		Button bttM1 = new Button("Cadastrar Produtos");
		Button bttM2 = new Button("Listar");
		
		hbMenu1.getChildren().addAll(bttM1);
		hbMenu1.setSpacing(10);
		hbMenu2.getChildren().addAll(bttM2);
		hbMenu2.setSpacing(10);
		vbMenu.getChildren().addAll(hbMenu1, hbMenu2);
		
		bttM1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//Chama o panel de cadastro de pessoas
            	
            	primaryStageCad.show();
            	primaryStageM.close();
            	
            }
		});
		
		bttM2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//Chama o panel que lista os produtos
            	
            	primaryStageList.show();
            	primaryStageM.close();
            	
            }
		});
		
		StackPane rootMenu = new StackPane();
		rootMenu.getChildren().add(vbMenu);
        Scene sceneMenu = new Scene(rootMenu, 0, 0);  
        primaryStageClient.setTitle("Menu");
        primaryStageClient.setScene(sceneMenu);
        
      //-----------------------------------------------------------------------------------
      //--------------------------------   Cadastro   -------------------------------------
      //-----------------------------------------------------------------------------------
        
        
      //Menu onde cadastra os produtos
       
        VBox vbCad = new VBox();
		HBox hbCad1 = new HBox();
		HBox hbCad2 = new HBox();
		HBox hbCad3 = new HBox();
		HBox hbCad4 = new HBox();
		HBox hbCad5 = new HBox();
		HBox hbCad6 = new HBox();

		Label labelC1 = new Label("Nome:");
		TextField tfC1 = new TextField ();
		Label labelC2 = new Label("Preço:");
		TextField tfC2 = new TextField ();
		Label labelC3 = new Label("Validade:");
		TextField tfC3 = new TextField ();
		Label labelC4 = new Label("Fornecedor:");
		TextField tfC4 = new TextField ();
		Label labelC5 = new Label();
		
		Button bttC1 = new Button("Cadastrar");
		
		hbCad1.getChildren().addAll(labelC1, tfC1);
		hbCad1.setSpacing(10);
		hbCad2.getChildren().addAll(labelC2, tfC2);
		hbCad2.setSpacing(10);
		hbCad3.getChildren().addAll(labelC3, tfC3);
		hbCad3.setSpacing(10);
		hbCad4.getChildren().addAll(labelC4, tfC4);
		hbCad4.setSpacing(10);
		hbCad5.getChildren().addAll(bttC1);
		hbCad5.setSpacing(10);
		hbCad6.getChildren().addAll(labelC5);
		hbCad6.setSpacing(10);
		vbMenu.getChildren().addAll(hbCad1, hbCad2, hbCad3, hbCad4, hbCad5, hbCad6);
		
		bttC1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
            	//Ele cria um objeto de class Server e passa os parametros pedidos nos TextFields
            	
            	Server novoProduto = new Server();
            	novoProduto.NewProduct(tfC1.getText(), tfC2.getText(), tfC3.getText(), tfC4.getText());	
            	labelC5.setText("Cadastro adicionado!!");
            }
		});
		
		StackPane rootCad = new StackPane();
		rootCad.getChildren().add(vbCad);
        Scene sceneCad = new Scene(rootCad, 0, 0);  
        primaryStageCadPessoas.setTitle("Cadastro");
        primaryStageCadPessoas.setScene(sceneCad);
        
      //-----------------------------------------------------------------------------------
      //--------------------------------   Listar   ---------------------------------------
      //-----------------------------------------------------------------------------------
        
      //Lugar onde Listará todos os produtos
		
        VBox vbList1 = new VBox();
		HBox hbList1 = new HBox();
		HBox hbList2 = new HBox();
		
		Button bttProc = new Button("Listar");
		ListView<String> lvList1 = new ListView<> ();
		
		hbList1.getChildren().addAll(lvList1);
		hbList1.setSpacing(10);
		hbList2.getChildren().addAll(bttProc);
		hbList2.setSpacing(10);
		vbList1.getChildren().addAll(hbList1, hbList2);
		vbList1.setSpacing(10);
		
		bttProc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//Cria um objeto da Class Server e chama o método que lista os produtos
            	
            	Server listaServer = new Server();
            	listaServer.ListStock(lvList1);
            }
        }); 
		

		StackPane rootList = new StackPane();
		rootList.getChildren().add(hbList1);
        Scene sceneList = new Scene(rootList, 0, 0);  
        primaryStageList.setTitle("Lista");
        primaryStageList.setScene(sceneList);
		
		
		Stage primaryStageL = new Stage();
		Stage Main = new Stage();
		
		//-----------------------------------------------------------------------------------
		//--------------------------------   Principal   ------------------------------------
		//-----------------------------------------------------------------------------------
		
		//Menu que decidirá quem será o cliente ou o servidor
		
		VBox vbMain = new VBox();
		HBox hbMain1 = new HBox();
			
		Button bttClient = new Button("Cliente");
		Button bttServer = new Button("Servidor");
			
		hbMain1.getChildren().addAll(bttClient, bttClient);
		hbMain1.setSpacing(10);
		vbMain.getChildren().addAll(hbMain1);
				
		bttClient.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//Chama o panel do cliente
            	
            	primaryStageM.show();
            	Main.close();
            	
            }
		});
				
		bttServer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//Chama o panel do servidor
            	
            	primaryStageM.show();
            	Main.close();
            }
		});
				
		StackPane rootMain = new StackPane();
		rootMain.getChildren().add(vbMain);
        Scene sceneMain = new Scene(rootMain, 0, 0);  
        Main.setTitle("Main");
        Main.setScene(sceneMain);
        Main.show();
		
		//-----------------------------------------------------------------------------------
		//--------------------------------   Menu  do servidor   ----------------------------
		//-----------------------------------------------------------------------------------
			
        
        //Menu em que seria o servidor
        
        
		VBox vbMenuS = new VBox();
		HBox hbMenuS1 = new HBox();
		HBox hbMenuS2 = new HBox();
		HBox hbMenuS3 = new HBox();
			
		Button bttCM1 = new Button("Cadastrar Pessoas");
		Button bttCM2 = new Button("Login");
		Button bttCM3 = new Button("Voltar");
			
		hbMenuS1.getChildren().addAll(bttCM1);
		hbMenuS1.setSpacing(10);
		hbMenuS2.getChildren().addAll(bttCM2);
		hbMenuS2.setSpacing(10);
		hbMenuS2.getChildren().addAll(bttCM3);
		hbMenuS2.setSpacing(10);
		vbMenuS.getChildren().addAll(hbMenuS1, hbMenuS2, hbMenuS3);
				
		bttCM1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//Chama o panel do Cadastro
            	primaryStageCad.show();
            	primaryStageM.close();
            	
            }
		});
				
		bttCM2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//Chama o panel de Login
            	
            	primaryStageL.show();
            	primaryStageM.close();
            	
            }
		});
		bttCM3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//Volta no panel Main
            	
            	Main.show();
            	primaryStageM.close();
            }
		});
				
		StackPane rootMenuS = new StackPane();
		rootMenu.getChildren().add(vbMenu);
        Scene sceneMenuS = new Scene(rootMenuS, 0, 0);  
        primaryStageM.setTitle("Menu");
        primaryStageM.setScene(sceneMenuS);
		
		//--------------------------------------------------------------------------
		//---------------------------------   Login   ------------------------------
		//--------------------------------------------------------------------------
	
        //Esse parte do código faz o login do sistema
        
		VBox vbLogin1 = new VBox();
		HBox hbLogin1 = new HBox();
		HBox hbLogin2 = new HBox();
		HBox hbLogin3 = new HBox();
		HBox hbLogin4 = new HBox();
		HBox hbLogin5 = new HBox();

		Label labelL1 = new Label("ID:");
		TextField tfL1 = new TextField ();
		Label labelL2 = new Label("Senha:");
		TextField tfL2 = new TextField ();
		Label labelL3 = new Label();
		
		Button bttL1 = new Button("Entrar");
		Button bttL2 = new Button("Voltar");
		
		hbLogin1.getChildren().addAll(labelL1, tfL1);
		hbLogin1.setSpacing(10);
		hbLogin2.getChildren().addAll(labelL2, tfL2);
		hbLogin2.setSpacing(10);
		hbLogin3.getChildren().addAll(bttL1);
		hbLogin3.setSpacing(10);
		hbLogin4.getChildren().addAll(bttL1);
		hbLogin4.setSpacing(10);
		hbLogin5.getChildren().addAll(labelL3);
		hbLogin5.setSpacing(10);

		vbLogin1.getChildren().addAll(hbLogin1, hbLogin2, hbLogin3, hbLogin4, hbLogin5);
		
		bttL1.setOnAction(new EventHandler<ActionEvent>() {
			
			
            @Override
            public void handle(ActionEvent event) {
            	//Botão em que faz o login
            	
            	Server servidor = new Server();
            	int login = servidor.Login(tfL1.getText(), tfL2.getText());
            	if(login == 1){
            		labelL3.setText("ID não encontrado!!");
            	}
            	else if(login == 2){
            		labelL3.setText("Senha incorreta!!");
            	}
				else if(login == 3){
					labelL3.setText("");
				}   	
            }
		});
		bttL2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//Botão em q volta no menu
            	
            	primaryStageM.show();
            	primaryStageL.close();
            }
		});
		
		StackPane rootLogin = new StackPane();
		rootLogin.getChildren().add(vbLogin1);
        Scene sceneLogin = new Scene(rootLogin, 0, 0);  
        primaryStageL.setTitle("Login");
        primaryStageL.setScene(sceneLogin);
        
        //--------------------------------------------------------------------------
        //-----------------------   Cadastro Pessoas  ------------------------------
   		//--------------------------------------------------------------------------
      	
        //Parte do código em que cadastra as pessoas
        
        VBox vbCadP = new VBox();
		HBox hbCadP1 = new HBox();
		HBox hbCadP2 = new HBox();
		HBox hbCadP3 = new HBox();
		HBox hbCadP4 = new HBox();
		HBox hbCadP5 = new HBox();
		HBox hbCadP6 = new HBox();
		HBox hbCadP7 = new HBox();
		HBox hbCadP8 = new HBox();

		Label labelCP1 = new Label("Nome:");
		TextField tfCP1 = new TextField ();
		Label labelCP2 = new Label("Endereço:");
		TextField tfCP2 = new TextField ();
		Label labelCP3 = new Label("Telefone:");
		TextField tfCP3 = new TextField ();
		Label labelCP4 = new Label("E-mail:");
		TextField tfCP4 = new TextField ();
		Label labelCP5 = new Label("ID:");
		TextField tfCP5 = new TextField ();
		Label labelCP6 = new Label("Senha:");
		TextField tfCP6 = new TextField ();
		Label labelCP7 = new Label();
		
		Button bttCP1 = new Button("Cadastrar");
		Button bttCP2 = new Button("Voltar");
		
		hbCadP1.getChildren().addAll(labelCP1, tfCP1);
		hbCadP1.setSpacing(10);
		hbCadP2.getChildren().addAll(labelCP2, tfCP2);
		hbCadP2.setSpacing(10);
		hbCadP3.getChildren().addAll(labelCP3, tfCP3);
		hbCadP3.setSpacing(10);
		hbCadP4.getChildren().addAll(labelCP4, tfCP4);
		hbCadP4.setSpacing(10);
		hbCadP5.getChildren().addAll(labelCP5, tfCP5);
		hbCadP5.setSpacing(10);
		hbCadP6.getChildren().addAll(labelCP6, tfCP6);
		hbCadP6.setSpacing(10);
		hbCadP7.getChildren().addAll(labelCP7);
		hbCadP7.setSpacing(10);
		hbCadP7.getChildren().addAll(bttCP2);
		hbCadP7.setSpacing(10);
		vbCadP.getChildren().addAll(hbCadP1, hbCadP2, hbCadP3, hbCadP4, hbCadP5, hbCadP6, hbCadP7, hbCadP8);
		
		bttCP1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Server cadastroServer = new Server();
            	cadastroServer.CadNewUser(tfCP1.getText(), tfCP2.getText(), tfCP3.getText(), tfCP4.getText(), 
            						tfCP5.getText(), tfCP6.getText());	
            	labelCP5.setText("Cadastro adicionado!!");
            }
		});
		
		bttCP2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	primaryStageM.show();
            	primaryStageCad.close();
            }
		});
		
		StackPane rootCad2 = new StackPane();
		rootCad2.getChildren().add(vbCad);
        Scene sceneCad2 = new Scene(rootCad2, 0, 0);  
        primaryStageCad.setTitle("Menu");
        primaryStageCad.setScene(sceneCad2);
	}	
	
	public static void main(String[] args) throws IOException {
		launch(args);
	}
}
