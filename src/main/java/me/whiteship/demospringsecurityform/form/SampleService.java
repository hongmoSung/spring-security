package me.whiteship.demospringsecurityform.form;

import me.whiteship.demospringsecurityform.account.Account;
import me.whiteship.demospringsecurityform.account.AccountContext;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    public void dashboard() {
        Account accountThreadLocal = AccountContext.getAccountThreadLocal();
        System.out.println("============================");
        System.out.println(accountThreadLocal.getUsername());
    }
}
