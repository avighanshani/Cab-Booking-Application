package Model;

public class RideRequest {
    private User user;
    private Location start;
    private Location end;

    public RideRequest(User user, Location start, Location end){
        this.user = user;
        this.start = start;
        this.end = end;
    }

    public User getUser(){
        return this.user;
    }

    public void setUser(User u){
        this.user = u;
    }

    public Location getStart(Location start){
        return this.start;
    }

    public void setStart(Location start){
        this.start = start;
    }

    public Location getEnd(Location end){
        return this.end;
    }

    public void setEnd(Location end) {
        this.end = end;
    }
}
