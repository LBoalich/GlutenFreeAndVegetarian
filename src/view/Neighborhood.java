package view;

import model.Restaurant;
import model.RestaurantsData;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import java.util.ArrayList;

public class Neighborhood {
    private VBox paneNeighborhood;
    private ArrayList<String> selectedNeighborhoods = new ArrayList<>();
    private ArrayList<Restaurant> neighborhoodMatches = new ArrayList<>();
    private ArrayList<ToggleButton> neighborhoodButtonList = new ArrayList<>();

    public Neighborhood() {
        neighborhood();
    }

    public VBox getNeighborhoodPane() {
        return this.paneNeighborhood;
    }

    public ArrayList<Restaurant> getNeighborhoodMatches() {
        return this.neighborhoodMatches;
    }

    public ArrayList<ToggleButton> getNeighborhoodButtonList() {
        return this.neighborhoodButtonList;
    }

    private void neighborhood() {
        // Create neighborhood vbox
        paneNeighborhood = new VBox(10);

        // Create neighborhood label
        Label lbNeighborhood = new Label("Neighborhoods");

        // Create neighborhood flowpane
        FlowPane fpNeighborhood = new FlowPane();
        
        // Add buttons to flow pane
        for (String neighborhood : RestaurantsData.RESTAURANTS.getNeighborhoods()) {
            // Create button
            ToggleButton btNeighborhood = new ToggleButton(neighborhood);
            // Set prefered width
            btNeighborhood.setPrefWidth(100);
            // Add button to flow pane
            fpNeighborhood.getChildren().add(btNeighborhood);
            // Add handler
            btNeighborhood.setOnAction(e -> btNeighborhoodHandler(neighborhood));
            // Add to neighborhood button list
            neighborhoodButtonList.add(btNeighborhood);
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

    // Cateogry button event handler
    private void btNeighborhoodHandler(String neighborhood) {
        if (selectedNeighborhoods.contains(neighborhood)) {
            selectedNeighborhoods.remove(neighborhood);
        }
        else {
            selectedNeighborhoods.add(neighborhood);
        }
        // Clear previous matches
        neighborhoodMatches.clear();
        // If selections not empty
        if (!selectedNeighborhoods.isEmpty()) {
            // Find new matches
            neighborhoodMatches.addAll(RestaurantsData.RESTAURANTS.neighborhoodMatch(selectedNeighborhoods));
        }
    }

    public void clearNeighborhood() {
        this.selectedNeighborhoods.clear();
        this.neighborhoodMatches.clear();
        // Deslect toggle buttons
        for (ToggleButton btNeighborhood : neighborhoodButtonList) {
            btNeighborhood.setSelected(false);
        }     
    }
}
