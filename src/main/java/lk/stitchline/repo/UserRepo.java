package lk.stitchline.repo;

import lk.stitchline.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Ravindu Lakshan <ravindulakshan877@gmail.com>
 * @since 12/4/2021
 **/
public interface UserRepo  extends MongoRepository<User, String> {

    boolean existsUserByUserName(String userName);

    User findUserByUserNameAndAndPassword(String usarname, String password);

}
