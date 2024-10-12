package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Thursday {
    private HBox hboxThursday;
    private CheckBox cbThursday;
    private ComboBox<String> cboThursdayOpen;
    private ComboBox<String> cboThursdayClose;
    private String thursdayOpen;
    private String thursdayClose;

    Thursday() {
        thursday();
    }

    public Pane getThursdayPane() {
        return this.hboxThursday;
    }

    public boolean getThursdaySelected() {
        return this.cbThursday.isSelected();
    }

    public String getThursdayOpen() {
        return this.thursdayOpen;
    }

    public String getThursdayClose() {
        return this.thursdayClose;
    }

    public void thursday() {
        // Create open time observable list
        ObservableList<String> thursdayOpenHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        // Create clost time observable list
        ObservableList<String> thursdayCloseHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        
        // Create hbox for Thursday
        hboxThursday = new HBox(20);

        // Create Sunday checkbox
        cbThursday = new CheckBox("Thursday");
        cbThursday.setMinWidth(100);

        // Create Thursday open and close combo boxes 
        cboThursdayOpen = new ComboBox<>(thursdayOpenHoursList);
        cboThursdayClose = new ComboBox<>(thursdayCloseHoursList);
        // Add event handlers
        cboThursdayOpen.setOnAction(e -> cboThursdayOpenHandler());
        cboThursdayClose.setOnAction(e -> cboThursdayCloseHandler());

        // Create labels for combos
        Label lbThursdayOpen = new Label("Open From", cboThursdayOpen);
        Label lbThursdayClose = new Label("Open To", cboThursdayClose);
        // Place combos to right of label
        lbThursdayOpen.setContentDisplay(ContentDisplay.RIGHT);
        lbThursdayClose.setContentDisplay(ContentDisplay.RIGHT);

        // Add labels to hbox
        hboxThursday.getChildren().addAll(cbThursday, lbThursdayOpen, lbThursdayClose);
        // Set alignment
        hboxThursday.setAlignment(Pos.CENTER);
    }

    private void cboThursdayOpenHandler() {
        this.thursdayOpen = cboThursdayOpen.getValue();
    }

    private void cboThursdayCloseHandler() {
        this.thursdayClose = cboThursdayClose.getValue();
    }
}
