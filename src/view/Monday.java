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

public class Monday {
    private HBox hboxMonday;
    private CheckBox cbMonday;
    private ArrayList<String> allHours;
    private ObservableList<String> mondayOpenHoursList;
    private ObservableList<String> mondayCloseHoursList;
    private ComboBox<String> cboMondayOpen;
    private ComboBox<String> cboMondayClose;
    private String mondayOpen;
    private String mondayClose;

    public Monday() {
        monday();
    }

    public Pane getMondayPane() {
        return this.hboxMonday;
    }

    public boolean getMondaySelected() {
        return this.cbMonday.isSelected();
    }

    public String getMondayOpen() {
        return this.mondayOpen;
    }

    public String getMondayClose() {
        return this.mondayClose;
    }

    private void monday() {
        // Create all hours array list
        allHours = new ArrayList<>();
        // Add all hours
        Collections.addAll(allHours, HoursGui.HOURS_ARRAY);
        // Create open time observable list
        mondayOpenHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        // Create clost time observable list
        mondayCloseHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        
        // Create hbox for Monday
        hboxMonday = new HBox(20);

        // Create Monday checkbox
        cbMonday = new CheckBox("Monday");
        cbMonday.setMinWidth(100);
        // Add handler
        cbMonday.setOnAction(e -> cbMondayHandler());

        // Create Monday open and close combo boxes 
        cboMondayOpen = new ComboBox<>(mondayOpenHoursList);
        cboMondayClose = new ComboBox<>(mondayCloseHoursList);
        // Add event handlers
        cboMondayOpen.setOnAction(e -> cboMondayOpenHandler(cboMondayOpen.getValue()));
        cboMondayClose.setOnAction(e -> cboMondayCloseHandler());

        // Create labels for combos
        Label lbMondayOpen = new Label("Open From", cboMondayOpen);
        Label lbMondayClose = new Label("Open To", cboMondayClose);
        // Place combos to right of label
        lbMondayOpen.setContentDisplay(ContentDisplay.RIGHT);
        lbMondayClose.setContentDisplay(ContentDisplay.RIGHT);

        // Add labels to hbox
        hboxMonday.getChildren().addAll(cbMonday, lbMondayOpen, lbMondayClose);
        // Set alignment
        hboxMonday.setAlignment(Pos.CENTER);
    }

    private void cboMondayOpenHandler(String open) {
        // Set selected value
        this.mondayOpen = open;
        // Find index of selected time
        int openIndex = allHours.indexOf(open);
        if (openIndex >= 0) {
            // Create new list for close
            ArrayList<String> newCloseList = new ArrayList<>();
            newCloseList.addAll(allHours.subList(openIndex, allHours.size()));
            // Update close observable list to only keep new times
            mondayCloseHoursList.clear();
            mondayCloseHoursList.addAll(newCloseList);
        }
        else {
            // Set close hours to all hours
            mondayCloseHoursList.clear();
            mondayCloseHoursList.addAll(allHours);
        }
    }

    private void cboMondayCloseHandler() {
        this.mondayClose = cboMondayClose.getValue();
    }

    private void cbMondayHandler() {
        if (cbMonday.isSelected()) {
            this.mondayOpen = cboMondayOpen.getValue();
            this.mondayClose = cboMondayClose.getValue();
        }
        else {
            this.clearMonday();
        }
    }

    public void clearMonday() {
        this.cbMonday.selectedProperty().setValue(false);
        this.cboMondayOpen.getSelectionModel().clearSelection();
        this.cboMondayClose.getSelectionModel().clearSelection();
        this.mondayOpen = this.cboMondayOpen.getValue();
        this.mondayClose = this.cboMondayClose.getValue();
    }
}
