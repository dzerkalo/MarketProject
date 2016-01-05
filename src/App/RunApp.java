package App;

import App.controller.LoginWindowController;
import App.view.LoginPassFrame;
import App.controller.LoginController;
import App.model.Admin;
import App.model.MarketDB;
import App.model.Product;
import App.model.Seller;


public class RunApp {

    public static void main(String[] args) {
        Admin admin = new Admin(1, "slava","123456");
        Seller seller = new Seller (2, "test", "0987");

        MarketDB marketDB = new MarketDB();
        marketDB.getProducts().add(new Product("48205236","bread",26.5));
        marketDB.getProducts().add(new Product("48205258","milk",28.5));
        marketDB.getProducts().add(new Product("48205289","apple",37.0));
        marketDB.getProducts().add(new Product("123", "Design Patterns", 222.22));
        marketDB.getProducts().add(new Product("456", "JAVA", 333.33));
        marketDB.getAdmins().add(admin);
        marketDB.getSellers().add(seller);

        LoginPassFrame loginPassFrame = new LoginPassFrame(new LoginWindowController(new LoginController(marketDB)));


    }
}
