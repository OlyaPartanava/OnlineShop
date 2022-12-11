package by.itstep.clothesshop.service;

import by.itstep.clothesshop.bean.UserDTO;
import by.itstep.clothesshop.model.User;

public interface UserService {
    UserDTO save(UserDTO userDTO);

    User findByUserName(String userName);


}



