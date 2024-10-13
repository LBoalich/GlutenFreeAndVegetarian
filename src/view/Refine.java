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
        // If category selected
        if (App.filter.isCategorySelected()) {
            // Get category matched and add to new list
            categoryMatches.addAll(App.category.getCategoryMatches());
            // If matches not empty
            if (!categoryMatches.isEmpty()) {
                // Add match list to check for matches
                checkForMatches.add(categoryMatches);
            }
        }
        // Get neighborhood matches
        // If neighborhood selected
        if (App.filter.isNeighborhoodSelected()) {
            // Get matches and add to neighborhood match list
            neighborhoodMatches.addAll(App.neighborhood.getNeighborhoodMatches());
            // If list not empty
            if (!neighborhoodMatches.isEmpty()) {
                // Add list to check for matches
                checkForMatches.add(neighborhoodMatches);
            }
        }
        // Get price matches
        // If price selected
        if (App.filter.isPriceSelected()) {
            // Get price matches and add to price match list
            priceMatches.addAll(App.price.getPriceMatches());
            // If list not empty
            if (!priceMatches.isEmpty()) {
                // Add to check for matches list
                checkForMatches.add(priceMatches);
            }
        }
        // Get hour matches
        // If hours selected
        if (App.filter.isHoursSelected()) {
            // Get hour matches and add to hour list
            hourMatches.addAll(App.hours.getHoursMatches());
            // If hour list not empty
            if (!hourMatches.isEmpty()) {
                // Add to check for matches list
                checkForMatches.add(hourMatches);
            }
        }
        // Get specials matches
        // If specials selected
        if (App.filter.isSpecialsSelected()) {
            // Get specials matches and add to specials list
            specialsMatches.addAll(App.specials.getSpecialsMatches());
            // If list not empty
            if (!specialsMatches.isEmpty()) {
                // Add to check for matches
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
        // More than one catgory selected
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
        // Temp not empty so matches exist
        else {
            // Add all matches to results
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
        // If pane already visible
        if (this.paneRefineChoices.getChildren().contains(pane)) {
            // Remove
            this.paneRefineChoices.getChildren().remove(pane);
        }
        // Pane not already showing
        else {
            // Add
            this.paneRefineChoices.getChildren().add(pane);
        }
        // Set visibilty for entire refine pane
        visibility();
    }

    public void visibility() {
        // If no categorys selected
        if (paneRefineChoices.getChildren().isEmpty()) {
            // Do not show refine pane
            paneRefine.setVisible(false);
        }
        // Categories are selected
        else {
            // Show refine pane
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
        // Clear all data match lists
        this.categoryMatches.clear();
        this.neighborhoodMatches.clear();
        this.priceMatches.clear();
        this.hourMatches.clear();
        this.specialsMatches.clear();
        this.resultsTree.clear();
        // Remove all panes from refine choices
        this.paneRefineChoices.getChildren().clear();
        // Makes refine pane not visible
        visibility();
    }
}
