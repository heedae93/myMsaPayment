package com.myMsaPayment.membership.application.port.in;

import com.myMsaPayment.membership.domain.Membership;

public interface FindMembershipUseCase {
    Membership findMembership(FindMembershipCommand findMembershipCommand);
}
