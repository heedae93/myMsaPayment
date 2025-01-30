package com.mymsapayment.banking.application.port.out;

import com.mymsapayment.banking.adapter.out.external.bank.BankAccount;
import com.mymsapayment.banking.adapter.out.external.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {
    BankAccount getBankAccountInfo(GetBankAccountRequest getBankAccountRequest);
}
