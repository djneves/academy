package com.ctw.workstation.rack.entity;


import com.ctw.workstation.Status;
import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.rack_asset.entity.RackAsset;
import com.ctw.workstation.team.entity.Team;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_RACK")
public class Rack extends PanacheEntityBase {
    public static final String GET_ALL = "Rack.getAll";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rackIdGenerator")
    @SequenceGenerator(name = "rackIdGenerator", sequenceName = "SEQ_RACK_ID")
    public Long id;

    @Column(name = "SERIAL_NUMBER", length = 20, nullable = false)
    public String serialNumber;

    @Transient
    public Integer age;

    @Column(name = "ASSEMBLED_AT")
    public Date assembledAt;

    @Column(name = "CREATED_AT")
    public Date createdAt;

    @Column(name = "MODIFIED_AT")
    public Date modifiedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    public Status status;

    @Column(name = "DEFAULT_LOCATION", nullable = false)
    public String defaultLocation;

    @Column(name = "TEAM_ID", nullable = false)
    public Long teamId;

    // TEAM
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID", updatable = false, insertable = false, nullable = false)
    public Team team;

    // ASSET
    @OneToMany(mappedBy = "rack", fetch = FetchType.LAZY)
    public List<RackAsset> rackAssets;

    // BOOKING
    @OneToMany(mappedBy = "rack", fetch = FetchType.LAZY)
    public List<Booking> bookings;

/**
 public Long getId() {
 return id;
 }

 public void setId(Long id) {
 this.id = id;
 }

 public String getSerialNumber() {
 return serialNumber;
 }

 public void setSerialNumber(String serialNumber) {
 this.serialNumber = serialNumber;
 }

 public Integer getAge() {
 return age;
 }

 public void setAge(Integer age) {
 this.age = age;
 }

 public Date getAssembledAt() {
 return assembledAt;
 }

 public void setAssembledAt(Date assembledAt) {
 this.assembledAt = assembledAt;
 }

 public Status getStatus() {
 return status;
 }

 public void setStatus(Status status) {
 this.status = status;
 }

 public Long getTeamId() {
 return teamId;
 }

 public void setTeamId(Long teamId) {
 this.teamId = teamId;
 }

 public Team getTeam() {
 return team;
 }

 public void setTeam(Team team) {
 this.team = team;
 }

 public List<RackAsset> getRackAssets() {
 return rackAssets;
 }

 public void setRackAssets(List<RackAsset> rackAssets) {
 this.rackAssets = rackAssets;
 }

 public List<Booking> getBookings() {
 return bookings;
 }

 public void setBookings(List<Booking> bookings) {
 this.bookings = bookings;
 }**/
}
