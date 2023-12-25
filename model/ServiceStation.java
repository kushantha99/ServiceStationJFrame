package model;

import java.util.*;
/**
 * class Cinema
 */
public class ServiceStation extends Updater
{


    private Services services = new Services();
    private Technicians technicians = new Technicians();

    public Services getServices()
    {
        return services;
    }

    public Technicians getTechnicians()
    {
        return technicians;
    }



//    @Override
//    public String toString()
//    {
////        String s = "Cinema:";
////        s += " cost = $" + cost();
////        s += " income = $" + income();
////        s += " profit = $" + profit;
////        s+= " balance = $" + balance();
////        return s;
////    }
}