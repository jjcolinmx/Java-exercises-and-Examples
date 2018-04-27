
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class JavaFXMultipleStageDemo extends Application {

	@Override
	public void start(Stage primaryStage) {
		Button btOK=new Button("OK");
		Scene escena = new Scene(btOK,200,250);
		primaryStage.setTitle("MyJavaFX");
		primaryStage.setScene(escena);
		primaryStage.show();
		
		Stage escenario = new Stage();  ///Crea un segundo escenario
		escenario.setTitle("Segundo Escenario");
		escenario.setScene(new Scene(new Button("Nuevo escenario"),100,100 ));
		escenario.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
