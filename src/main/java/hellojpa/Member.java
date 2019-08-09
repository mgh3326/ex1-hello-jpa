package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Member {
  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "USERNAME")
  private String username;


  //기간 Period
  @Embedded
  private Period workPeriod;

  //주소
  @Embedded
  private Address homeAddress;
  @ElementCollection
  @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
  @JoinColumn(name = "MEMBER_ID"))
  @Column(name = "FOOD_NAME")
  private Set<String> favoriteFoods = new HashSet<>();

  //  @ElementCollection
//  @CollectionTable(name = "ADDRESS", joinColumns =
//  @JoinColumn(name = "MEMBER_ID"))
//  private List<Address> addressHistory = new ArrayList<>();
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "MEMBER_ID")
  private List<AddressEntity> addressHistory = new ArrayList<>();

  // @Column(name = "TEAM_ID")
// private Long teamId;
//  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "TEAM_ID")
//  private Team team;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Period getWorkPeriod() {
    return workPeriod;
  }

  public void setWorkPeriod(Period workPeriod) {
    this.workPeriod = workPeriod;
  }

  public Address getHomeAddress() {
    return homeAddress;
  }

  public void setHomeAddress(Address homeAddress) {
    this.homeAddress = homeAddress;
  }

  public Set<String> getFavoriteFoods() {
    return favoriteFoods;
  }

  public void setFavoriteFoods(Set<String> favoriteFoods) {
    this.favoriteFoods = favoriteFoods;
  }

  public List<AddressEntity> getAddressHistory() {
    return addressHistory;
  }

  public void setAddressHistory(List<AddressEntity> addressHistory) {
    this.addressHistory = addressHistory;
  }
}
