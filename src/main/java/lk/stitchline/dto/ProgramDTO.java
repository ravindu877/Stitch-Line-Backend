package lk.stitchline.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Ravindu Lakshan <ravindulakshan877@gmail.com>
 * @since 12/5/2021
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProgramDTO {
    private String id;
    private String name;
    private String description;
    private Date start_date;
    private Date end_date;
}
