package model;

public class Service extends Record {

    public String model;
    public String date;
    public ServiceType serviceType;
    public Status status;

    public int getId() {
        return id;
    }

    public Service(int id, String name, String model, String date, ServiceType serviceType, Status status) {
        super(id, name);
        this.model = model;
        this.date = date;
        this.serviceType = serviceType;
        this.status = status;
    }

    @Override
    public String toString() {
        String str = super.toString() + " " + model + " " + date + " " + serviceType + " " + status;

        return str;
    }

//    public void setModel(String model) {
//        this.model = model;
//    }

//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public void setServiceType(ServiceType serviceType) {
//        this.serviceType = serviceType;
//    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }


    public void set(String name, String model, String date, ServiceType serviceType, Status status) {
        this.name = name;
        this.model = model;
        this.date = date;
        this.serviceType = serviceType;
        this.status = status;
        updateViews(AddOrEdit.EDIT);

    }
}
