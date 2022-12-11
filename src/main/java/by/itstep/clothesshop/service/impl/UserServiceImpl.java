package by.itstep.clothesshop.service.impl;

import by.itstep.clothesshop.bean.UserDTO;
import by.itstep.clothesshop.model.User;
import by.itstep.clothesshop.model.UserPrincipal;
import by.itstep.clothesshop.repository.RoleRepository;
import by.itstep.clothesshop.repository.UserRepository;
import by.itstep.clothesshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO save(UserDTO userDTO) {

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRoles(Arrays.asList(roleRepository.findByName("USER")));

        User userSave = userRepository.save(user);
        return toDto(userSave);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

//    @Override
//    public User saveInfo(User user) {
//        User user1 = userRepository.findByUsername(user.getUsername());
//        user1.setAddress(user.getAddress());
//        user1.setPhoneNumber(user.getPhoneNumber());
//        return userRepository.save(user1);
//    }

    private UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPassword(user.getPassword());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(user);
    }
}


