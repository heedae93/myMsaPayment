package com.mymsapayment.banking.application.port.out;

import com.mymsapayment.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.mymsapayment.banking.domain.RegisterBankAccount;


public interface RegisteredBankAccountPort {

    RegisteredBankAccountJpaEntity createRegisteredBankAccount(
            RegisterBankAccount.MembershipId membershipId,
            RegisterBankAccount.BankName bankName,
            RegisterBankAccount.BankAccountNumber bankAccountNumber,
            RegisterBankAccount.LinkedStatusIsValid linkedStatusIsValid
    );
}
