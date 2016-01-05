package App.controller;

import App.model.Product;

import java.util.ArrayList;

/**
 * Created by test on 25.10.15.
 */
public interface ISellerController {

    ArrayList<Product> getAll();

    Product findProductByName(String name);

    Product findProductByCode(String barCode);


}
