package losky2987.myshorturl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MgrController {
    @GetMapping("/")
    public String index() {
        return "mgr";
    }
}
