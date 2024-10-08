package view;

import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SpecialsGui {
    private VBox paneSpecials;

    public SpecialsGui() {
        specials();
    }

    public VBox getSpecialsPane() {
        return this.paneSpecials;
    }

    private void specials() {
        // Create specials vbox
        paneSpecials = new VBox(10);

        // Create specials label
        Label lbSpecials = new Label("Specials");

        // Create specials checkbox
        CheckBox cbSpecials = new CheckBox("Restaurant offers Specials or Happy Hours: ");
        // Move checkbox to the right
        cbSpecials.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        // Add label and checkbox to vbox
        paneSpecials.getChildren().addAll(lbSpecials, cbSpecials);
        // Center align
        paneSpecials.setAlignment(Pos.CENTER);
    }
}
