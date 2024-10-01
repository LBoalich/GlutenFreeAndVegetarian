/* Abstract DaysOpen class */
public abstract class DaysOpen {
    /* Attributes defualt set to true meaning restaurant open that day */
    private boolean sunday = true;
    private boolean monday = true;
    private boolean tuesday = true;
    private boolean wednesday = true;
    private boolean thursday = true;
    private boolean friday = true;
    private boolean saturday = true;

    /* Constructors */
    protected DaysOpen() {};

    protected DaysOpen(boolean sunday, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday,  boolean saturday) {
        this.sunday = sunday;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
    }
    
    /* Getters */
    public boolean getSunday() {
        return this.sunday;
    }

    public boolean getMonday() {
        return this.monday;
    }

    public boolean getTuesday() {
        return this.tuesday;
    }

    public boolean getWednesday() {
        return this.wednesday;
    }

    public boolean getThursday() {
        return this.thursday;
    }

    public boolean getFriday() {
        return this.friday;
    }

    public boolean getSaturday() {
        return this.saturday;
    }

    /* Setters */
    public void setSunday(boolean sunday) {
        this.sunday = sunday;
    }

    public void setMonday(boolean monday) {
        this.monday = monday;
    }

    public void setTuesday(boolean tuesday) {
        this.tuesday = tuesday;
    }

    public void setWednesday(boolean wednesday) {
        this.wednesday = wednesday;
    }

    public void setThursday(boolean thursday) {
        this.thursday = thursday;
    }

    public void setFriday(boolean friday) {
        this.friday = friday;
    }

    public void setSaturday(boolean saturday) {
        this.saturday = saturday;
    }
}
