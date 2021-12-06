package lk.stitchline.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ravindu Lakshan <ravindulakshan877@gmail.com>
 * @since 12/5/2021
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDTO {
    private String userName;
    private String password;
}
