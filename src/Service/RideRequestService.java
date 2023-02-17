package Service;

import Model.Driver;
import Model.Location;
import Model.RideRequest;
import Model.User;
import Repository.PersonRepository;
import Repository.RideRequestRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RideRequestService {
    PersonRepository personRepository;
    RideRequestRepository rideRequestRepository;
    public RideRequestService(PersonRepository personRepository, RideRequestRepository rideRequestRepository){
        this.personRepository = personRepository;
        this.rideRequestRepository = rideRequestRepository;
    }
    public Location getLocation(String location){
        location = location.replaceAll("\\s", "");
        String xCoordinate = "";
        String yCoordinate = "";
        Boolean comma = false;
        for(int i = 1; i < location.length() - 1; i++){
            if(location.charAt(i) == ','){
                comma = true;
                continue;
            }
            if(!comma) xCoordinate += location.charAt(i);
            else yCoordinate += location.charAt(i);
        }
        int x = Integer.parseInt(xCoordinate);
        int y = Integer.parseInt(yCoordinate);
        Location l = new Location(x, y);
        return l;
    }
    synchronized public List<Driver> find_ride(String name, String startLocation, String endLocation){
        Location start = getLocation(startLocation);
        Location end = getLocation(endLocation);
        HashMap<String, User> users  = personRepository.getUsersMap();
        User u = users.get(name);
        RideRequest r = new RideRequest(u, start, end);
        rideRequestRepository.addRideRequest(r);
        List<Driver> drivers = personRepository.getDriversList();
        List<Driver> availableDrivers = new ArrayList<>();
        for(int i = 0; i < drivers.size(); i++){
            Driver current = drivers.get(i);
            Location l = current.getPresentLocation();
            if(current.getAvailability() == true){
                Location driverLocation = current.getPresentLocation();
                if(driverLocation.distance(start) <= 5){
                    String driverName = current.getName();
//                    System.out.println(driverName);
                    availableDrivers.add(current);
                }
            }
        }
        return availableDrivers;
    }
    public void choose_ride(String user, List<Driver> availableDrivers){


        if(availableDrivers.size() != 0){
            Driver chosen = availableDrivers.get(0);
            chosen.setAvailability(false);
            System.out.println(chosen.getName());
        }
        else{
            System.out.println("No Drivers Available");
        }


    }
}
