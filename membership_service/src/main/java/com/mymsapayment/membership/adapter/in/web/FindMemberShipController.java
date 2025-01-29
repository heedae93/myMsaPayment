package com.mymsapayment.membership.adapter.in.web;

import com.mymsapayment.common.WebAdapter;
import com.mymsapayment.membership.application.port.in.FindMembershipCommand;
import com.mymsapayment.membership.application.port.in.FindMembershipUseCase;
import com.mymsapayment.membership.domain.Membership;
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
