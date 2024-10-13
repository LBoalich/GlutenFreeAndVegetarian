package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {
    public static BorderPane mainPane = new BorderPane();
    public static Search search = new Search();
    public static Filter filter = new Filter();
    public static Refine refine = new Refine();
    public static Back btBack = new Back();
    public static Category category = new Category();
    public static Neighborhood neighborhood = new Neighborhood();
    public static Price price = new Price();
    public static HoursGui hours = new HoursGui();
    public static SpecialsGui specials = new SpecialsGui();

    // Override the start method in the Application class
    @Override
    public void start(Stage primaryStage) {
        // Add padding to main pain
        mainPane.setPadding(new Insets(20));
      
        // Add search to border pane
        mainPane.setTop(search.getSearchPane());

        // Create hbox to hold center items for border pane
        HBox hboxCenter = new HBox(30);
        
        // Add filter and refine to hbox
        hboxCenter.getChildren().addAll(filter.getFilterPane(), refine.getRefinePane());

        // Add hbox to border pane
        mainPane.setCenter(hboxCenter);

        // Add back button to border pane
        mainPane.setBottom(btBack.getBackButton());

        // Create a scene and place it in the stage
        Scene scene = new Scene(mainPane);
        // Set the stage title
        primaryStage.setTitle("Gluten Free and Vegetarian"); 
        // Place the scene in the stage
        primaryStage.setScene(scene);
        // Set primary stage min size
        primaryStage.setMinHeight(775);
        primaryStage.setMinWidth(900);
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
