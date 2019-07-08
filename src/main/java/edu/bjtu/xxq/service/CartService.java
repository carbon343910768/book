package edu.bjtu.xxq.service;

import com.sun.imageio.plugins.common.I18N;
import edu.bjtu.xxq.dao.CartDao;
import edu.bjtu.xxq.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public List<Integer> getCartsByUser(int id){return cartDao.findCartsByUser(id);}

    public List<Integer> getAllBooksInCart(int id) {
        return cartDao.findAllBooksInCart(id);
    }

    public Integer getBookNumber(int cartId, int bookId) {
        return cartDao.findBookNumberInCart(cartId, bookId);
    }

    public void updateCart(int cartId, Map<Integer, Integer> books){
        cartDao.updateCart(cartId,books);
        cartDao.delete();
    }

    public int addCart(Cart cart) {
        cartDao.addCart(cart);
        return cart.getId();
    }

    public boolean addBook(int cartId, int bookId, int number){
        cartDao.addBook(cartId,bookId,number);
        return true;
    }
}
