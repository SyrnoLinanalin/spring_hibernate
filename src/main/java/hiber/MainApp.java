package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

     UserService userService = context.getBean(UserService.class);


      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      user1.setCar(new Car("Fiat", 123));

      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      user2.setCar(new Car("Opel", 456));

      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      user3.setCar(new Car("Volvo", 789 ));

      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      user4.setCar(new Car("Lada" , 666 ));

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);


      System.out.println(user2);

      System.out.println( userService.findCar("Opel",456) );

      context.close();
   }
}
