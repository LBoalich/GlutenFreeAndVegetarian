package view;

import model.Restaurant;
import model.RestaurantsData;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Refine {
    private BorderPane paneRefine;
    private VBox paneRefineChoices;
    private Pane paneCategory; 
    private Pane paneNeighborhood;
    private Pane panePrice;
    private Pane paneHours;
    private Pane paneSpecials;
    
    public Refine () {
        refine();
    }

    public BorderPane getRefinePane() {
        return this.paneRefine;
    }  

    public VBox getRefineChoicesPane() {
        return this.paneRefineChoices;
    }
    
    public Pane getCategoryPane() {
        return this.paneCategory;
    }

    public Pane getNeighborhoodPane() {
        return this.paneNeighborhood;
    }

    public Pane getPricePane() {
        return this.panePrice;
    }

    public Pane getHoursPane() {
        return this.paneHours;
    }

    public Pane getSpecialsPane() {
        return this.paneSpecials;
    }

    public void refine() {
        // Create borderpane
        paneRefine = new BorderPane();

        // Create vbox for refinement options
        paneRefineChoices = new VBox(25);
        // Center align
        paneRefineChoices.setAlignment(Pos.CENTER);

        // Create refine label
        Label lbRefine = new Label("Refine");
        // Set padding
        lbRefine.setPadding(new Insets(20));

        /* Create refinement panes */
        // Create category pane
        paneCategory = new Category().getCategoryPane(); 
        // Create neighborhood pane
        paneNeighborhood = new Neighborhood().getNeighborhoodPane();
        // Create price pane
        panePrice = new Price().getPricePance();
        // Create hours pane
        paneHours = new HoursGui().getHoursPane();
        // Create specials pane
        paneSpecials = new SpecialsGui().getSpecialsPane();

        // Create refine button
        Button btRefine = new Button("Results");
        // Create button hbox
        HBox hboxButton = new HBox(btRefine);
        // Center align
        hboxButton.setAlignment(Pos.CENTER);
        // Set padding
        hboxButton.setPadding(new Insets(20));
        // Add event handler
        btRefine.setOnAction(e -> resultsHandler());

        // Add label, vbox, and button to border pane
        paneRefine.setTop(lbRefine);
        paneRefine.setCenter(paneRefineChoices);
        paneRefine.setBottom(hboxButton);
        // Center align
        BorderPane.setAlignment(lbRefine, Pos.CENTER);

        // Set visibility to false
        paneRefine.setVisible(false);
    }

    public void toggle(Pane pane) {
        if (this.paneRefineChoices.getChildren().contains(pane)) {
            this.paneRefineChoices.getChildren().remove(pane);
        }
        else {
            this.paneRefineChoices.getChildren().add(pane);
        }
        visibility();
    }

    public void visibility() {
        if (paneRefineChoices.getChildren().isEmpty()) {
            paneRefine.setVisible(false);
        }
        else {
            paneRefine.setVisible(true);
        }
    }

    public void resultsHandler() {
        // Create array to hold matches
        ArrayList<Restaurant> resultsArray = new ArrayList<>();
        // For testing adding restaurants
        resultsArray.addAll(RestaurantsData.restaurants.getRestaurants());
        // Add results to main page and remove filer and refine
        App.mainPane.setCenter(new Results(resultsArray).getResultsPane());
    }   
}
