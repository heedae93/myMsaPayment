package com.myMsaPayment.membership.application.port.in;


import com.myMsaPayment.membership.domain.Membership;

public interface ModifyMembershipUseCase {
    Membership modifyMembership(ModifyMembershipCommand modifyMembershipCommand);
}
