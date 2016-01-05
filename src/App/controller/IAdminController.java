package App.controller;

import App.model.Product;
import App.model.User;

import java.util.ArrayList;

/**
 * Created by test on 25.10.15.
 */
public interface IAdminController {

    Product addProduct(String barCode, String model, double price);

    void renameProduct(Product product, String barCode, String model, double price);

    boolean deleteProduct(String barCode);

    ArrayList<Product> getAll();

    Product findProductByName(String name);

    Product findProductByCode(String barCode);

    ArrayList<User> getAllUsers();


}
