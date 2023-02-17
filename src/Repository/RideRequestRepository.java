package Repository;

import Model.RideRequest;

import java.util.ArrayList;
import java.util.List;

public class RideRequestRepository {
    List<RideRequest> rideRequests;

    public RideRequestRepository(){
        this.rideRequests = new ArrayList<>();
    }

    public List<RideRequest> getRideRequestsList(){
        return rideRequests;
    }

    public void setRideRequestsList(List<RideRequest> rideRequests){
        this.rideRequests = rideRequests;
    }

    public void addRideRequest(RideRequest r){
        this.rideRequests.add(r);
    }

}
