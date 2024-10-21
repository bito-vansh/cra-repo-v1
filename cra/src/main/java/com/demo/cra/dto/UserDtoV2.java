package com.demo.cra.dto;

/**
 * Represents an extended version of UserDtoV1 with an additional 'id' field.
 * This class inherits properties from UserDtoV1 and adds getter and setter methods for the 'id' attribute.
 */
public class UserDtoV2 extends UserDtoV1 {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
