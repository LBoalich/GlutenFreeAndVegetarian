package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HoursGui {
    private VBox paneHours;

    public HoursGui() {
        hours();
    }

    public VBox getHoursPane() {
        return this.paneHours;
    }

    private void hours() {
        // Create hours vbox
        paneHours = new VBox(10);
        
        // Create hours label
        Label lbHours = new Label("Open Hours");
        
        // Create hbox for combos
        HBox hboxRange = new HBox(20);

        /* Create hours observable list */
        // Create hours array 
        String[] hoursArray = {"12:00 AM", "12:30 AM", "1:00 AM", "1:30 AM", "2:00 AM", "2:30 AM", "3:00 AM", "3:30 AM", "4:00 AM", "4:30 AM", "5:00 AM", "5:30 AM", "6:00 AM", "6:30 AM", "7:00 AM", "7:30 AM", "8:00 AM", "8:30 AM", "9:00 AM", "9:30 AM", "10:00 AM", "10:30 AM", "11:00 AM", "11:30 AM", "12:00 PM", "12:30 PM", "1:00 PM", "1:30 PM", "2:00 PM", "2:30 PM", "3:00 PM", "3:30 PM", "4:00 PM", "4:30 PM", "5:00 PM", "5:30 PM", "6:00 PM", "6:30 PM", "7:00 PM", "7:30 PM", "8:00 PM", "8:30 PM", "9:00 PM", "9:30 PM", "10:00 PM", "10:30 PM", "11:00 PM", "11:30 PM"};
        // Create open time observable list
        ObservableList<String> openHoursList = FXCollections.observableArrayList(hoursArray);
        // Create clost time observable list
        ObservableList<String> closeHoursList = FXCollections.observableArrayList(hoursArray);
       
        // Create open and close combo boxes 
        ComboBox<String> cboOpen = new ComboBox<>(openHoursList);
        ComboBox<String> cboClose = new ComboBox<>(closeHoursList);

        // Create labels for combos
        Label lbOpen = new Label("Open From", cboOpen);
        Label lbClose = new Label("Open To", cboClose);
        // Place combos to right of label
        lbOpen.setContentDisplay(ContentDisplay.RIGHT);
        lbClose.setContentDisplay(ContentDisplay.RIGHT);

        // Add labels to hbox
        hboxRange.getChildren().addAll(lbOpen, lbClose);
        // Set alignment
        hboxRange.setAlignment(Pos.CENTER);

        // Add hours label and hbox to vbox
        paneHours.getChildren().addAll(lbHours, hboxRange);
        // Set alignment
        paneHours.setAlignment(Pos.CENTER);
    }
}
