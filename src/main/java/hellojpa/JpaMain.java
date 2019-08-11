package hellojpa;

import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
    EntityManager em = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    try {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Member> query = cb.createQuery(Member.class);
      Root<Member> m = query.from(Member.class);
      CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
      List<Member> resultList = em.createQuery(cq).getResultList();
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
    } finally {
      em.close();
    }
    entityManagerFactory.close();
  }


}
