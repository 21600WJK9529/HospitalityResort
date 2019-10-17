package Resort.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("/login")
    public ResponseEntity<String> home() {

        return new ResponseEntity<>("Welcome to the home page!", HttpStatus.OK);

    }

}
