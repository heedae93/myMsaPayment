package com.mymsapayment.membership.application.port.out;

import com.mymsapayment.membership.adapter.out.persistence.MembershipJpaEntity;
import com.mymsapayment.membership.domain.Membership;

public interface RegisterMembershipPort {

    MembershipJpaEntity createMembership(
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid,
            Membership.MembershipAggregateIdentifier membershipAggregateIdentifier
    );
}
