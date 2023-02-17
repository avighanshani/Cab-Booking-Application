package Model;

public class Driver extends Person {
    private Vehicle vehicle;
    private Location presentLocation;
    private Boolean availability;
    public Driver(String name, String gender, int age, Vehicle vehicle, Location presentLocation, Boolean availability){
        super(name, gender, age);
        this.vehicle = vehicle;
        this.presentLocation = presentLocation;
        this.availability = availability;
    }

    public Vehicle getVehicle(){
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public Location getPresentLocation(){
        return this.presentLocation;
    }

    public void setPresentLocation(Location presentLocation){
        this.presentLocation = presentLocation;
    }

    public Boolean getAvailability(){
        return this.availability;
    }

    public void setAvailability(Boolean availability){
        this.availability = availability;
    }

}


























































































