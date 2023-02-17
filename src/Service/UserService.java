package Service;

import Model.User;
import Repository.PersonRepository;
//import Main.pr;
public class UserService {

    PersonRepository personRepository;
    public UserService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    public void add_user(String userDetails)
    {
        userDetails = userDetails.replaceAll("\\s", "");
        String[] res = userDetails.split("[,]", 0);
        String name = res[0];
        String gender = res[1];
        Integer age = Integer.parseInt(res[2]);
        User u = new User(name, gender, age);
        personRepository.addUser(u);
    }
}
