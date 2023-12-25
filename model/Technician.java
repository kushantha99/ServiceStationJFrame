package model;

public class Technician extends Record {
    public String contactNumber;
    public String level;

    public Technician(int id, String name, String contactNumber, String level) {
        super(id, name);
        this.contactNumber = contactNumber;
        this.level = level;
    }

    @Override
    public String toString() {
        String str = super.toString() + " " + contactNumber + " " + level;

        return str;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setLevel(String level) {
        this.level = level;

    }
    public void set(String name, String number, String level) {
        this.name = name;
        this.contactNumber = number;
        this.level = level;
        updateViews(AddOrEdit.EDIT);

    }
}
