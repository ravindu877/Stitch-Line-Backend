package lk.stitchline.repo;

import lk.stitchline.model.Program;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Ravindu Lakshan <ravindulakshan877@gmail.com>
 * @since 12/6/2021
 **/
public interface ProgramRepo extends MongoRepository<Program,String> {
}
