package Service;

import Model.Driver;
import Model.Location;
import Model.Vehicle;
import Repository.PersonRepository;

public class DriverService {
    PersonRepository personRepository;
    public DriverService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public void add_driver(String driverDetails, String carDetails, String location)
    {
        driverDetails = driverDetails.replaceAll("\\s", "");
        String[] res = driverDetails.split("[,]", 0);
        String name = res[0];
        String gender = res[1];
        Integer age = Integer.parseInt(res[2]);

        carDetails = carDetails.replaceAll("\\s", "");

        String carName = "";
        String carNumber = "";
        Boolean comma = false;
        for(int i = 0; i < carDetails.length(); i++){
            if(carDetails.charAt(i) == ','){
                comma = true;
                continue;
            }
            if(!comma) carName += carDetails.charAt(i);
            else carNumber += carDetails.charAt(i);
        }
        Vehicle vehicle = new Vehicle(carName, carNumber);

        location = location.replaceAll("\\s", "");
        String xCoordinate = "";
        String yCoordinate = "";
        comma = false;
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
        Boolean availability = true;
        Driver d = new Driver(name, gender, age, vehicle, l, availability);
        personRepository.addDriver(d);
    }
}
