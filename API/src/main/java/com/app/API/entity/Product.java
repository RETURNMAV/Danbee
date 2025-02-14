package com.app.API.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
    
    private String pname;
    private int pcomp;
    private int psize;
    private int pprice;
}
