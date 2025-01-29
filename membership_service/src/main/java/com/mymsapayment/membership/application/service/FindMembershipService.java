package com.mymsapayment.membership.application.service;

import com.mymsapayment.common.UseCase;
import com.mymsapayment.membership.adapter.out.persistence.MembershipJpaEntity;
import com.mymsapayment.membership.adapter.out.persistence.MembershipMapper;
import com.mymsapayment.membership.application.port.in.FindMembershipCommand;
import com.mymsapayment.membership.application.port.in.FindMembershipUseCase;
import com.mymsapayment.membership.application.port.out.FindMembershipPort;
import com.mymsapayment.membership.domain.Membership;
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
