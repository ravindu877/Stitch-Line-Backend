package lk.stitchline.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ravindu Lakshan <ravindulakshan877@gmail.com>
 * @since 12/4/2021
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandardResponse {
    private String code;
    private String message;
    private Object data;
    private String userToken;
}
