package com.pranava.accounts.repository;

import com.pranava.accounts.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Optional<Object> findByCustomerId(long customerId);
}
