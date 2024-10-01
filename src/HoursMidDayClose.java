/* HoursMidDayClose class extends MidDayClose */
public class HoursMidDayClose extends MidDayClose {
    /* Attributes defualt set to null */
    public String sundayMidClose = null;
    public String sundayMidOpen = null;
    public String mondayMidClose = null;
    public String mondayMidOpen = null;
    public String tuesdayMidClose = null;
    public String tuesdayMidOpen = null;
    public String wednesdayMidClose = null;
    public String wednesdayMidOpen = null;
    public String thursdayMidClose = null;
    public String thursdayMidOpen = null;
    public String fridayMidClose = null;
    public String fridayMidOpen = null;
    public String saturdayMidClose = null;
    public String saturdayMidOpen = null;

    /* Constructors */
    public HoursMidDayClose() {
        super();
    } 

    public HoursMidDayClose(String sundayMidClose, String sundayMidOpen, String mondayMidClose, String mondayMidOpen, String tuesdayMidClose, String tuesdayMidOpen, String wednesdayMidClose, String wednesdayMidOpen, String thursdayMidClose, String thursdayMidOpen, String fridayMidClose, String fridayMidOpen, String saturdayMidClose, String saturdayMidOpen) {
        super();
        this.sundayMidClose = sundayMidClose;
        this.sundayMidOpen = sundayMidOpen;
        this.mondayMidClose = mondayMidClose;
        this.mondayMidOpen = mondayMidOpen;
        this.tuesdayMidClose = tuesdayMidClose;
        this.tuesdayMidOpen = tuesdayMidOpen;
        this.wednesdayMidClose = wednesdayMidClose;
        this.wednesdayMidOpen = wednesdayMidOpen;
        this.thursdayMidClose = thursdayMidClose;
        this.thursdayMidOpen = thursdayMidOpen;
        this.fridayMidClose = fridayMidClose;
        this.fridayMidOpen = fridayMidOpen;
        this.saturdayMidClose = saturdayMidClose;
        this.saturdayMidOpen = saturdayMidOpen;
    }

    public HoursMidDayClose(boolean sundayMidDayClose, boolean mondayMidDayClose, boolean tuesdayMidDayClose, boolean wednesdayMidDayClose, boolean thursdayMidDayClose, boolean fridayMidDayClose, boolean saturdayMidDayClose, String sundayMidClose, String sundayMidOpen, String mondayMidClose, String mondayMidOpen, String tuesdayMidClose, String tuesdayMidOpen, String wednesdayMidClose, String wednesdayMidOpen, String thursdayMidClose, String thursdayMidOpen, String fridayMidClose, String fridayMidOpen, String saturdayMidClose, String saturdayMidOpen) {
        super(sundayMidDayClose, mondayMidDayClose, tuesdayMidDayClose, wednesdayMidDayClose, thursdayMidDayClose, fridayMidDayClose, saturdayMidDayClose);
        this.sundayMidClose = sundayMidClose;
        this.sundayMidOpen = sundayMidOpen;
        this.mondayMidClose = mondayMidClose;
        this.mondayMidOpen = mondayMidOpen;
        this.tuesdayMidClose = tuesdayMidClose;
        this.tuesdayMidOpen = tuesdayMidOpen;
        this.wednesdayMidClose = wednesdayMidClose;
        this.wednesdayMidOpen = wednesdayMidOpen;
        this.thursdayMidClose = thursdayMidClose;
        this.thursdayMidOpen = thursdayMidOpen;
        this.fridayMidClose = fridayMidClose;
        this.fridayMidOpen = fridayMidOpen;
        this.saturdayMidClose = saturdayMidClose;
        this.saturdayMidOpen = saturdayMidOpen;
    }

    public HoursMidDayClose(String sundayOpen, String sundayClose, String mondayOpen, String mondayClose, String tuesdayOpen, String tuesdayClose, String wednesdayOpen, String wednesdayClose, String thursdayOpen, String thursdayClose, String fridayOpen, String fridayClose, String saturdayOpen, String saturdayClose, boolean sundayMidDayClose, boolean mondayMidDayClose, boolean tuesdayMidDayClose, boolean wednesdayMidDayClose, boolean thursdayMidDayClose, boolean fridayMidDayClose, boolean saturdayMidDayClose, String sundayMidClose, String sundayMidOpen, String mondayMidClose, String mondayMidOpen, String tuesdayMidClose, String tuesdayMidOpen, String wednesdayMidClose, String wednesdayMidOpen, String thursdayMidClose, String thursdayMidOpen, String fridayMidClose, String fridayMidOpen, String saturdayMidClose, String saturdayMidOpen) {
        super(sundayOpen, sundayClose, mondayOpen, mondayClose, tuesdayOpen, tuesdayClose, wednesdayOpen, wednesdayClose, thursdayOpen, thursdayClose, fridayOpen, fridayClose, saturdayOpen, saturdayClose, sundayMidDayClose, mondayMidDayClose, tuesdayMidDayClose, wednesdayMidDayClose, thursdayMidDayClose, fridayMidDayClose, saturdayMidDayClose);
        this.sundayMidClose = sundayMidClose;
        this.sundayMidOpen = sundayMidOpen;
        this.mondayMidClose = mondayMidClose;
        this.mondayMidOpen = mondayMidOpen;
        this.tuesdayMidClose = tuesdayMidClose;
        this.tuesdayMidOpen = tuesdayMidOpen;
        this.wednesdayMidClose = wednesdayMidClose;
        this.wednesdayMidOpen = wednesdayMidOpen;
        this.thursdayMidClose = thursdayMidClose;
        this.thursdayMidOpen = thursdayMidOpen;
        this.fridayMidClose = fridayMidClose;
        this.fridayMidOpen = fridayMidOpen;
        this.saturdayMidClose = saturdayMidClose;
        this.saturdayMidOpen = saturdayMidOpen;
    }

