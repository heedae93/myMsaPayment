package com.mymsapayment.banking.application.port.in;

import com.mymsapayment.banking.domain.RegisterBankAccount;





public interface RegisterBankAccountUseCase {

    RegisterBankAccount registerBankAccount (RegisterBankAccountCommand registerBankAccountCommand);


}
