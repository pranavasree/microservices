package com.pranava.accounts.service;

import com.pranava.accounts.dto.CustomerDto;
import org.springframework.stereotype.Service;


public interface IAccountsService {

    /**
     *
     * @param customerDto - CustomerDto Object
     */

    void createAccount(CustomerDto customerDto);
}
