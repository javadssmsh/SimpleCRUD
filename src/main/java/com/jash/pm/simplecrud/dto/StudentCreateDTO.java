package com.jash.pm.simplecrud.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class StudentCreateDTO {
    private String fullName;
    private Set<Long> courseIds; // only IDs, not whole course objects
}
