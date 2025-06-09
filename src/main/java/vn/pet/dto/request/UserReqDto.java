package vn.pet.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import vn.pet.util.Gender;
import vn.pet.util.UserStatus;
import vn.pet.util.UserType;
import vn.pet.valid.EnumClass;
import vn.pet.valid.EnumGender;
import vn.pet.valid.EnumPattern;
import vn.pet.valid.PhoneNumber;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import static vn.pet.util.Gender.*;

public class UserReqDto implements Serializable {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotNull(message = "Last name is required")
    private String lastName;

    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    @NotEmpty
    private String email;

    @PhoneNumber(message = "Phone number is not valid")
    private String phone;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @EnumPattern(name = "userStatus", regex = "ACTIVE|INACTIVE|NONE",
        message = "Status must be one of the following: ACTIVE, INACTIVE, NONE")
    private UserStatus status;

    @EnumGender(name = "gender", anyOf = {MALE, FEMALE, OTHER},
            message = "gender is not match enum")
    private Gender gender;

    @NotNull(message = "username can not be null")
    private String username;

    private String password;

    @NotNull(message = "Type can not be null")
    @EnumClass(name = "Type", enumClass = UserType.class)
    private String type;

    @NotEmpty(message = "Address can not be empty")
    private Set<AddressDto> addresses;
}
