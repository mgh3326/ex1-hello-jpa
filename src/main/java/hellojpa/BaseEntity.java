package hellojpa;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {
  @Column(name = "INSERT_MEMBER")
  private String createBy;
  private LocalDateTime createdDate;
  @Column(name = "UPDATE_MEMBER")
  private String lastModifiedBy;
  private LocalDateTime lastModifiedDate;

  public String getCreateBy() {
    return createBy;
  }

  public void setCreateBy(String createBy) {
    this.createBy = createBy;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public String getLastModifiedBy() {
    return lastModifiedBy;
  }

  public void setLastModifiedBy(String lsatModifiedBy) {
    this.lastModifiedBy = lsatModifiedBy;
  }

  public LocalDateTime getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(LocalDateTime lsatModifiedDate) {
    this.lastModifiedDate = lsatModifiedDate;
  }
}
