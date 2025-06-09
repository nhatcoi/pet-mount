package vn.pet.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserType {
    @JsonProperty("admin")
    ADMIN,
    @JsonProperty("owner")
    OWNER,
    @JsonProperty("user")
    USER
}
