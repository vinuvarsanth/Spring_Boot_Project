package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepo;
import com.example.demo.dto.OrderRequest;


@RestController
public class OrderController {

    @Autowired
    private ProductRepo productRepo;

    @PostMapping("/placeOrder")
    public Product placeOrder(@RequestBody OrderRequest request){
        return productRepo.save(request.getProduct());
    }
    
    @GetMapping("/findAllOrders")
    public Page<Product> findAllOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "pid") String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        return productRepo.findAll(pageable);
    }
}
