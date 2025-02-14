package com.app.API.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="image_data") 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    private String name;
    private String type;

    @Lob
    @Column(name="image_data", length = 1000)
    private byte[] imageData;
}
