package com.vineeth.ordermanagement.repository;

import com.vineeth.ordermanagement.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

////    @Query(value = "SELECT * FROM cart")
//    List<Cart> findItemByIds(int customerId, List<Integer> ids);

//    void deleteItemByIds(int customerId, List<Integer> ids);
}
