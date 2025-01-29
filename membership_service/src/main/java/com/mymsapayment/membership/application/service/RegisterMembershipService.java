package com.mymsapayment.membership.application.service;

import com.mymsapayment.common.UseCase;
import com.mymsapayment.membership.adapter.out.persistence.MembershipJpaEntity;
import com.mymsapayment.membership.adapter.out.persistence.MembershipMapper;
import com.mymsapayment.membership.application.port.in.RegisterMembershipCommand;
import com.mymsapayment.membership.application.port.in.RegisterMembershipUseCase;
import com.mymsapayment.membership.application.port.out.RegisterMembershipPort;
import com.mymsapayment.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

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
