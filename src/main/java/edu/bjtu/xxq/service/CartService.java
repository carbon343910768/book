package edu.bjtu.xxq.service;

import edu.bjtu.xxq.dao.CartDao;
import edu.bjtu.xxq.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartDao cartDao;

    public Cart getOne(int id) {
        return cartDao.findCartById(id);
    }

    public List<Cart> getList(List<Integer> id) {
        return cartDao.findCartsById(id);
    }

    public List<Integer> getAllBooksInCart(int id) {
        return cartDao.findAllBooksInCart(id);
    }

    public Integer getBookNumber(int cartId, int bookId) {
        return cartDao.findBookNumberInCart(cartId, bookId);
    }

    public int addCart(Cart cart) {
        return cartDao.addCart(cart);
    }
}
