package com.myMsaPayment.membership.adapter.in.web;

import com.myMsaPayment.common.WebAdapter;
import com.myMsaPayment.membership.application.port.in.FindMembershipCommand;
import com.myMsaPayment.membership.application.port.in.FindMembershipUseCase;
import com.myMsaPayment.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMemberShipController {

    private final FindMembershipUseCase findMembershipUseCase;

    @GetMapping("/membership/{membershipId}")
    ResponseEntity<Membership> findMembershipByMemberId(@PathVariable String membershipId){
        FindMembershipCommand findMembershipCommand = FindMembershipCommand.builder()
                        .membershipId(membershipId)
                        .build();
       return ResponseEntity.ok(findMembershipUseCase.findMembership(findMembershipCommand)) ;
    }
}
