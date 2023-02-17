import Model.Driver;
import Repository.PersonRepository;
import Repository.RideRequestRepository;
import Service.DriverService;
import Service.RideRequestService;
import Service.UserService;

import java.util.List;


public class Main {

    public static void main(String args[])
    {
        PersonRepository personRepository = new PersonRepository();
        RideRequestRepository rideRequestRepository = new RideRequestRepository();

        UserService userService = new UserService(personRepository);
        DriverService driverService = new DriverService(personRepository);
        RideRequestService rideRequestService = new RideRequestService(personRepository, rideRequestRepository);


        // Adding Users
        userService.add_user("Abhishek, M, 23");
        userService.add_user("Rahul, M, 23");
        userService.add_user("Nandini, F, 22");

        // Adding Drivers
        driverService.add_driver("Driver1, M, 22", "Swift, KA-01-12345", "(10, 1)");
        driverService.add_driver("Driver2, M, 29", "Swift, KA-01-12345", "(31, 10)");
        driverService.add_driver("Driver3, M, 24 ", "Swift, KA-01-12345", "(15, 3)");

        // Finding Rides
        // We select the first driver available as of now but we can easily change it to however we like
        List<Driver> availableDrivers;
        availableDrivers = rideRequestService.find_ride("Abhishek", "(0, 0)", "(20, 1)");
        rideRequestService.choose_ride("Abhishek", availableDrivers);

        availableDrivers = rideRequestService.find_ride("Rahul", "(10, 0)", "(15, 3)");
        rideRequestService.choose_ride("Rahul", availableDrivers);


        availableDrivers = rideRequestService.find_ride("Nandini", "(10, 6)", "(20, 4)");
        rideRequestService.choose_ride("Nandini", availableDrivers);


        // Uncomment to run using threads
//        ThreadExtended t1 = new ThreadExtended(rideRequestService, "Abhishek", "(27, 9)", "(20, 1)");
//        ThreadExtended t2 = new ThreadExtended(rideRequestService, "Rahul", "(28, 9)", "(15, 3)");
//        t1.start();
//        t2.start();

    }
}