package lk.stitchline.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Ravindu Lakshan <ravindulakshan877@gmail.com>
 * @since 12/4/2021
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private String userName;
    private String password;
    private String name;
    private int mobile_number;
    private Date date_of_birth;
    private String gender;
    private String language;
}
