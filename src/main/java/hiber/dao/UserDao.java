package hiber.dao;

import hiber.model.User;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   List<User> findCar(String model, int series);

}
