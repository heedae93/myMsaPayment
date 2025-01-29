package com.mymsapayment.membership.application.service;

import com.mymsapayment.common.UseCase;
import com.mymsapayment.membership.adapter.out.persistence.MembershipJpaEntity;
import com.mymsapayment.membership.adapter.out.persistence.MembershipMapper;
import com.mymsapayment.membership.application.port.in.ModifyMembershipCommand;
import com.mymsapayment.membership.application.port.in.ModifyMembershipUseCase;
import com.mymsapayment.membership.application.port.out.ModifyMembershipPort;
import com.mymsapayment.membership.domain.Membership;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@UseCase
@Transactional
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort membershipPersistenceAdapter;

    private final MembershipMapper membershipMapper;


    @Override
    public Membership modifyMembership(ModifyMembershipCommand modifyMembershipCommand) {

        MembershipJpaEntity membershipJpaEntity = membershipPersistenceAdapter.modifyMembership(
                new Membership.MembershipId(modifyMembershipCommand.getMembershipId()),
                new Membership.MembershipName(modifyMembershipCommand.getName()),
                new Membership.MembershipEmail(modifyMembershipCommand.getEmail()),
                new Membership.MembershipAddress(modifyMembershipCommand.getAddress()),
                new Membership.MembershipIsValid(modifyMembershipCommand.isValid())
        );

        return membershipMapper.mapToDomainEntity(membershipJpaEntity);
    }
}
