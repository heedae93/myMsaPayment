package com.myMsaPayment.membership.adapter.in.web;


import com.myMsaPayment.membership.application.port.in.RegisterMembershipCommand;
import com.myMsaPayment.membership.application.port.in.RegisterMembershipUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {


    private final RegisterMembershipUseCase registerMembershipService;


    @PostMapping("/membership/register")
    void registerMembership(@RequestBody RegisterMembershipRequest registerMembershipRequest){


        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(registerMembershipRequest.getName())
                .address(registerMembershipRequest.getAddress())
                .email(registerMembershipRequest.getEmail())
                .build();
        System.out.println("커맨드 = " + command);
        System.out.println("서비스 = " + registerMembershipService);
        registerMembershipService.registerMembership(command);

    }

}
