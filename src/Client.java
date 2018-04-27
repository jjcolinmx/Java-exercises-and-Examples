import java.io.*;
import java.net.*;

import javafx.application.Application;
//import javafx.application.Platform;
import javafx.scene.Scene;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Client extends Application {
	
	///IO Streams
	DataOutputStream toServer = null;
	DataInputStream fromServer = null;
	
	@Override//Override el start metodo en la clase Application
	public void start(Stage primaryStage) {
		
		//Creacion del panel
		BorderPane paneForTextField = new BorderPane();
		paneForTextField.setPadding(new Insets(5,5,5,5));
		paneForTextField.setStyle("-fx-boder-color: green");
		paneForTextField.setLeft(new Label("Enter radius:"));
		
		TextField TF = new TextField();
		TF.setAlignment(Pos.BOTTOM_RIGHT);
		paneForTextField.setCenter(TF);
		
		BorderPane mainPane = new BorderPane();
		//Area de texto para desplegar contenido
		TextArea TA = new TextArea();
		mainPane.setCenter(new ScrollPane(TA));
		mainPane.setTop(paneForTextField);
		
		//crea escena y la pone en el stage
		Scene scene = new Scene(mainPane,450,200);
		primaryStage.setTitle("Cliente");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		TF.setOnAction(e ->{    //Handles Action
			try {
				//Get the radius from the text field
				double radius = Double.parseDouble(TF.getText().trim());
				
				//Mandamos el radio al servidor
				toServer.writeDouble(radius);
				toServer.flush();
				
				//Obtenemos el area del Servidor
				double area=fromServer.readDouble();
				TA.appendText("El radio es "+ radius +'\n');
				TA.appendText("El area recibida del servidor es " + area + '\n');
			}
			catch(IOException ex) {
				System.err.println(ex);
			}
		});
		
		try {
			//Creamos un socket para conectarnos con el servidor
			Socket socket = new Socket("localhost",8000);
			
			//Creamos el input stream para recibir datos desde el servidor
			fromServer = new DataInputStream(socket.getInputStream());
			toServer = new DataOutputStream(socket.getOutputStream());
		}
		catch (IOException ex){
			TA.appendText(ex.toString() + '\n');
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
