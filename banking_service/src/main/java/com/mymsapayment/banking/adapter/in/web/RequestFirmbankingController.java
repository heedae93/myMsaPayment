package com.mymsapayment.banking.adapter.in.web;


import com.mymsapayment.banking.application.port.in.FirmBankingRequestCommand;
import com.mymsapayment.banking.application.port.in.RegisterBankAccountCommand;
import com.mymsapayment.banking.application.port.in.RegisterBankAccountUseCase;
import com.mymsapayment.banking.application.port.in.RequestFirmBankingUseCase;
import com.mymsapayment.banking.domain.FirmBankingRequest;
import com.mymsapayment.banking.domain.RegisterBankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RequestFirmbankingController {

    private final RequestFirmBankingUseCase requestFirmBankingUseCase;

    @PostMapping(path = "/banking/firmbanking/request")
    FirmBankingRequest registerBankAccount (@RequestBody RequestFirmBankingRequest request) {
        FirmBankingRequestCommand command = FirmBankingRequestCommand.builder()
                .toBankName(request.getToBankName())
                .toBankAccountNumber(request.getToBankAccountNumber())
                .fromBankName(request.getFromBankName())
                .fromBankAccountNumber(request.getFromBankAccountNumber())
                .moneyAmount(request.getMoneyAmount())
                .build();

        return requestFirmBankingUseCase.requestFirmBanking(command);

    }

}
