package by.itstep.clothesshop.service;

import by.itstep.clothesshop.model.Basket;
import by.itstep.clothesshop.model.Product;
import by.itstep.clothesshop.model.User;

public interface BasketService {

    Basket addItemToBasket(Product product, int quantity, User user);

    Basket updateItemInBasket(Product product, int quantity, User user);

    Basket deleteItemFromBasket(Product product, User user);}

