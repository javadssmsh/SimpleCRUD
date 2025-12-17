package com.jash.pm.simplecrud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCreateDTO {
    private String name;
    private Long categoryId;
}
