package com.jash.pm.simplecrud.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class StudentResponseDTO {
    private Long id;
    private String fullName;
    private Set<String> courses; // course titles
}
