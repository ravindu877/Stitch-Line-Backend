package lk.stitchline.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lk.stitchline.dto.LoginDTO;
import lk.stitchline.dto.UserDTO;
import lk.stitchline.exception.NotFoundException;
import lk.stitchline.service.UserService;
import lk.stitchline.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Ravindu Lakshan <ravindulakshan877@gmail.com>
 * @since 12/5/2021
 **/
@RestController
@RequestMapping("/api/v1/service")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${jwt.secret}")
    private String secret;

    @PostMapping(path = {"/register"},consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveUser(@RequestBody UserDTO dto) {
        if (dto.getUserName().trim().length() <= 0) {
            throw new NotFoundException("Username cannot be empty");
        }
        userService.userSave(dto);

        Date expireDate = new Date();
        Calendar cal= Calendar.getInstance();
        cal.setTime(expireDate);
        cal.add(Calendar.DATE, 1);
        expireDate= cal.getTime();


        Algorithm algorithm = Algorithm.HMAC256(secret);

        String userToken = JWT.create().withIssuer("Stitch-Line")
                .withClaim("username", dto.getUserName())
                .withClaim("password", dto.getPassword())
                .withExpiresAt(expireDate)
                .sign(algorithm);
        return new ResponseEntity(new StandardResponse("201", "Done", dto, userToken), HttpStatus.CREATED);
    }


    @PostMapping(path = {"/login"},consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity userLogin(@RequestBody LoginDTO dto) {
        System.out.println(dto);
        if (dto.getUserName().trim().length() <= 0) {
            throw new NotFoundException("Username cannot be empty");
        }
        UserDTO user = userService.getUser(dto);


        if (dto != null){
            Date expireDate = new Date();
            Calendar cal= Calendar.getInstance();
            cal.setTime(expireDate);
            cal.add(Calendar.DATE, 1);
            expireDate= cal.getTime();


            Algorithm algorithm = Algorithm.HMAC256(secret);

            String userToken = JWT.create().withIssuer("Stitch-Line")
                    .withClaim("username", dto.getUserName())
                    .withClaim("password", dto.getPassword())
                    .withExpiresAt(expireDate)
                    .sign(algorithm);
            return new ResponseEntity(new StandardResponse("201", "Done", user, userToken ), HttpStatus.CREATED);
        }else {
            new NotFoundException("User doesn't exists");
        }


        return new ResponseEntity(new StandardResponse("201", "Done", user, null ), HttpStatus.CREATED);
    }


}
