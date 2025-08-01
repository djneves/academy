package com.ctw.workstation.booking.entity;


import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.team_member.entity.TeamMember;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "T_BOOKING")
public class Booking extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookingIdGenerator")
    @SequenceGenerator(name = "bookingIdGenerator", sequenceName = "SEQ_BOOKING_ID")
    public Long id;

    @Column(name = "RACK_ID", nullable = false)
    public Long rackId;

    @Column(name = "REQUESTER_ID", nullable = false)
    public Long requesterId;

    @Column(name = "BOOK_FROM")
    public Date bookFrom;

    @Column(name = "BOOK_TO")
    public Date bookTo;

    @Column(name = "CREATED_AT")
    public Date createdAt;

    @Column(name = "MODIFIED_AT")
    public Date modifiedAt;

    // RACK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RACK_ID", updatable = false, insertable = false, nullable = false)
    public Rack rack;

    // TEAM MEMBER
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REQUESTER_ID", updatable = false, insertable = false, nullable = false)
    public TeamMember teamMember;


}
