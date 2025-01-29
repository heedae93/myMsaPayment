package com.mymsapayment.membership.application.port.in;

import com.mymsapayment.membership.domain.Membership;




public interface RegisterMembershipUseCase {

    Membership registerMembership(RegisterMembershipCommand command);


}
