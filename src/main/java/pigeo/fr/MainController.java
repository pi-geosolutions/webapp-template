package pigeo.fr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class MainController {

    @RequestMapping(value="/test/*", method=RequestMethod.GET)
    @ResponseBody
    public String handleGETRequest(
            HttpServletRequest request, HttpServletResponse response) {
        return "Pi-Geosolutions ready!";
    }
}
