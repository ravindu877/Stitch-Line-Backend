package lk.stitchline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author Ravindu Lakshan <ravindulakshan877@gmail.com>
 * @since 12/5/2021
 **/

@Document("program")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Program {
    private String id;
    private String name;
    private String description;
    private Date start_date;
    private Date end_date;
}
