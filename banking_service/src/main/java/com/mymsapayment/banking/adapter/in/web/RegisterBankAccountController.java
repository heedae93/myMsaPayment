package com.mymsapayment.banking.adapter.in.web;


import com.mymsapayment.banking.application.port.in.RegisterBankAccountCommand;
import com.mymsapayment.banking.application.port.in.RegisterBankAccountUseCase;
import com.mymsapayment.banking.domain.RegisterBankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

    private final RegisterBankAccountUseCase registerBankAccountUseCase;

    @PostMapping(path = "/banking/account/register")
    RegisterBankAccount registerBankAccount (@RequestBody RegisterBankAccountRequest request) {
        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
                .membershipId(request.getMembershipId())
                .bankName(request.getBankName())
                .bankAccountNumber(request.getBankAccountNumber())
                .linkedStatusIsValid(request.isLinkedStatusIsValid())
                .build();

        RegisterBankAccount registerBankAccount = registerBankAccountUseCase.registerBankAccount(command);
        if (registerBankAccount == null) {
            return null;
        } else {
            return registerBankAccount;
        }

    }

}
