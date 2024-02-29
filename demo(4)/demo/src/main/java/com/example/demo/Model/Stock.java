package com.example.demo.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Stock {
    @Id
    private int sid;
    private long quantity;
    private String cname;
    private long price ;
}
