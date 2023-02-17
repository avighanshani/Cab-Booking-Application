package Model;

public class Location {
    private Integer xCoordinate;
    private Integer yCoordinate;

    public Location(Integer xCoordinate, Integer yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
    public Integer distance(Location l1){
        Integer dist = Math.abs(l1.xCoordinate - this.xCoordinate) + Math.abs(l1.yCoordinate - this.yCoordinate);
        return dist;
    }

    public Integer getxCoordinate(){
        return this.xCoordinate;
    }

    public void setxCoordinate(Integer xCoordinate){
        this.xCoordinate = xCoordinate;
    }


    public Integer getyCoordinate(){
        return this.yCoordinate;
    }

    public void setyCoordinate(Integer yCoordinate){
        this.yCoordinate = yCoordinate;
    }

}
