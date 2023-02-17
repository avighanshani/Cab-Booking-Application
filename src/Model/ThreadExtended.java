package Model;

import Service.RideRequestService;

import java.util.List;

public class ThreadExtended extends Thread{
    RideRequestService rideRequestService;
    String name;
    String startLocation;
    String endLocation;

    public ThreadExtended(RideRequestService rideRequestService, String name, String startLocation, String endLocation){
        this.rideRequestService = rideRequestService;
        this.name = name;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }
    public void run(){
        List<Driver> availableDrivers = rideRequestService.find_ride(name, startLocation, endLocation);
        rideRequestService.choose_ride(name, availableDrivers);
    }
}
