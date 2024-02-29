package com.example.demo.Model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String pname;
    private String pdesc;

    @OneToMany(targetEntity = Stock.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="ps_fk",referencedColumnName = "pid")
    private List<Stock> stock;
}
