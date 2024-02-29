package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.Stock;

@Repository
public interface StockRepo extends JpaRepository<Stock,Integer>{
    
}
