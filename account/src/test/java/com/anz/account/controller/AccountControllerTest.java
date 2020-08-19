package com.anz.account.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;

import com.anz.account.service.TransactionService;
import com.anz.account.shared.AccountsDto;
import com.anz.account.shared.TransactionDto;
import com.anz.account.ui.model.TransactionRequestModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.anz.account.service.AccountsService;
import com.anz.account.ui.controller.AccountController;
import com.anz.account.ui.model.CreateAccountRequestModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(controllers = AccountController.class)
@ActiveProfiles("test")
public class AccountControllerTest {

	public static final String BASEURL = "/api";
	
	@Autowired
    private MockMvc mockMvc;


    @MockBean
    private AccountsService accountsService;

	@MockBean
	private TransactionService transactionService;

	@MockBean
	private ModelMapper modelMapper;

    @Autowired
    private ObjectMapper objectMapper;



    @BeforeEach
    void setUp() {

    }
    
	@Test
    void testCreateNewAccount() throws Exception {
		String uri =  "/createAccount";
		

		CreateAccountRequestModel createAccountRequest = CreateAccountRequestModel.builder()
				.accountNumber("123-11")
				.accountName("xxx")
				.accountType("Savings")
				.accountBalance(333.99)
				.currency("AUD")
				.build();


		AccountsDto accountsDto = AccountsDto.builder()
				.accountNumber("123-11")
				.accountName("xxx")
				.accountType("Savings")
				.accountBalance(333.99)
				.currency("AUD")
				.build();

		given(accountsService.createAccount(any(AccountsDto.class))).willReturn(accountsDto);

	    mockMvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(createAccountRequest)))
	    .andExpect(status().isCreated())
	    .andExpect(jsonPath("$.accountNumber", is(createAccountRequest.getAccountNumber())));
	}

	@Test
	void testUpdateAccount() throws Exception {
		String uri =  "/createTransaction";


		TransactionRequestModel transactionRequestModel = TransactionRequestModel.builder()
				.accountNumber("123-11")
				.accountName("xxx")
				.transactionType("Debit")
				.transactionAmount(333.99)
				.currency("AUD")
				.build();


		TransactionDto transactionDto = TransactionDto.builder()
				.accountNumber("123-11")
				.accountName("xxx")
				.transactionType("Debit")
				.transactionAmount(333.99)
				.currency("AUD")
				.build();

		given(transactionService.createTransaction(any(TransactionDto.class))).willReturn(transactionDto);

		mockMvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(transactionRequestModel)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.accountNumber", is(transactionRequestModel.getAccountNumber())));
	}



	@Test
	void testGetAllAccounts() throws Exception {

		List<AccountsDto> listAccountsDto = new ArrayList<>();
		listAccountsDto.add(AccountsDto.builder()
				.accountNumber("123-11")
				.accountName("xxx")
				.accountType("Savings")
				.accountBalance(333.99)
				.currency("AUD")
				.build());
		listAccountsDto.add(AccountsDto.builder()
				.accountNumber("222-11")
				.accountName("Abhi")
				.accountType("Savings")
				.accountBalance(1212.99)
				.currency("AUD")
				.build());

    	given(accountsService.getAllAccounts()).willReturn(listAccountsDto);

		mockMvc.perform(MockMvcRequestBuilders.get("/accounts"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.size()", is(listAccountsDto.size())));
	}

	@Test
	void testGetAccountByAccountNumber() throws Exception {

    	String accountNumber = "123-11";
		AccountsDto accountsDto = AccountsDto.builder()
				.accountNumber("123-11")
				.accountName("xxx")
				.accountType("Savings")
				.accountBalance(333.99)
				.currency("AUD")
				.build();


		given(accountsService.getAccountByAccountId(accountNumber)).willReturn(accountsDto);

		mockMvc.perform(MockMvcRequestBuilders.get("/account/{accountNumber}", accountNumber))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.accountName", is(accountsDto.getAccountName())));
	}


	@Test
	void testReturn404WhenFindAccountById() throws Exception {
		String accountNumber = "123-11";

		AccountsDto accountsDto = AccountsDto.builder()
				.accountNumber("123-11")
				.accountName("xxx")
				.accountType("Savings")
				.accountBalance(333.99)
				.currency("AUD")
				.build();

		given(accountsService.getAccountByAccountId(accountNumber)).willReturn(accountsDto);

		this.mockMvc.perform(MockMvcRequestBuilders.get("/account/{accountNumber}", accountNumber))
				.andExpect(status().isOk());
	}

}
