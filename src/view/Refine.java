package view;

import model.NameComparator;
import model.Restaurant;
import model.RestaurantsData;
import java.util.ArrayList;
import java.util.TreeSet;
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
    /* Create arrays to hold refinement category matches */
    private ArrayList<Restaurant> categoryMatches = new ArrayList<>();
    private ArrayList<Restaurant> neighborhoodMatches = new ArrayList<>();
    private ArrayList<Restaurant> priceMatches = new ArrayList<>();
    private ArrayList<Restaurant> hourMatches = new ArrayList<>();
    private ArrayList<Restaurant> specialsMatches = new ArrayList<>();
    // Create array to hold matches
    private TreeSet<Restaurant> resultsTree = new TreeSet<>(new NameComparator());
 
    public Refine () {
        refine();
    }

    public BorderPane getRefinePane() {
        return this.paneRefine;
    }  

    public VBox getRefineChoicesPane() {
        return this.paneRefineChoices;
    }

    private void setResultsTree() {
        // Clear previous results
        categoryMatches.clear();
        neighborhoodMatches.clear();
        priceMatches.clear();
        hourMatches.clear();
        specialsMatches.clear();
        resultsTree.clear();
        // Create array to hold the refinement category match arrays that the user filtered on
        ArrayList<ArrayList<Restaurant>> checkForMatches = new ArrayList<>();
        /* For the filters the user selected, get mathces and add to check for matches array. */
        // Get category matches
        if (App.filter.isCategorySelected()) {
            categoryMatches.addAll(App.category.getCategoryMatches());
            if (!categoryMatches.isEmpty()) {
                checkForMatches.add(categoryMatches);
            }
        }
        // Get neighborhood matches
        if (App.filter.isNeighborhoodSelected()) {
            neighborhoodMatches.addAll(App.neighborhood.getNeighborhoodMatches());
            if (!neighborhoodMatches.isEmpty()) {
                checkForMatches.add(neighborhoodMatches);
            }
        }
        // Get price matches
        if (App.filter.isPriceSelected()) {
            priceMatches.addAll(App.price.getPriceMatches());
            if (!priceMatches.isEmpty()) {
                checkForMatches.add(priceMatches);
            }
        }
        // Get hour matches
        if (App.filter.isHoursSelected()) {
            hourMatches.addAll(App.hours.getHoursMatches());
            if (!hourMatches.isEmpty()) {
                checkForMatches.add(hourMatches);
            }
        }
        // Get specials matches
        if (App.filter.isSpecialsSelected()) {
            specialsMatches.addAll(App.specials.getSpecialsMatches());
            if (!specialsMatches.isEmpty()) {
                checkForMatches.add(specialsMatches);
            }
        }
        // If any results contain null then that category didn't have mathces so there are no results.  Add null to results array.
        if (categoryMatches.contains(null) || neighborhoodMatches.contains(null) || priceMatches.contains(null) || hourMatches.contains(null) || specialsMatches.contains(null)) {
            resultsTree.add(null);
            // No need to check for futher matches
            return;
        }
        // If check for matches is empty then no selections were made.  Return all restaurants
        if (checkForMatches.isEmpty()) {
            resultsTree.addAll(RestaurantsData.RESTAURANTS.getRestaurants());
            return;
        }
        // Create temp array
        ArrayList<Restaurant> temp = new ArrayList<>();
        // Set temp array to first array in check for matches
        temp = checkForMatches.get(0);
        // If only one filter option seleted, add matches to results and return
        if (checkForMatches.size() == 1) {
            for (Restaurant restaurant : temp) {
                resultsTree.add(restaurant);
            }
            return;
        }
        else {
            // Loop through match arrays and retain only common restaurants
            for (int i = 1; i < checkForMatches.size(); i++) {
                temp.retainAll(checkForMatches.get(i));
            }
        }
        // If temp empty add null to results
        if (temp.isEmpty()) {
            resultsTree.add(null);
        }
        else {
            for (Restaurant restaurant : temp) {
                resultsTree.add(restaurant);
            }
        }
    } 

    private void refine() {
        // Create borderpane
        paneRefine = new BorderPane();

        // Create vbox for refinement options
        paneRefineChoices = new VBox(25);
        // Center align
        paneRefineChoices.setAlignment(Pos.CENTER);

        // Create refine label
        Label lbRefine = new Label("Refine");
        // Set padding
        lbRefine.setPadding(new Insets(10));

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
        // Set min sizde
        paneRefine.setMinWidth(800);

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
    
    private void resultsHandler() {
        // Set results
        setResultsTree();
        // Add current pane to back button stack
        App.btBack.addPane((Pane) App.mainPane.getCenter());
        // Update main pane center pane
        App.mainPane.setCenter(new Results(this.resultsTree).getResultsPane());
    } 

    public void clearRefine() {
        this.categoryMatches.clear();
        this.neighborhoodMatches.clear();
        this.priceMatches.clear();
        this.hourMatches.clear();
        this.specialsMatches.clear();
        this.resultsTree.clear();
        this.paneRefineChoices.getChildren().clear();
        visibility();
    }
}
