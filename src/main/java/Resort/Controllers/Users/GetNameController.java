package Resort.Controllers.Users;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/info")
public class GetNameController {

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String getName(Authentication authentication, Principal principal) {
        return "user?="+authentication.getPrincipal().toString()+"role?="+principal.getName().toString();
    }
}
