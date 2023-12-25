package model;
import java.util.*;
public class Services extends Records {

    @Override
    public Service find(int id) {
        return (Service) super.find(id);
    }



        public void add(String name, String model, String date, ServiceType type, Status status)
        {
            System.out.println("Setup a Service");
            Service serviceList = new Service(++id, name, model, date, type, status);
            add(serviceList);
        }

//
//    public void delete() {
//        int id = In.readInt("Enter service ID to delete: ");
//        deleteService(id);
//    }
//
//    public void addServiceAutomatically(String customerName, String vehicleModel, String date, ServiceType serviceType, Status status) {
//        System.out.println("Adding Service Automatically...");
//        Service service = new Service(++id, customerName, vehicleModel, date, serviceType, status);
//        super.add(service);
//        System.out.println(service.toString() + " 'Service Added Automatically !' ");
//    }
//
//    private ServiceType getServiceTypeFromUser() {
//        System.out.println("Choose service type:");
//        for (ServiceType type : ServiceType.values()) {
//            System.out.println(type.ordinal() + 1 + ". " + type.name());
//        }
//        int typeChoice = In.readInt("Enter the number for the service type") - 1;
//
//        if (typeChoice >= 0 && typeChoice < ServiceType.values().length) {
//            return ServiceType.values()[typeChoice];
//        } else {
//            System.out.println("Invalid service type choice. Defaulting to BASIC.");
//            return ServiceType.BODYWASH;
//        }
//    }
//
//    private Status getStatusFromUser() {
//        System.out.println("Change Status:");
//        for (Status type : Status.values()) {
//            System.out.println(type.ordinal() + 1 + ". " + type.name());
//        }
//        int typeChoice = In.readInt("Enter the number to change the Status") - 1;
//        if (typeChoice >= 0 && typeChoice < Status.values().length) {
//            return Status.values()[typeChoice];
//        } else {
//            System.out.println("Invalid service type choice. Defaulting to BASIC.");
//            return Status.Booked;
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "\n" + super.toString();
//    }
//
//
//    public void deleteService(int id) {
//        Service serviceToDelete = find(id);
//
//        if (serviceToDelete != null) {
//            super.records.remove(serviceToDelete);
//            System.out.println("Service with ID " + id + " deleted");
//        } else {
//            System.out.println("Service with ID " + id + " not found");
//        }
//    }
//
//    public Service updateService(int id, Service newService) {
//
//        if (!super.records.isEmpty()) {
//            if (id >= 0 && id < super.records.size()) {
//                super.records.set(id, newService);
//                return (Service) super.find(id);
//            } else {
//                System.out.println("Invalid service ID for update");
//            }
//        } else {
//            System.out.println("No services available for update");
//        }
//
//        return null;
//    }

}
