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
import java.util.ArrayList;
import java.util.Collections;

public class Tuesday {
    private HBox hboxTuesday;
    private CheckBox cbTuesday;
    private ArrayList<String> allHours;
    private ObservableList<String> tuesdayOpenHoursList;
    private ObservableList<String> tuesdayCloseHoursList;
    private ComboBox<String> cboTuesdayOpen;
    private ComboBox<String> cboTuesdayClose;
    private String tuesdayOpen;
    private String tuesdayClose;

    Tuesday() {
        tuesday();
    }

    public Pane getTuesdayPane() {
        return this.hboxTuesday;
    }

    public boolean getTuesdaySelected() {
        return this.cbTuesday.isSelected();
    }

    public String getTuesdayOpen() {
        return this.tuesdayOpen;
    }

    public String getTuesdayClose() {
        return this.tuesdayClose;
    }

    public void tuesday() {
        // Create all hours array list
        allHours = new ArrayList<>();
        // Add all hours
        Collections.addAll(allHours, HoursGui.HOURS_ARRAY);
        // Create open time observable list
        tuesdayOpenHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        // Create clost time observable list
        tuesdayCloseHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        
        // Create hbox for Tuesday
        hboxTuesday = new HBox(20);

        // Create Tuesday checkbox
        cbTuesday = new CheckBox("Tuesday");
        cbTuesday.setMinWidth(100);
        // Add handler
        cbTuesday.setOnAction(e -> cbTuesdayHandler());

        // Create Tuesday open and close combo boxes 
        cboTuesdayOpen = new ComboBox<>(tuesdayOpenHoursList);
        cboTuesdayClose = new ComboBox<>(tuesdayCloseHoursList);
        // Add event handlers
        cboTuesdayOpen.setOnAction(e -> cboTuesdayOpenHandler(cboTuesdayOpen.getValue()));
        cboTuesdayClose.setOnAction(e -> cboTuesdayCloseHandler());

        // Create labels for combos
        Label lbTuesdayOpen = new Label("Open From", cboTuesdayOpen);
        Label lbTuesdayClose = new Label("Open To", cboTuesdayClose);
        // Place combos to right of label
        lbTuesdayOpen.setContentDisplay(ContentDisplay.RIGHT);
        lbTuesdayClose.setContentDisplay(ContentDisplay.RIGHT);

        // Add labels to hbox
        hboxTuesday.getChildren().addAll(cbTuesday, lbTuesdayOpen, lbTuesdayClose);
        // Set alignment
        hboxTuesday.setAlignment(Pos.CENTER);
    }

    private void cboTuesdayOpenHandler(String open) {
        // Set selected value
        this.tuesdayOpen = open;
        // Find index of selected time
        int openIndex = allHours.indexOf(open);
        if (openIndex >= 0) {
            // Create new list for close
            ArrayList<String> newCloseList = new ArrayList<>();
            newCloseList.addAll(allHours.subList(openIndex, allHours.size()));
            // Update close observable list to only keep new times
            tuesdayCloseHoursList.clear();
            tuesdayCloseHoursList.addAll(newCloseList);
        }
        else {
            // Set close hours to all hours
            tuesdayCloseHoursList.clear();
            tuesdayCloseHoursList.addAll(allHours);
        }
    }

    private void cboTuesdayCloseHandler() {
        this.tuesdayClose = cboTuesdayClose.getValue();
    }

    private void cbTuesdayHandler() {
        if (cbTuesday.isSelected()) {
            this.tuesdayOpen = cboTuesdayOpen.getValue();
            this.tuesdayClose = cboTuesdayClose.getValue();
        }
        else {
            this.clearTuesday();
        }
    }

    public void clearTuesday() {
        this.cbTuesday.selectedProperty().setValue(false);
        this.cboTuesdayOpen.getSelectionModel().clearSelection();
        this.cboTuesdayClose.getSelectionModel().clearSelection();
        this.tuesdayOpen = this.cboTuesdayOpen.getValue();
        this.tuesdayClose = this.cboTuesdayClose.getValue();
    }
}
