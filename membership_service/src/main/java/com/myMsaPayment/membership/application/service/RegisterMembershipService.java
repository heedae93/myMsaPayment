package com.myMsaPayment.membership.application.service;

import com.myMsaPayment.common.UseCase;
import com.myMsaPayment.membership.adapter.out.persistence.MembershipJpaEntity;
import com.myMsaPayment.membership.adapter.out.persistence.MembershipMapper;
import com.myMsaPayment.membership.application.port.in.RegisterMembershipCommand;
import com.myMsaPayment.membership.application.port.in.RegisterMembershipUseCase;
import com.myMsaPayment.membership.application.port.out.RegisterMembershipPort;
import com.myMsaPayment.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
@RequiredArgsConstructor
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort membershipPersistentceAdapter;

    private final MembershipMapper membershipMapper;



    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {
        MembershipJpaEntity membershipJpaEntity =  membershipPersistentceAdapter.createMembership(
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipAggregateIdentifier("default")
        );

        return membershipMapper.mapToDomainEntity(membershipJpaEntity);
    }

}
