/* HoursNoMidDayClose extends Hours */
public class HoursNoMidDayClose extends Hours {
    /* Constructors */
    HoursNoMidDayClose() {
        super();
    }

    HoursNoMidDayClose(String sundayOpen, String sundayClose, String mondayOpen, String mondayClose, String tuesdayOpen, String tuesdayClose, String wednesdayOpen, String wednesdayClose, String thursdayOpen, String thursdayClose, String fridayOpen, String fridayClose, String saturdayOpen, String saturdayClose) {
        super(sundayOpen, sundayClose, mondayOpen, mondayClose, tuesdayOpen, tuesdayClose, wednesdayOpen, wednesdayClose, thursdayOpen, thursdayClose, fridayOpen, fridayClose, saturdayOpen, saturdayClose);
    };

    // String representation of the hours
    @Override
    public String toString() {
        // Create string builder to hold hours
        StringBuilder hours = new StringBuilder("\nHours\n\n");
        
        // Add Sunday hours
        if (super.getSunday() == true) {
            hours.append("Sunday: " + super.getSundayOpen() + " to " + super.getSundayClose() + "\n");
        }
        else {
            hours.append("Sunday: Closed\n");
        }

        // Add Monday hours
        if (super.getMonday() == true) {
            hours.append("Monday: " + super.getMondayOpen() + " to " + super.getMondayClose() + "\n");
        }
        else {
            hours.append("Monday: Closed\n");
        }

        // Add Tuesday hours
        if (super.getTuesday() == true) {
            hours.append("Tuesday: " + super.getTuesdayOpen() + " to " + super.getTuesdayClose() + "\n");
        }
        else {
            hours.append("Tuesday: Closed\n");
        }

        // Add Wednesday hours
        if (super.getWednesday() == true) {
            hours.append("Wednesday: " + super.getWednesdayOpen() + " to " + super.getWednesdayClose() + "\n");
        }
        else {
            hours.append("Wednesday: Closed\n");
        }

        // Add Thursday hours
        if (super.getThursday() == true) {
            hours.append("Thursday: " + super.getThursdayOpen() + " to " + super.getThursdayClose() + "\n");
        }
        else {
            hours.append("Thursday: Closed\n");
        }

        // Add Friday hours
        if (super.getFriday() == true) {
            hours.append("Friday: " + super.getFridayOpen() + " to " + super.getFridayClose() + "\n");
        }
        else {
            hours.append("Friday: Closed\n");
        }

        // Add Saturday hours
        if (super.getSaturday() == true) {
            hours.append("Saturday: " + super.getSaturdayOpen() + " to " + super.getSaturdayClose() + "\n");
        }
        else {
            hours.append("Saturday: Closed\n");
        }
        // Return the hours as a string
        return hours.toString();
    }
}
