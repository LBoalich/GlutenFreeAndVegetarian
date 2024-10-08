package view;

import model.Restaurants;
import model.RestaurantsData;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class Neighborhood {
    private VBox paneNeighborhood;

    public Neighborhood() {
        neighborhood();
    }

    public VBox getNeighborhoodPane() {
        return this.paneNeighborhood;
    }

    private void neighborhood() {
        // Get restaurants
        Restaurants restaurants = RestaurantsData.restaurants;

        // Create neighborhood vbox
        paneNeighborhood = new VBox(10);

        // Create neighborhood label
        Label lbNeighborhood = new Label("Neighborhoods");

        // Create neighborhood flowpane
        FlowPane fpNeighborhood = new FlowPane();
        
        // Add buttons to flow pane
        for (String restaurant : restaurants.getNeighborhoods()) {
            // Create button
            Button btNeighborhood = new Button(restaurant);
            // Set prefered width
            btNeighborhood.setPrefWidth(100);
            // Add button to flow pane
            fpNeighborhood.getChildren().add(btNeighborhood);
        }
        // Center align buttons
        fpNeighborhood.setAlignment(Pos.CENTER);
        // Set hgap and vgap
        fpNeighborhood.setHgap(10);
        fpNeighborhood.setVgap(5);

        // Add label and flow pane to vbox
        paneNeighborhood.getChildren().addAll(lbNeighborhood, fpNeighborhood);

        // Center align 
        paneNeighborhood.setAlignment(Pos.CENTER);
    }
}
