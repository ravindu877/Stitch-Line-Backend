package lk.stitchline.service.impl;

import lk.stitchline.dto.ProgramDTO;
import lk.stitchline.exception.NotFoundException;
import lk.stitchline.exception.ValidateException;
import lk.stitchline.model.Program;
import lk.stitchline.repo.ProgramRepo;
import lk.stitchline.service.ProgramService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * @author Ravindu Lakshan <ravindulakshan877@gmail.com>
 * @since 12/5/2021
 **/

@Service
@Transactional
public class ProgramServiceImpl implements ProgramService {

    @Autowired
    private ProgramRepo programRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void createProgram(ProgramDTO dto) {
        if(programRepo.existsById(dto.getId())){
            throw new ValidateException("Program Already Exists");
        }
        programRepo.save(modelMapper.map(dto, Program.class));
    }

    @Override
    public void updateProgram(ProgramDTO dto) {
        if(programRepo.existsById(dto.getId())){
            programRepo.save(modelMapper.map(dto, Program.class));
        }else {
            throw new NotFoundException("Something went wrong, check program id and try again");
        }
    }

    @Override
    public ArrayList<ProgramDTO> getProgramList() {
        return null;
    }
}
