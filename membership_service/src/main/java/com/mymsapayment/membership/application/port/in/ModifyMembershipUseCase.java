package com.mymsapayment.membership.application.port.in;


import com.mymsapayment.membership.domain.Membership;

public interface ModifyMembershipUseCase {
    Membership modifyMembership(ModifyMembershipCommand modifyMembershipCommand);
}
