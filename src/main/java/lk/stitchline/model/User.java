package lk.stitchline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author Ravindu Lakshan <ravindulakshan877@gmail.com>
 * @since 12/4/2021
 **/
@Document("user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String userName;
    private String password;
    private String name;
    private int mobile_number;
    private Date date_of_birth;
    private String gender;
    private String language;
}
