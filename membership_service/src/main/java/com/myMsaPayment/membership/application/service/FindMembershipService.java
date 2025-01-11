package com.myMsaPayment.membership.application.service;

import com.myMsaPayment.common.UseCase;
import com.myMsaPayment.membership.adapter.out.persistence.MembershipJpaEntity;
import com.myMsaPayment.membership.adapter.out.persistence.MembershipMapper;
import com.myMsaPayment.membership.application.port.in.FindMembershipCommand;
import com.myMsaPayment.membership.application.port.in.FindMembershipUseCase;
import com.myMsaPayment.membership.application.port.out.FindMembershipPort;
import com.myMsaPayment.membership.domain.Membership;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@UseCase
@Transactional
public class FindMembershipService implements FindMembershipUseCase {

    private FindMembershipPort findMembershipPort;
    private final MembershipMapper  membershipMapper;
    @Override
    public Membership findMembership(FindMembershipCommand findMembershipCommand) {
        MembershipJpaEntity membershipJpaEntity =  findMembershipPort.findMembership(new Membership.MembershipId(findMembershipCommand.getMembershipId()));
        return membershipMapper.mapToDomainEntity(membershipJpaEntity);
    }
}
