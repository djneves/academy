package com.ctw.workstation.team_member.entity;


import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.team.entity.Team;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_TEAM_MEMBER")
public class TeamMember extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teamMemberIdGenerator")
    @SequenceGenerator(name = "teamMemberIdGenerator", sequenceName = "SEQ_TEAM_MEMBER_ID")
    public Long id;

    @Column(name = "TEAM_ID", nullable = false)
    public Long teamId;

    @Column(name = "CTW_ID", length = 10, nullable = false)
    public String ctwId;

    @Column(name = "NAME", nullable = false)
    public String name;

    @Column(name = "CREATED_AT")
    public Date createdAt;

    @Column(name = "MODIFIED_AT")
    public Date modifiedAt;

    // TEAM
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID", updatable = false, insertable = false, nullable = false)
    public Team team;

    // BOOKING
    @OneToMany(mappedBy = "requesterId", fetch = FetchType.LAZY)
    public List<Booking> bookings;

}
