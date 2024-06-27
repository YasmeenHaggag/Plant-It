package com.example.planIt.model;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum Role {

    Tourist(Arrays.asList(Permissions.CREATE_PLAN)),
    //MANAGER,
    ADMIN(Arrays.asList(Permissions.READ_ALL));
    private List<Permissions> permissions;

    Role(List<Permissions> permissions) {
        this.permissions=permissions;
    }
}
