package com.mymsapayment.banking.application.service;

import com.mymsapayment.banking.adapter.out.persistence.RegisteredBankAccountMapper;
import com.mymsapayment.banking.application.port.in.RegisterBankAccountCommand;
import com.mymsapayment.banking.application.port.in.RegisterBankAccountUseCase;
import com.mymsapayment.banking.application.port.out.RegisteredBankAccountPort;
import com.mymsapayment.banking.domain.RegisterBankAccount;
import com.mymsapayment.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisteredBankAccountPort registeredBankAccountPort;

    private final RegisteredBankAccountMapper registeredBankAccountMapper;


    @Override
    public RegisterBankAccount registerBankAccount(RegisterBankAccountCommand registerBankAccountCommand) {
        return null;
    }
}
