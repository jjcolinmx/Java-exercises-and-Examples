import java.io.*;
import java.net.*;

import java.util.Date;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class MultiThreadServer extends Application{
	//Text Area para desplegar contenido
	TextArea txA = new TextArea();
	
	//Numero de Cliente
	private int ClienteNo = 0;
	
	@Override
	public void start(Stage primaryStage) {
		
		//Creando la escena y poniendo el text area en ella
		Scene scene = new Scene(new ScrollPane(txA),450,200);
		primaryStage.setTitle("Server");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		new Thread(() -> {
			try {
				//Crear el socket del server
				ServerSocket serverSocket = new ServerSocket(8000);
				Platform.runLater(() ->
				txA.appendText("Multithread Server started at "+ new Date()+ '\n'));
				
				//Listen for connection requests
				Socket socket = serverSocket.accept();
				InetAddress inetAddress = socket.getInetAddress();
				
				//incrementamos el nuemor de clientes
				ClienteNo++;
				
				//Create data input and output streams
				DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
				DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
				
				while(true) {
					//Recibe el radio del cliente
					double radius = inputFromClient.readDouble();
					
					//calcula el area
					double area = radius * radius * Math.PI;
					
					//manda el area al cliente
					outputToClient.writeDouble(area);
					
					Platform.runLater(()->{
					txA.appendText("Client's Hostname is "+ InetAddress.getLoopbackAddress() +'\n');
					txA.appendText("Radius receive by client " + radius +'\n');
					txA.appendText("Area es "+ area +'\n' );
					});
				}
				
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}		
			
		}).start();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
