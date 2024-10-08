package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    public static BorderPane mainPane = new BorderPane();

    // Override the start method in the Application class
    @Override
    public void start(Stage primaryStage) {
        // Add padding to main pain
        mainPane.setPadding(new Insets(20));
      
        // Create the search pane
        HBox paneSearch = new Search().getSearchPane();
        // Add search to border pane
        mainPane.setTop(paneSearch);

        // Create vbox to hold center items for border pane
        VBox vboxCenter = new VBox(30);

        // Create refine
        Refine refine = new Refine();
        // Create refine pane
        Pane paneRefine = refine.getRefinePane();

        // Create filter pane
        Pane paneFilter = new Filter(refine).getFilterPane();
        
        // Add filter and refine to vbox
        vboxCenter.getChildren().addAll(paneFilter, paneRefine);

        // Add vbox to border pane
        mainPane.setCenter(vboxCenter);

        // Create a scene and place it in the stage
        Scene scene = new Scene(mainPane);
        // Set the stage title
        primaryStage.setTitle("Gluten Free and Vegetarian"); 
        // Place the scene in the stage
        primaryStage.setScene(scene);
        // Set primary stage min size
        primaryStage.setMinHeight(750);
        primaryStage.setMinWidth(600);
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
