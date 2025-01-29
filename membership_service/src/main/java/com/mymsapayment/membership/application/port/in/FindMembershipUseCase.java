package com.mymsapayment.membership.application.port.in;

import com.mymsapayment.membership.domain.Membership;

public interface FindMembershipUseCase {
    Membership findMembership(FindMembershipCommand findMembershipCommand);
}
