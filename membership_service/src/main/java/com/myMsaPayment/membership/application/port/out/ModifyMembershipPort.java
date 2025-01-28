package com.myMsaPayment.membership.application.port.out;

import com.myMsaPayment.membership.adapter.out.persistence.MembershipJpaEntity;
import com.myMsaPayment.membership.domain.Membership;

public interface ModifyMembershipPort {

    MembershipJpaEntity modifyMembership(
            Membership.MembershipId membershipId,
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid
    );
}
