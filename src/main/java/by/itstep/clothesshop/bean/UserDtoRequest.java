package by.itstep.clothesshop.bean;

import by.itstep.clothesshop.model.Order;
import by.itstep.clothesshop.model.Role;
import lombok.*;

import javax.persistence.*;
import java.util.List;

public class UserDtoRequest {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString

    public class User {

        private Integer id;
        private String userName;
        private String userSurname;
        private Integer userAge;
        private String userPhone;
        private String userAddress;
        private String userEmail;
        private String userPassword;
        private Role role ;
        private List<Order> orders;
    }

}
