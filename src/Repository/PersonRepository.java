package Repository;

import Model.Driver;
import Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//
public class PersonRepository {
    List<User> usersList;
    List<Driver> driversList;
    HashMap<String, User> usersMap;
    HashMap<String, Driver> driversMap;
    public PersonRepository(){
        this.usersList = new ArrayList<>();
        this.driversList = new ArrayList<>();
        this.usersMap = new HashMap<>();
        this.driversMap = new HashMap<>();
    }

    public List<User> getUsersList(){
        return usersList;
    }

    public HashMap<String, User> getUsersMap(){
        return usersMap;
    }

    public HashMap<String, Driver> getDriversMap(){
        return driversMap;
    }

    public void setUsersList(List<User> usersList){
        this.usersList = usersList;
    }

    public void addUser(User u){
        this.usersList.add(u);
        usersMap.put(u.getName(), u);
    }

    public List<Driver> getDriversList(){
        return driversList;
    }

    public void setDriversList(List<Driver> driversList){
        this.driversList = driversList;
    }

    public void addDriver(Driver d){
        this.driversList.add(d);
        driversMap.put(d.getName(), d);
    }
}


















