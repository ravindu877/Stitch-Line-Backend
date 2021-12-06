package lk.stitchline.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lk.stitchline.dto.ProgramDTO;
import lk.stitchline.dto.UserDTO;
import lk.stitchline.exception.NotFoundException;
import lk.stitchline.service.ProgramService;
import lk.stitchline.service.UserService;
import lk.stitchline.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ravindu Lakshan <ravindulakshan877@gmail.com>
 * @since 12/5/2021
 **/
@RestController
@RequestMapping("/api/v1/content/programs")
@CrossOrigin
public class ProgramController {

    @Autowired
    private ProgramService programService;

    @Autowired
    private UserService userService;

    @Value("${jwt.secret}")
    private String secret;

    @PostMapping(path = {"/create"},consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveProgram(@RequestBody ProgramDTO dto, @RequestHeader("Authorization") String userToken) {


        Algorithm algorithm = Algorithm.HMAC256(secret);

        try {
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("Stitch-Line")
                    .build();

            DecodedJWT decodedToken = verifier.verify(userToken);

            String username = String.valueOf(decodedToken.getClaims().get("username"));
            String password = String.valueOf(decodedToken.getClaims().get("password"));

            if (username != null && password != null) {
                boolean isExists = userService.existUser(username);
                if (isExists) {
                    if (dto.getName().trim().length() <= 0) {
                        throw new NotFoundException("Program name cannot be empty");
                    }
                    programService.createProgram(dto);
                } else {
                    return new ResponseEntity(new StandardResponse("400", "Unauthorized request", dto, null), HttpStatus.CREATED);
                }
            }


        } catch (JWTVerificationException ex) {
            return new ResponseEntity(new StandardResponse("400", ex.getMessage(), dto, null), HttpStatus.CREATED);
        }
        return new ResponseEntity(new StandardResponse("201", "Done", dto, null), HttpStatus.CREATED);
    }


    @PostMapping(path = {"/update"},consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProgram(@RequestBody ProgramDTO dto, @RequestHeader("Authorization") String userToken) {
        System.out.println(dto);
        if (dto.getId().trim().length() <= 0) {
            throw new NotFoundException("Program id cannot be empty");
        }
        programService.updateProgram(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto, null), HttpStatus.CREATED);
    }






}
