package com.myMsaPayment.membership.application.port.in;

import com.myMsaPayment.membership.domain.Membership;




public interface RegisterMembershipUseCase {

    Membership registerMembership(RegisterMembershipCommand command);


}
