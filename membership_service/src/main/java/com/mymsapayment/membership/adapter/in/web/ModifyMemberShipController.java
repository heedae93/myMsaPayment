package com.mymsapayment.membership.adapter.in.web;

import com.mymsapayment.common.WebAdapter;
import com.mymsapayment.membership.application.port.in.ModifyMembershipCommand;
import com.mymsapayment.membership.application.port.in.ModifyMembershipUseCase;
import com.mymsapayment.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class ModifyMemberShipController {

    private final ModifyMembershipUseCase modifyMembershipUseCase;

    @PostMapping("/membership/modify/{membershipId}")
    ResponseEntity<Membership> modifyMembership(@RequestBody ModifyMembershipRequest modifyMembershipRequest){
        ModifyMembershipCommand modifyMembershipCommand = ModifyMembershipCommand.builder()
                .membershipId(modifyMembershipRequest.getMembershipId())
                .name(modifyMembershipRequest.getName())
                .address(modifyMembershipRequest.getAddress())
                .email(modifyMembershipRequest.getEmail())
                .isValid(modifyMembershipRequest.isValid())
                .isCorp(modifyMembershipRequest.isCorp())
                .build();


        return ResponseEntity.ok( modifyMembershipUseCase.modifyMembership(modifyMembershipCommand));

    }
}
