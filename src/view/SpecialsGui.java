package view;

import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Restaurant;
import model.RestaurantsData;
import java.util.ArrayList;

public class SpecialsGui {
    private VBox paneSpecials;
    private CheckBox cbSpecials;
    private ArrayList<Restaurant> specialsMatches = new ArrayList<>();

    public SpecialsGui() {
        specials();
    }

    public VBox getSpecialsPane() {
        return this.paneSpecials;
    }

    public ArrayList<Restaurant> getSpecialsMatches() {
        return this.specialsMatches;
    }

    private void specials() {
        // Create specials vbox
        paneSpecials = new VBox(10);

        // Create specials label
        Label lbSpecials = new Label("Specials");

        // Create specials checkbox
        cbSpecials = new CheckBox("Restaurant offers Specials or Happy Hours: ");
        // Move checkbox to the right
        cbSpecials.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        // Add handler
        cbSpecials.setOnAction(e -> cbSpecialsHandler());

        // Add label and checkbox to vbox
        paneSpecials.getChildren().addAll(lbSpecials, cbSpecials);
        // Center align
        paneSpecials.setAlignment(Pos.CENTER);
    }

    private void cbSpecialsHandler() {
        // Clear previous results
        specialsMatches.clear();
        // If selected add matches
        if (cbSpecials.isSelected()) {
            specialsMatches = RestaurantsData.RESTAURANTS.specialsMatch();
        }
    }
}
