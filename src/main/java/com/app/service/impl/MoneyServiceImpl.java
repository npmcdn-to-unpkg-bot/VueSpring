package com.app.service.impl;

import com.app.pojo.Account;
import com.app.service.MoneyService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by moslpc on 2016/8/30.
 */
@Component
@Transactional
public class MoneyServiceImpl implements MoneyService{

    @Transactional(propagation = Propagation.REQUIRED, noRollbackFor = RuntimeException.class)
    public void transferMoney(Account a, Account b) {
        
    }
}
