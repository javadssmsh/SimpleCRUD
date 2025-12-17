package com.jash.pm.simplecrud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDTO {
    private String name;
    private UserProfileDTO profile;
}