    public HoursMidDayClose(boolean sunday, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday,  boolean saturday, String sundayOpen, String sundayClose, String mondayOpen, String mondayClose, String tuesdayOpen, String tuesdayClose, String wednesdayOpen, String wednesdayClose, String thursdayOpen, String thursdayClose, String fridayOpen, String fridayClose, String saturdayOpen, String saturdayClose, boolean sundayMidDayClose, boolean mondayMidDayClose, boolean tuesdayMidDayClose, boolean wednesdayMidDayClose, boolean thursdayMidDayClose, boolean fridayMidDayClose, boolean saturdayMidDayClose, String sundayMidClose, String sundayMidOpen, String mondayMidClose, String mondayMidOpen, String tuesdayMidClose, String tuesdayMidOpen, String wednesdayMidClose, String wednesdayMidOpen, String thursdayMidClose, String thursdayMidOpen, String fridayMidClose, String fridayMidOpen, String saturdayMidClose, String saturdayMidOpen) {
        super(sunday, monday, tuesday, wednesday, thursday, friday, saturday, sundayOpen, sundayClose, mondayOpen, mondayClose, tuesdayOpen, tuesdayClose, wednesdayOpen, wednesdayClose, thursdayOpen, thursdayClose, fridayOpen, fridayClose, saturdayOpen, saturdayClose, sundayMidDayClose, mondayMidDayClose, tuesdayMidDayClose, wednesdayMidDayClose, thursdayMidDayClose, fridayMidDayClose, saturdayMidDayClose);
        this.sundayMidClose = sundayMidClose;
        this.sundayMidOpen = sundayMidOpen;
        this.mondayMidClose = mondayMidClose;
        this.mondayMidOpen = mondayMidOpen;
        this.tuesdayMidClose = tuesdayMidClose;
        this.tuesdayMidOpen = tuesdayMidOpen;
        this.wednesdayMidClose = wednesdayMidClose;
        this.wednesdayMidOpen = wednesdayMidOpen;
        this.thursdayMidClose = thursdayMidClose;
        this.thursdayMidOpen = thursdayMidOpen;
        this.fridayMidClose = fridayMidClose;
        this.fridayMidOpen = fridayMidOpen;
        this.saturdayMidClose = saturdayMidClose;
        this.saturdayMidOpen = saturdayMidOpen;
    }

    /* Getters */
    public String getSundayMidClose() {
        return this.sundayMidClose;
    }

    public String getSundayMidOpen() {
        return this.sundayMidOpen;
    }

    public String getMondayMidClose() {
        return this.mondayMidClose;
    }

    public String getMondayMidOpen() {
        return this.mondayMidOpen;
    }

    public String getTuesdayMidClose() {
        return this.tuesdayMidClose;
    }

    public String getTuesdayMidOpen() {
        return this.tuesdayMidOpen;
    }

    public String getWednesdayMidClose() {
        return this.wednesdayMidClose;
    }

    public String getWednesdayMidOpen() {
        return this.wednesdayMidOpen;
    }

    public String getThursdayMidClose() {
        return this.thursdayMidClose;
    }

    public String getThursdayMidOpen() {
        return this.thursdayMidOpen;
    }

    public String getFridayMidClose() {
        return this.fridayMidClose;
    }

    public String getFridayMidOpen() {
        return this.fridayMidOpen;
    }

    public String getSaturdayMidClose() {
        return this.saturdayMidClose;
    }

    public String getSaturdayMidOpen() {
        return this.saturdayMidOpen;
    }

    /* Setters */
    public void setSundayMidClose(String sundayMidClose) {
        this.sundayMidClose = sundayMidClose;
    }

    public void setSundayMidOpen(String sundayMidOpen) {
        this.sundayMidOpen = sundayMidOpen;
    }

    public void setMondayMidClose(String mondayMidClose) {
        this.mondayMidClose = mondayMidClose;
    }

    public void setMondayMidOpen(String mondayMidOpen) {
        this.mondayMidOpen = mondayMidOpen;
    }

    public void setTuesdayMidClose(String tuesdayMidClose) {
        this.tuesdayMidClose = tuesdayMidClose;
    }

