package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Alexander", "Petrov", "user1@mail.ru", new Car("Volkswagen", 100)));
      userService.add(new User("Andrey", "Ivanov", "user2@mail.ru", new Car("Mercedes", 200)));
      userService.add(new User("Olga", "Sidorova", "user3@mail.ru", new Car("Porsche", 300)));
      userService.add(new User("Anastasiya", "Semina", "user4@mail.ru", new Car("Ford", 400)));

      User user1 = userService.userModelCar("Volkswagen",100);
//      User user2 = userService.userModelCar("Mrcedes",200);
//      User user3 = userService.userModelCar("Porsche",300);
//      User user4 = userService.userModelCar("Ford",400);

      System.out.println(user1);
      System.out.println("---------------------------------");
//      System.out.println(user2);
//      System.out.println(user3);
//      System.out.println(user4);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar().getModel());
         System.out.println();
         System.out.println("---------------------------------");
      }

      context.close();
   }
}
