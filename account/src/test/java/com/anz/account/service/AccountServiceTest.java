package com.anz.account.service;


import com.anz.account.data.AccountEntity;
import com.anz.account.data.AccountsRepository;
import com.anz.account.shared.AccountsDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigInteger;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    private AccountsRepository accountRepository;

    @InjectMocks
    private AccountsService accountsService = new AccountsServiceImpl();


    @Test
    void testCreateAccountWhenAccountDetailsProvided() throws Exception {

        AccountsDto accountsDto = AccountsDto.builder()
                .accountNumber("123-11")
                .accountName("Abhishek")
                .accountBalance(333.43)
                .accountType("Savings")
                .currency("AUD")
                .build();

        AccountEntity accountEntity = AccountEntity.builder()
                .accountNumber("123-11")
                .accountName("Abhishek")
                .accountBalance(333.43)
                .accountType("Savings")
                .currency("AUD")
                .build();

        
        given(accountRepository.save(accountEntity)).willReturn(accountEntity);

        AccountsDto savedAccountsDto = accountsService.createAccount(accountsDto);

        assertThat(savedAccountsDto).isNotNull();

        verify(accountRepository).save(any(AccountEntity.class));
    }
}
