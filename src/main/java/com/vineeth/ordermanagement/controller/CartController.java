package com.vineeth.ordermanagement.controller;

import com.vineeth.ordermanagement.model.Cart;
import com.vineeth.ordermanagement.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService){
        this.cartService=cartService;
    }

    @GetMapping("/getCartDetails")
    public ResponseEntity<Object> getCartDetails(){
        return cartService.getCartDetails();
    }

    @PostMapping("/addToCart")
    public ResponseEntity<Object> addToCart(Cart cart){
        return cartService.addToCart(cart);
    }

//    @DeleteMapping({"/deleteCartItem/{customerId}","/deleteCartItems/{customerId}"})
//    public ResponseEntity<Object> deleteCartItem(@PathVariable(required = true) int customerId, @RequestBody(required = false) List<Integer> ids){
//        if(!ids.isEmpty()){
//            return cartService.deleteCartItems(customerId,ids);
//        }else{
//            return cartService.deleteCartItem(customerId);
//        }
//    }
}
