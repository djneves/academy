package com.ctw.workstation.team.entity;


import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.team_member.entity.TeamMember;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_TEAM")
public class Team extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teamIdGenerator")
    @SequenceGenerator(name = "teamIdGenerator", sequenceName = "SEQ_TEAM_ID")
    public Long id;

    @Column(name = "NAME", nullable = false)
    public String name;

    @Column(name = "PRODUCT", nullable = false)
    public String product;

    @Column(name = "DEFAULT_LOCATION", nullable = false)
    public String defaultLocation;

    @Column(name = "CREATED_AT")
    public Date createdAt;

    @Column(name = "MODIFIED_AT")
    public Date modifiedAt;

    // RACK
    @OneToMany(mappedBy = "teamId", fetch = FetchType.LAZY)
    public List<Rack> racks;

    // TEAM MEMBER
    @OneToMany(mappedBy = "teamId", fetch = FetchType.LAZY)
    public List<TeamMember> teamMembers;

}
