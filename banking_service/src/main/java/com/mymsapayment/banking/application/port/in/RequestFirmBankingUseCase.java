package com.mymsapayment.banking.application.port.in;

import com.mymsapayment.banking.domain.FirmBankingRequest;



public interface RequestFirmBankingUseCase {

    FirmBankingRequest requestFirmBanking (FirmBankingRequestCommand registerBankAccountCommand);


}
