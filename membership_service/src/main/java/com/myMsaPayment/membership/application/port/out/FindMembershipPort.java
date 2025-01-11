package com.myMsaPayment.membership.application.port.out;

import com.myMsaPayment.membership.adapter.out.persistence.MembershipJpaEntity;
import com.myMsaPayment.membership.domain.Membership;

public interface FindMembershipPort {
    MembershipJpaEntity findMembership (Membership.MembershipId membershipId);
}
