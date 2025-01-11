package com.myMsaPayment.membership.application.port.out;

import com.myMsaPayment.membership.adapter.out.persistence.MembershipJpaEntity;
import com.myMsaPayment.membership.domain.Membership;

public interface RegisterMembershipPort {

    MembershipJpaEntity createMembership(
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid,
            Membership.MembershipAggregateIdentifier membershipAggregateIdentifier
    );
}
