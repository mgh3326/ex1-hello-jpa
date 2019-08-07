package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
    EntityManager em = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    try {
//팀 저장
      Team team = new Team();
      team.setName("TeamA");
      em.persist(team);
//회원 저장
      Member member = new Member();
      member.setName("member1");
      member.changeTeam(team); //단방향 연관관계 설정, 참조 저장
      em.persist(member);
team.addMember(member);

      em.flush();
      em.clear();

      Team findTeam = em.find(Team.class, team.getId());
      List<Member> members = findTeam.getMembers();
      for (Member m : members) {
        System.out.println("m : " + m.getName());
      }
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
    } finally {
      em.close();
    }
    entityManagerFactory.close();
  }
}
