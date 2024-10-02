import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application{
    // Override the start method in the Application class
    @Override
    public void start(Stage primaryStage) {
        // Create grid pane
        GridPane grid = new GridPane();

        // Create a scene and place it in the stage
        Scene scene = new Scene(grid);
        // Set the stage title
        primaryStage.setTitle("Gluten Free and Vegetarian"); 
        // Place the scene in the stage
        primaryStage.setScene(scene);
        // Display the stage
        primaryStage.show();

    }

    /**
    * The main method is only needed for the IDE with limited JavaFX support. Not needed running from the command line.
    */
    public static void main(String[] args) {
        Application.launch(args);
  }
}
