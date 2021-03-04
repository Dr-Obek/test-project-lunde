package eu.lundegaard.testform.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This controller class ensures exposing of a front-end of Contact Form
 *
 * @link index.html
 */
@Controller
public class IndexController {

    public static final String INDEX = "index";

    @GetMapping
    public String getIndex(Model model) {
        return INDEX;
    }
}
