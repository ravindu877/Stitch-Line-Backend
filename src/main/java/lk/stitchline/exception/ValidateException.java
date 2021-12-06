package lk.stitchline.exception;

/**
 * @author Ravindu Lakshan <ravindulakshan877@gmail.com>
 * @since 12/4/2021
 **/
public class ValidateException extends RuntimeException{
    public ValidateException(String message) {
        super(message);
    }
}
