package com.onlinemedicineshope.service;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemedicineshope.entity.Medicine;
import com.onlinemedicineshope.entity.ShoppingCart;
import com.onlinemedicineshope.repository.CustomerRepository;
import com.onlinemedicineshope.repository.MedicineRepository;
import com.onlinemedicineshope.repository.ShoppingCartRepository;

import dto.ShoppingCartDTO;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class ShoppingCartService {

    @Autowired
    private MedicineRepository productRepository;

    @Autowired
    private CustomerRepository userRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCart saveProducts(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = new ShoppingCart();
        //Medicine product = productRepository.findOne(shoppingCartDTO.getid());
        //shoppingCart.setMedicine(product);
        //shoppingCart.setUser(userRepository.findOne(1L));
        shoppingCart.setStatus(shoppingCartDTO.getStatus());
        shoppingCart.setDate(new Date());
        shoppingCart.setStock(shoppingCartDTO.getStock());
        //shoppingCart.setAmount(product.getUnitPrice() * shoppingCartDTO.getStock());

        return shoppingCartRepository.save(shoppingCart);
    }


    public List<ShoppingCart> findAll() {
//        return shoppingCartRepository.findAll();
        return shoppingCartRepository.findByStatus("NOT_PURCHASED");
    }

   // public ShoppingCart updateProduct(ShoppingCartDTO shoppingCartDTO, Long id) {
        //Optional<ShoppingCart> updateItem = shoppingCartRepository.findById(id);
        //updateItem.setStock(shoppingCartDTO.getStock());
       // updateItem.setAmount(updateItem.getProduct().getUnitPrice() * shoppingCartDTO.getStock());
        //return shoppingCartRepository.save(updateItem);
    //}

//    public void deleteProduct(Long id) {
//        shoppingCartRepository.delete(id);
//    }

//    public void clearShoppingCart(Object object) {
//        shoppingCartRepository.delete(findAll());
//    }


    public List<ShoppingCart> findByPurchased() {
        return shoppingCartRepository.findByStatus("PURCHASED");
    }


//    public void purchaseProducts(Long id) {
//        ShoppingCart shoppingCart = shoppingCartRepository.findById(id);
//        shoppingCart.setStatus("PURCHASED");
//        shoppingCartRepository.save(shoppingCart);
//    }
}