package com.jm.portfolio.domain.authority.domain;

import com.jm.portfolio.domain.model.AuthorityEnum;
import com.jm.portfolio.global.common.base.domain.BaseDomain;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
@IdClass(UserRolePK.class)
@EqualsAndHashCode(of = {"userIdx", "authorityCode"}, callSuper = false)
@Getter
@NoArgsConstructor
public class UserRole extends BaseDomain {

    @Id
    @Column(name = "user_idx", updatable = false, nullable = false)
    private Long userIdx;

    @Id
    @Column(name = "authority_code", updatable = false, nullable = false)
    private String authorityCode;

    @ManyToOne
    @JoinColumn(name = "authority_code", insertable = false, updatable = false)
    private Authority authority;

    @Builder
    public UserRole(String createdIp, String lastUpdatedIp, Long userIdx, String authorityCode) {
        super(createdIp, lastUpdatedIp);
        this.userIdx = userIdx;
        this.authorityCode = authorityCode;
    }
}
