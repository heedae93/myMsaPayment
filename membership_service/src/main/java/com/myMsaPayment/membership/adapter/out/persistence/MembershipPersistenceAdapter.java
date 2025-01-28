package com.myMsaPayment.membership.adapter.out.persistence;

import com.myMsaPayment.common.PersistenceAdapter;
import com.myMsaPayment.membership.application.port.out.FindMembershipPort;
import com.myMsaPayment.membership.application.port.out.ModifyMembershipPort;
import com.myMsaPayment.membership.application.port.out.RegisterMembershipPort;
import com.myMsaPayment.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

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

    @Override
    public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
       return membershipRepository.getReferenceById(Long.parseLong(membershipId.getMembershipId()));
    }


    @Override
    public MembershipJpaEntity modifyMembership(
            Membership.MembershipId membershipId,
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid
           ) {
            MembershipJpaEntity membershipJpaEntity = membershipRepository.getReferenceById(Long.parseLong(membershipId.getMembershipId()));
            membershipJpaEntity.setName(membershipName.getNameValue());
            membershipJpaEntity.setAddress(membershipAddress.getAddressValue());
            membershipJpaEntity.setEmail(membershipEmail.getEmailValue());
            membershipJpaEntity.setValid(membershipIsValid.isValidValue());

            return membershipRepository.save(membershipJpaEntity);


    }
}