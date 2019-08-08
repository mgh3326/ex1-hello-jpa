package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
    EntityManager em = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    try {
      Member member = new Member();
      member.setName("kwanghyun");

      member.setCreateBy("Kim");
      member.setCreatedDate(LocalDateTime.now());
      em.persist(member);
      em.flush();
      em.clear();

      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
    } finally {
      em.close();
    }
    entityManagerFactory.close();
  }
}
