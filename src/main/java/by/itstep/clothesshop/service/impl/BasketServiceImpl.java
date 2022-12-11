package by.itstep.clothesshop.service.impl;

import by.itstep.clothesshop.model.Basket;
import by.itstep.clothesshop.model.CartItem;
import by.itstep.clothesshop.model.Product;
import by.itstep.clothesshop.model.User;
import by.itstep.clothesshop.repository.BasketRepository;
import by.itstep.clothesshop.repository.CartItemRepository;
import by.itstep.clothesshop.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private BasketRepository basketRepository;

    public Basket addItemToBasket(Product product, int quantity, User user) {
        Basket basket = user.getBasket();

        if (basket == null) {
            basket = new Basket();
        }
        Set<CartItem> cartItems = basket.getCartItem();
        CartItem cartItem = findCartItem(cartItems, product.getId());
        if (cartItems == null) {
            cartItems = new HashSet<>();
            if (cartItem == null) {
                cartItem = new CartItem();
                cartItem.setProduct(product);
                cartItem.setTotalPrice(quantity * product.getPrice());
                cartItem.setQuantity(quantity);
                cartItem.setBasket(basket);
                cartItems.add(cartItem);
                cartItemRepository.save(cartItem);
            }
        } else {
            if (cartItem == null) {
                cartItem = new CartItem();
                cartItem.setProduct(product);
                cartItem.setTotalPrice(quantity * product.getPrice());
                cartItem.setQuantity(quantity);
                cartItem.setBasket(basket);
                cartItems.add(cartItem);
                cartItemRepository.save(cartItem);
            } else {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                cartItem.setTotalPrice(cartItem.getTotalPrice() + (quantity * product.getPrice()));
                cartItemRepository.save(cartItem);
            }
        }
        basket.setCartItem(cartItems);

        int totalItems = totalItems(basket.getCartItem());
        double totalPrice = totalPrice(basket.getCartItem());

        basket.setTotalPrice(totalPrice);
        basket.setTotalItems(totalItems);
        basket.setUser(user);

        return basketRepository.save(basket);
    }

    @Override
    public Basket updateItemInBasket(Product product, int quantity, User user) {
        Basket cart = user.getBasket();

        Set<CartItem> cartItems = cart.getCartItem();

        CartItem item = findCartItem(cartItems, product.getId());

        item.setQuantity(quantity);
        item.setTotalPrice(quantity * product.getPrice());

        cartItemRepository.save(item);

        int totalItems = totalItems(cartItems);
        double totalPrice = totalPrice(cartItems);

        cart.setTotalItems(totalItems);
        cart.setTotalPrice(totalPrice);

        return basketRepository.save(cart);
    }

    @Override
    public Basket deleteItemFromBasket(Product product, User user) {
        Basket cart = user.getBasket();

        Set<CartItem> cartItems = cart.getCartItem();

        CartItem item = findCartItem(cartItems, product.getId());

        cartItems.remove(item);

        cartItemRepository.delete(item);

        double totalPrice = totalPrice(cartItems);
        int totalItems = totalItems(cartItems);

        cart.setCartItem(cartItems);
        cart.setTotalItems(totalItems);
        cart.setTotalPrice(totalPrice);

        return basketRepository.save(cart);
    }

    private CartItem findCartItem(Set<CartItem> cartItems, Integer productId) {
        if (cartItems == null) {
            return null;
        }
        CartItem cartItem = null;

        for (CartItem item : cartItems) {
            if (item.getProduct().getId() == productId) {
                cartItem = item;
            }
        }
        return cartItem;
    }

    private int totalItems(Set<CartItem> cartItems) {
        int totalItems = 0;
        for (CartItem item : cartItems) {
            totalItems += item.getQuantity();
        }
        return totalItems;
    }

    private double totalPrice(Set<CartItem> cartItems) {
        double totalPrice = 0.0;

        for (CartItem item : cartItems) {
            totalPrice += item.getTotalPrice();
        }

        return totalPrice;
    }
}

