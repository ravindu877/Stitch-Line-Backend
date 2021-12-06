package lk.stitchline.service;

import lk.stitchline.dto.LoginDTO;
import lk.stitchline.dto.UserDTO;

/**
 * @author Ravindu Lakshan <ravindulakshan877@gmail.com>
 * @since 12/4/2021
 **/
public interface UserService {

    void userSave(UserDTO dto);

    boolean existUser(String username);

    UserDTO getUser(LoginDTO dto);
}
