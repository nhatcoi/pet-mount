package vn.pet.dto;

import lombok.*;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private long totalCount;
    private List<UserRequest> users;
}
