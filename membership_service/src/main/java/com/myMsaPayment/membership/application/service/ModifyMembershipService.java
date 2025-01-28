package com.myMsaPayment.membership.application.service;

import com.myMsaPayment.common.UseCase;
import com.myMsaPayment.membership.adapter.out.persistence.MembershipJpaEntity;
import com.myMsaPayment.membership.adapter.out.persistence.MembershipMapper;
import com.myMsaPayment.membership.application.port.in.ModifyMembershipCommand;
import com.myMsaPayment.membership.application.port.in.ModifyMembershipUseCase;
import com.myMsaPayment.membership.application.port.out.ModifyMembershipPort;
import com.myMsaPayment.membership.application.port.out.RegisterMembershipPort;
import com.myMsaPayment.membership.domain.Membership;
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
