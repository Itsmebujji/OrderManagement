package com.vineeth.ordermanagement.service;

import com.vineeth.ordermanagement.model.Cart;
import com.vineeth.ordermanagement.repository.CartRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartService {

    public final CartRepository cartRepository;
    public final Logger logger = LoggerFactory.getLogger(CartService.class);

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public ResponseEntity<Object> getCartDetails() {
        try{
            List<Cart> cartItems = cartRepository.findAll();
            if(cartItems.isEmpty()){
                logger.info("No Products are available in the store");
                return ResponseEntity.ok("No Products are available in store");
            }else{
                return new ResponseEntity<>(cartItems, HttpStatus.OK);
            }
        }catch (Exception e) {
            logger.info("Error occurred while calling get products method: ${e}",e);
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> addToCart(Cart cart) {
        Cart itemCart = new Cart();
        if(cart==null){
            logger.info("Calling the request with invalid data");
            return ResponseEntity.badRequest().build();
        }else{
            try{
                itemCart.setItemName(cart.getItemName());
                itemCart.setCustomerId(cart.getCustomerId());
                itemCart.setItemPrice(cart.getItemPrice());
                itemCart.setItemQuantity(cart.getItemQuantity());
                itemCart.setTotalPrice(cart.getTotalPrice());
                cartRepository.save(itemCart);
                return new ResponseEntity<>(itemCart, HttpStatus.CREATED);
            }catch (Exception e) {
                logger.info("Error occurred while calling add product method: ${e}",e);
                return ResponseEntity.badRequest().build();
            }
        }
    }

    public ResponseEntity<Object> deleteCartItems(int customerId, List<Integer> ids) {
        if(customerId!=0){
            try{
                List<Cart> cart = cartRepository.findItemByIds(customerId,ids);
                if(cart!=null){
                    cartRepository.deleteItemByIds(customerId,ids);
                    return new ResponseEntity<>("Cart deleted successfully", HttpStatus.OK);
                }
                logger.info("Calling the request with invalid data");
                return new ResponseEntity<>("Cart not found", HttpStatus.NOT_FOUND);
            }catch (Exception e) {
                logger.info("Error occurred while calling delete cart method: ${e}",e);
                return new ResponseEntity<>("Cart not found", HttpStatus.NOT_FOUND);
            }
        }
        logger.info("Calling the request with invalid data");
        return new ResponseEntity<>("Cart not found", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> deleteCartItem(int customerId) {
        return null;
    }
}
