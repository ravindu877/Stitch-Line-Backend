package lk.stitchline.service;

import lk.stitchline.dto.ProgramDTO;
import lk.stitchline.model.Program;

import java.util.ArrayList;

/**
 * @author Ravindu Lakshan <ravindulakshan877@gmail.com>
 * @since 12/5/2021
 **/
public interface ProgramService {

    void createProgram(ProgramDTO dto);

    void updateProgram(ProgramDTO dto);

    ArrayList<ProgramDTO> getProgramList();

}
