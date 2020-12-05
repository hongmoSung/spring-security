package me.whiteship.demospringsecurityform.form;

import me.whiteship.demospringsecurityform.account.AccountContext;
import me.whiteship.demospringsecurityform.account.AccountRepository;
import me.whiteship.demospringsecurityform.common.SecurityLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.concurrent.Callable;

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

    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("message", "hello user security");
        return "user";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        AccountContext.setAccountThreadLocal(accountRepository.findByUsername(principal.getName()));
        sampleService.dashboard();
        model.addAttribute("message", "hello dashboard security");
        return "dashboard";
    }

    @GetMapping("/async_handler")
    @ResponseBody
    public Callable<String> asyncHandler() {
        SecurityLogger.log("MVC");
        return () -> {
            SecurityLogger.log("Callable");
            return "asyncHandler";
        };
    }
}
