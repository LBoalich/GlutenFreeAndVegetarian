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

public class Friday {
    private HBox hboxFriday;
    private CheckBox cbFriday;
    private ArrayList<String> allHours;
    private ObservableList<String> fridayOpenHoursList;
    private ObservableList<String> fridayCloseHoursList;
    private ComboBox<String> cboFridayOpen;
    private ComboBox<String> cboFridayClose;
    private String fridayOpen;
    private String fridayClose;

    public Friday() {
        friday();
    }

    public Pane getFridayPane() {
        return this.hboxFriday;
    }

    public boolean getFridaySelected() {
        return this.cbFriday.isSelected();
    }

    public String getFridayOpen() {
        return this.fridayOpen;
    }

    public String getFridayClose() {
        return this.fridayClose;
    }

    private void friday() {
        // Create all hours array list
        allHours = new ArrayList<>();
        // Add all hours
        Collections.addAll(allHours, HoursGui.HOURS_ARRAY);
        // Create open time observable list
        fridayOpenHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        // Create clost time observable list
        fridayCloseHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        
        // Create hbox for Friday
        hboxFriday = new HBox(20);

        // Create Friday checkbox
        cbFriday = new CheckBox("Friday");
        cbFriday.setMinWidth(100);
        // Add handler
        cbFriday.setOnAction(e -> cbFridayHandler());

        // Create Friday open and close combo boxes 
        cboFridayOpen = new ComboBox<>(fridayOpenHoursList);
        cboFridayClose = new ComboBox<>(fridayCloseHoursList);
        // Add event handlers
        cboFridayOpen.setOnAction(e -> cboFridayOpenHandler(cboFridayOpen.getValue()));
        cboFridayClose.setOnAction(e -> cboFridayCloseHandler());

        // Create labels for combos
        Label lbFridayOpen = new Label("Open From", cboFridayOpen);
        Label lbFridayClose = new Label("Open To", cboFridayClose);
        // Place combos to right of label
        lbFridayOpen.setContentDisplay(ContentDisplay.RIGHT);
        lbFridayClose.setContentDisplay(ContentDisplay.RIGHT);

        // Add labels to hbox
        hboxFriday.getChildren().addAll(cbFriday, lbFridayOpen, lbFridayClose);
        // Set alignment
        hboxFriday.setAlignment(Pos.CENTER);
    }

    private void cboFridayOpenHandler(String open) {
        // Set selected value
        this.fridayOpen = open;
        // Find index of selected time
        int openIndex = allHours.indexOf(open);
        if (openIndex >= 0) {
            // Create new list for close
            ArrayList<String> newCloseList = new ArrayList<>();
            newCloseList.addAll(allHours.subList(openIndex, allHours.size()));
            // Update close observable list to only keep new times
            fridayCloseHoursList.clear();
            fridayCloseHoursList.addAll(newCloseList);
        }
        else {
            // Set close hours to all hours
            fridayCloseHoursList.clear();
            fridayCloseHoursList.addAll(allHours);
        }
    }

    private void cboFridayCloseHandler() {
        this.fridayClose = cboFridayClose.getValue();
    }

    private void cbFridayHandler() {
        if (cbFriday.isSelected()) {
            this.fridayOpen = cboFridayOpen.getValue();
            this.fridayClose = cboFridayClose.getValue();
        }
        else {
            this.clearFriday();
        }
    }

    public void clearFriday() {
        this.cbFriday.selectedProperty().setValue(false);
        this.cboFridayOpen.getSelectionModel().clearSelection();
        this.cboFridayClose.getSelectionModel().clearSelection();
        this.fridayOpen = this.cboFridayOpen.getValue();
        this.fridayClose = this.cboFridayClose.getValue();
    }
}