    public void setTuesdayMidOpen(String tuesdayMidOpen) {
        this.tuesdayMidOpen = tuesdayMidOpen;
    }

    public void setWednesdayMidClose(String wednesdayMidClose) {
        this.wednesdayMidClose = wednesdayMidClose;
    }

    public void setWednesdayMidOpen(String wednesdayMidOpen) {
        this.wednesdayMidOpen = wednesdayMidOpen;
    }

    public void setThursdayMidClose(String thursdayMidClose) {
        this.thursdayMidClose = thursdayMidClose;
    }

    public void setThursdayMidOpen(String thursdayMidOpen) {
        this.thursdayMidOpen = thursdayMidOpen;
    }

    public void setFridayMidClose(String fridayMidClose) {
        this.fridayMidClose = fridayMidClose;
    }

    public void setFridayMidOpen(String fridayMidOpen) {
        this.fridayMidOpen = fridayMidOpen;
    }

    public void setSaturdayMidClose(String saturdayMidClose) {
        this.saturdayMidClose = saturdayMidClose;
    }

    public void setSaturdayMidOpen(String saturdayMidOpen) {
        this.saturdayMidOpen = saturdayMidOpen;
    }

    // String representation of the hours
    @Override
    public String toString() {
        // Create string builder to hold hours
        StringBuilder hours = new StringBuilder("\nHours\n\n");

        // Add Sunday hours
        if (super.getSunday() == true) {
            if (super.getSundayMidDayClose() == true) {
                hours.append("Sunday: " + super.getSundayOpen() + " to " + this.sundayMidClose + " and " + this.sundayMidOpen + " to " + super.getSundayClose() + "\n");
            }
            else {
            hours.append("Sunday: " + super.getSundayOpen() + " to " + super.getSundayClose() + "\n");
            }
        }
        else {
            hours.append("Sunday: Closed\n");
        }

        // Add Monday hours
        if (super.getMonday() == true) {
            if (super.getMondayMidDayClose() == true) {
                hours.append("Monday: " + super.getMondayOpen() + " to " + this.mondayMidClose + " and " + this.mondayMidOpen + " to " + super.getMondayClose() + "\n");
            }
            else {
                hours.append("Monday: " + super.getMondayOpen() + " to " + super.getMondayClose() + "\n");
            }
        }
        else {
            hours.append("Monday: Closed\n");
        }

        // Add Tuesday hours
        if (super.getTuesday() == true) {
            if (super.getTuesdayMidDayClose() == true) {
                hours.append("Tuesday: " + super.getTuesdayOpen() + " to " + this.tuesdayMidClose + " and " + this.tuesdayMidOpen + " to " + super.getTuesdayClose() + "\n");
            }
            else {
                hours.append("Tuesday: " + super.getTuesdayOpen() + " to " + super.getTuesdayClose() + "\n");
            }
        }
        else {
            hours.append("Tuesday: Closed\n");
        }

        // Add Wednesday hours
        if (super.getWednesday() == true) {
            if (super.getWednesdayMidDayClose() == true) {
                hours.append("Wednesday: " + super.getWednesdayOpen() + " to " + this.wednesdayMidClose + " and " + this.wednesdayMidOpen + " to " + super.getWednesdayClose() + "\n");
            }
            else {
                hours.append("Wednesday: " + super.getWednesdayOpen() + " to " + super.getWednesdayClose() + "\n");
            }
        }
        else {
            hours.append("Wednesday: Closed\n");
        }

        // Add Thursday hours
        if (super.getThursday() == true) {
            if (super.getThursdayMidDayClose() == true) {
                hours.append("Thursday: " + super.getThursdayOpen() + " to " + this.thursdayMidClose + " and " + this.thursdayMidOpen + " to " + super.getThursdayClose() + "\n");
            }
            else {
                hours.append("Thursday: " + super.getThursdayOpen() + " to " + super.getThursdayClose() + "\n");
            }
        }
        else {
            hours.append("Thursday: Closed\n");
        }

        // Add Friday hours
        if (super.getFriday() == true) {
            if (super.getFridayMidDayClose() == true) {
                hours.append("Friday: " + super.getFridayOpen() + " to " + this.fridayMidClose + " and " + this.fridayMidOpen + " to " + super.getFridayClose() + "\n");
            }
            else {
                hours.append("Friday: " + super.getFridayOpen() + " to " + super.getFridayClose() + "\n");
            }
        }
        else {
            hours.append("Friday: Closed\n");
        }

        // Add Saturday hours
        if (super.getSaturday() == true) {
            if (super.getSaturdayMidDayClose() == true) {
                hours.append("Saturday: " + super.getSaturdayOpen() + " to " + this.saturdayMidClose + " and " + this.saturdayMidOpen + " to " + super.getSaturdayClose() + "\n");
            }
            else {
                hours.append("Saturday: " + super.getSaturdayOpen() + " to " + super.getSaturdayClose() + "\n");
            }
        }
        else {
            hours.append("Saturday: Closed\n");
        }
        // Return string
        return hours.toString();
    }
}
