package com.pranava.accounts.service.impl;

import com.pranava.accounts.dto.AccountsDto;
import com.pranava.accounts.dto.CardsDto;
import com.pranava.accounts.dto.CustomerDetailsDto;
import com.pranava.accounts.dto.LoansDto;
import com.pranava.accounts.entity.Accounts;
import com.pranava.accounts.entity.Customer;
import com.pranava.accounts.exception.ResourceNotFoundException;
import com.pranava.accounts.mapper.AccountsMapper;
import com.pranava.accounts.repository.AccountsRepository;
import com.pranava.accounts.repository.CustomerRepository;
import com.pranava.accounts.service.ICustomersService;
import com.pranava.accounts.service.client.CardsFeignClient;
import com.pranava.accounts.service.client.LoansFeignClient;
import com.pranava.accounts.mapper.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomersServiceImpl implements ICustomersService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId",
                        String.valueOf(customer.getCustomerId())));

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;

    }
}
