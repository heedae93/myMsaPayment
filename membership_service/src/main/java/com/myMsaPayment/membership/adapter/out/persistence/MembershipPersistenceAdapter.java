package com.myMsaPayment.membership.adapter.out.persistence;

import com.myMsaPayment.common.PersistenceAdapter;
import com.myMsaPayment.membership.application.port.out.RegisterMembershipPort;
import com.myMsaPayment.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
class MembershipPersistenceAdapter implements RegisterMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public MembershipJpaEntity createMembership(Membership.MembershipName membershipName
            , Membership.MembershipEmail membershipEmail
            , Membership.MembershipAddress membershipAddress
            , Membership.MembershipIsValid membershipIsValid
            , Membership.MembershipAggregateIdentifier membershipAggregateIdentifier
    ) {
     return    membershipRepository.save(
                new MembershipJpaEntity(
                        membershipName.getNameValue(),
                        membershipEmail.getEmailValue(),
                        membershipAddress.getAddressValue(),
                        membershipIsValid.isValidValue(),
                        membershipAggregateIdentifier.getAggregateIdentifier()
                )
        );
    }

}