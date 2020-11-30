package me.whiteship.demospringsecurityform.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "hello Spring security");
        return "index";
    }

    @GetMapping("/info")
    public String info(Model model) {
        model.addAttribute("message", "hello info security");
        return "info";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("message", "hello admin security");
        return "admin";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("message", "hello dashboard security");
        return "dashboard";
    }
}
