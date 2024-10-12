package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.HoursNoMidDayClose;
import model.Restaurant;
import model.RestaurantsData;
import java.util.ArrayList;

// Class needs updated to track hours for each day of the week
public class HoursGui {
    public static final String[] HOURS_ARRAY = {"12:00 AM", "12:30 AM", "1:00 AM", "1:30 AM", "2:00 AM", "2:30 AM", "3:00 AM", "3:30 AM", "4:00 AM", "4:30 AM", "5:00 AM", "5:30 AM", "6:00 AM", "6:30 AM", "7:00 AM", "7:30 AM", "8:00 AM", "8:30 AM", "9:00 AM", "9:30 AM", "10:00 AM", "10:30 AM", "11:00 AM", "11:30 AM", "12:00 PM", "12:30 PM", "1:00 PM", "1:30 PM", "2:00 PM", "2:30 PM", "3:00 PM", "3:30 PM", "4:00 PM", "4:30 PM", "5:00 PM", "5:30 PM", "6:00 PM", "6:30 PM", "7:00 PM", "7:30 PM", "8:00 PM", "8:30 PM", "9:00 PM", "9:30 PM", "10:00 PM", "10:30 PM", "11:00 PM", "11:30 PM"};
    private VBox paneHours;
    private Sunday sunday;
    private Monday monday;
    private Tuesday tuesday;
    private Wednesday wednesday;
    private Thursday thursday;
    private Friday friday;
    private Saturday saturday;
    private ArrayList<Restaurant> hoursMatches = new ArrayList<>();

    public HoursGui() {
        hours();
    }

    public VBox getHoursPane() {
        return this.paneHours;
    }

    public ArrayList<Restaurant> getHoursMatches() {
        // Clear previous matches
        hoursMatches.clear();

        // If no selctions made no need to look for matches, return cleared hours matches list
        if (!sunday.getSundaySelected() && !monday.getMondaySelected() && !tuesday.getTuesdaySelected() && !wednesday.getWednesdaySelected() && !thursday.getThursdaySelected() && !friday.getFridaySelected() && !saturday.getSaturdaySelected()) {
            return this.hoursMatches;
        }

        // Create hours no mid day close object
        HoursNoMidDayClose hours = new HoursNoMidDayClose();
        /* Get matches for each day */
        // Sunday
        // If selections made
        if (sunday.getSundaySelected()) {
            // Set sunday hours
            hours.setSundayOpen(sunday.getSundayOpen());
            hours.setSundayClose(sunday.getSundayClose());
        } 
        // Set day to closed
        else {
            hours.setSunday(false);
        }
        // Monday
        // If selections made
        if (monday.getMondaySelected()) {
            // Set hours
            hours.setMondayOpen(monday.getMondayOpen());
            hours.setMondayClose(monday.getMondayClose());
        } 
        // Set day to closed
        else {
            hours.setMonday(false);
        }
        // Tuesday
        // If selections made
        if (tuesday.getTuesdaySelected()) {
            // Set hours
            hours.setTuesdayOpen(tuesday.getTuesdayOpen());
            hours.setTuesdayClose(tuesday.getTuesdayClose());
        }
        // Set day to closed 
        else {
            hours.setTuesday(false);
        }
        // Wednesday
        // If selections made
        if (wednesday.getWednesdaySelected()) {
            // Set hours
            hours.setWednesdayOpen(wednesday.getWednesdayOpen());
            hours.setWednesdayClose(wednesday.getWednesdayClose());
        }
        // Set day to closed 
        else {
            hours.setWednesday(false);
        }
        // Thursday
        // If selections made
        if (thursday.getThursdaySelected()) {
            // Set hours
            hours.setThursdayOpen(thursday.getThursdayOpen());
            hours.setThursdayClose(thursday.getThursdayClose());
        } 
        // Set day to closed
        else {
            hours.setThursday(false);
        }
        // Friday
        // If selections made
        if (friday.getFridaySelected()) {
            // Set hours
            hours.setFridayOpen(friday.getFridayOpen());
            hours.setFridayClose(friday.getFridayClose());
        }
        // Set day to closed 
        else {
            hours.setFriday(false);
        }
        // Saturday
        // If selections made
        if (saturday.getSaturdaySelected()) {
            // Set hours
            hours.setSaturdayOpen(saturday.getSaturdayOpen());
            hours.setSaturdayClose(saturday.getSaturdayClose());
        }
        // Set day to closed 
        else {
            hours.setSaturday(false);
        }

        // Get matches for selected open and close hours
        hoursMatches = RestaurantsData.restaurants.hoursMatch(hours);

        return this.hoursMatches;
    }

    private void hours() {
        // Create days
        sunday = new Sunday();
        monday = new Monday();
        tuesday = new Tuesday();
        wednesday = new Wednesday();
        thursday = new Thursday();
        friday = new Friday();
        saturday = new Saturday();

        // Create hours vbox
        paneHours = new VBox(10);
        
        // Create hours label
        Label lbHours = new Label("Open Hours");

        /* Hours Pane */
        // Add hours label and hbox to vbox
        paneHours.getChildren().addAll(lbHours, sunday.getSundayPane(), monday.getMondayPane() , tuesday.getTuesdayPane(), wednesday.getWednesdayPane(), thursday.getThursdayPane(), friday.getFridayPane(), saturday.getSaturdayPane());
        // Set alignment
        paneHours.setAlignment(Pos.CENTER);
    }
}
