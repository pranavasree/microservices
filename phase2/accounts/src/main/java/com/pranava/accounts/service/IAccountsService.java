package com.pranava.accounts.service;

import com.pranava.accounts.dto.CustomerDto;
import org.springframework.stereotype.Service;


public interface IAccountsService {

    /**
     *
     * @param customerDto - CustomerDto Object
     */

    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return Accounts Details based on a given mobileNumber
     */
    CustomerDto fetchAccount(String mobileNumber);

}
