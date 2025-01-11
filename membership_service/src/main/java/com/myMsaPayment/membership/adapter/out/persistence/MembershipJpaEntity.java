package com.myMsaPayment.membership.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Table(name = "membership")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MembershipJpaEntity {

    @Id
    @GeneratedValue
    private Long membershipId;

    private String name;

    private String address;

    private String email;

    private boolean isValid;

    private String aggregateIdentifier;

    public MembershipJpaEntity(String name, String address, String email, boolean isValid, String aggregateIdentifier) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.isValid = isValid;
        this.aggregateIdentifier = aggregateIdentifier;
    }


}
