package edu.bjtu.xxq.dao;

import edu.bjtu.xxq.model.Cart;
import edu.bjtu.xxq.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDao {

    Cart findCartById(int id);

    List<Cart> findCartsById(List<Integer> id);

    List<Integer> findCartsByUser(int id);

    List<Integer> findAllBooksInCart(int id);

    Integer findBookNumberInCart(int cartId, int bookId);

    // 返回cart生成的id
    void addCart(Cart cart);

    void addBook(int cartId, int bookId, int number);

}
