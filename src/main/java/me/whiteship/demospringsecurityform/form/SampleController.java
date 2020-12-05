package me.whiteship.demospringsecurityform.form;

import me.whiteship.demospringsecurityform.account.AccountContext;
import me.whiteship.demospringsecurityform.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/")
    public String index(Model model, Principal principal) {
        if(principal == null) {
            model.addAttribute("message", "hello Spring security");
        } else {
            model.addAttribute("message", principal.getName());
        }
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
    public String dashboard(Model model, Principal principal) {
        AccountContext.setAccountThreadLocal(accountRepository.findByUsername(principal.getName()));
        sampleService.dashboard();
        model.addAttribute("message", "hello dashboard security");
        return "dashboard";
    }
}
