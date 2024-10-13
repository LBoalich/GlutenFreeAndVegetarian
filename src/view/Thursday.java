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

public class Thursday {
    private HBox hboxThursday;
    private CheckBox cbThursday;
    private ArrayList<String> allHours;
    private ObservableList<String> thursdayOpenHoursList;
    private ObservableList<String> thursdayCloseHoursList;
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
        // Create all hours array list
        allHours = new ArrayList<>();
        // Add all hours
        Collections.addAll(allHours, HoursGui.HOURS_ARRAY);
        // Create open time observable list
        thursdayOpenHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        // Create clost time observable list
        thursdayCloseHoursList = FXCollections.observableArrayList(HoursGui.HOURS_ARRAY);
        
        // Create hbox for Thursday
        hboxThursday = new HBox(20);

        // Create Thursday checkbox
        cbThursday = new CheckBox("Thursday");
        cbThursday.setMinWidth(100);
        // Add handler
        cbThursday.setOnAction(e -> cbThursdayHandler());

        // Create Thursday open and close combo boxes 
        cboThursdayOpen = new ComboBox<>(thursdayOpenHoursList);
        cboThursdayClose = new ComboBox<>(thursdayCloseHoursList);
        // Add event handlers
        cboThursdayOpen.setOnAction(e -> cboThursdayOpenHandler(cboThursdayOpen.getValue()));
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

    private void cboThursdayOpenHandler(String open) {
        // Set selected value
        this.thursdayOpen = open;
        // Find index of selected time
        int openIndex = allHours.indexOf(open);
        if (openIndex >= 0) {
            // Create new list for close
            ArrayList<String> newCloseList = new ArrayList<>();
            newCloseList.addAll(allHours.subList(openIndex, allHours.size()));
            // Update close observable list to only keep new times
            thursdayCloseHoursList.clear();
            thursdayCloseHoursList.addAll(newCloseList);
        }
        else {
            // Set close hours to all hours
            thursdayCloseHoursList.clear();
            thursdayCloseHoursList.addAll(allHours);
        }
    }

    private void cboThursdayCloseHandler() {
        this.thursdayClose = cboThursdayClose.getValue();
    }

    private void cbThursdayHandler() {
        if (cbThursday.isSelected()) {
            this.thursdayOpen = cboThursdayOpen.getValue();
            this.thursdayClose = cboThursdayClose.getValue();
        }
        else {
            this.clearThursday();
        }
    }

    public void clearThursday() {
        this.cbThursday.selectedProperty().setValue(false);
        this.cboThursdayOpen.getSelectionModel().clearSelection();
        this.cboThursdayClose.getSelectionModel().clearSelection();
        this.thursdayOpen = this.cboThursdayOpen.getValue();
        this.thursdayClose = this.cboThursdayClose.getValue();
    }
}
