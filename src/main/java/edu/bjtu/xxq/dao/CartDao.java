package edu.bjtu.xxq.dao;

import edu.bjtu.xxq.model.Cart;
import edu.bjtu.xxq.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CartDao {

    Cart findCartById(int id);

    List<Cart> findCartsById(List<Integer> id);

    List<Integer> findCartsByUser(int id);

    List<Integer> findAllBooksInCart(int id);

    Integer findBookNumberInCart(int cartId, int bookId);

    void updateCart(int cartId, Map<Integer, Integer> books);

    void clear();

    void addCart(Cart cart);

    void addBook(int cartId, int bookId, int number);

}
