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


      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      user1.setCar(new Car("Model1", 1));
      userService.add(user1);
      System.out.println("1");

      User user2 = new User("User2", "Lastname2", "user2@gmail.com");
      user2.setCar(new Car("Model2", 2));
      userService.add(user2);
      System.out.println("2");


      User user3 = new User("User3", "LastName3", "user3@gmail.com");
      user3.setCar(new Car("Model3", 3));
      userService.add(user3);
      System.out.println("3");




      User user4 = new User("User4", "LastName4", "user4@gmail.com");
      user4.setCar(new Car("Model4", 4));
      userService.add(user4);
      System.out.println("4");

      User oldUser = userService.getUserByCar("Model3",3);

      System.out.println("oldUser.getFirstName()  -");
      System.out.print(oldUser.getFirstName());

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         if (user.getCar()!=null){
            System.out.println("Car Id = " + user.getCar().getId());
            System.out.println("Car model = " + user.getCar().getModel());
            System.out.println("Car series = " + user.getCar().getSeries());
         }
         System.out.println();
      }


//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

      context.close();
   }
}
