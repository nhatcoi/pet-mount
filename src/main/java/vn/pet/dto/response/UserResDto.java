package vn.pet.dto.response;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Builder
@ToString
public class UserResDto implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
