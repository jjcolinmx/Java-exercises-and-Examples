
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class TestJavaFX01A extends Application {

	@Override
	public void start(Stage primaryStage) {
		//Creamos una escena y ponemos un boton
		Button btOK=new Button("OK");
		Scene escena = new Scene(btOK,200,250);
		primaryStage.setTitle("MyJavaFX");
		primaryStage.setScene(escena);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
