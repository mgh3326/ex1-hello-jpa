package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    try {
//      Member member = entityManager.find(Member.class, 1L);
//      member.setName("HelloJPA");
//      entityManager.persist(member);
      List<Member> resultList = entityManager.createQuery("select  m from Member as m", Member.class)
              .setFirstResult(1)
              .setMaxResults(10)
              .getResultList();
      for (Member member : resultList) {
        System.out.println("member.name = " + member.getName());
      }
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
    } finally {
      entityManager.close();
    }
    entityManagerFactory.close();
  }
}
