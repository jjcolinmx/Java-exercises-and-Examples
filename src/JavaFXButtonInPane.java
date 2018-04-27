
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class JavaFXButtonInPane extends Application {

	@Override
	public void start(Stage primaryStage) {
	StackPane panel = new StackPane();	
	panel.getChildren().add(new Button("OK"));
	Scene escena = new Scene(panel,200,50);
	
	primaryStage.setTitle("Boton en Panel");
	primaryStage.setScene(escena);
	primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
