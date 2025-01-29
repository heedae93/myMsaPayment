package com.mymsapayment.membership.application.port.out;

import com.mymsapayment.membership.adapter.out.persistence.MembershipJpaEntity;
import com.mymsapayment.membership.domain.Membership;

public interface FindMembershipPort {
    MembershipJpaEntity findMembership (Membership.MembershipId membershipId);
}
