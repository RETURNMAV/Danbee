package com.app.API.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

	private Long pid;
    private String pname;
    private String pcomp;
    private int psize;
    private int pprice;
    private String name;
    private String type;
}
