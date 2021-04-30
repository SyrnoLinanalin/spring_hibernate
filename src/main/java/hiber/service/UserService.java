package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    List<User> findCar(String model, int series);

    default List<User> findCar(Car car) {
        return findCar(car.getModel(), car.getSeries());

    }

}
