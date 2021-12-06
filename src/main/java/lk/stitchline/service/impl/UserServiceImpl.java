package lk.stitchline.service.impl;

import lk.stitchline.dto.LoginDTO;
import lk.stitchline.dto.UserDTO;
import lk.stitchline.exception.ValidateException;
import lk.stitchline.model.User;
import lk.stitchline.repo.UserRepo;
import lk.stitchline.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Ravindu Lakshan <ravindulakshan877@gmail.com>
 * @since 12/4/2021
 **/

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void userSave(UserDTO dto) {
        if (userRepo.existsUserByUserName(dto.getUserName())) {
            throw new ValidateException("Customer Already Exist");
        }
        userRepo.save(modelMapper.map(dto, User.class));
    }

    @Override
    public boolean existUser(String username) {
        return userRepo.existsUserByUserName(username);
    }

    @Override
    public UserDTO getUser(LoginDTO dto) {
       User user= userRepo.findUserByUserNameAndAndPassword(dto.getUserName(),dto.getPassword());
       return modelMapper.map(user, UserDTO.class);
    }


}
