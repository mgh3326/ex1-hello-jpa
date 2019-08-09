package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
    EntityManager em = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    try {
      Child child1 = new Child();
      Child child2 = new Child();
      Parent parent = new Parent();
      parent.addChild(child1);
      parent.addChild(child2);
      em.persist(parent);
      em.persist(child1);
      em.persist(child2);
      em.flush();
      em.clear();

      Parent findParent = em.find(Parent.class, parent.getId());
      em.remove(findParent);
//      findParent.getChildList().remove(0);

//      em.persist(child1);
//      em.persist(child2);
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
    } finally {
      em.close();
    }
    entityManagerFactory.close();
  }


}
