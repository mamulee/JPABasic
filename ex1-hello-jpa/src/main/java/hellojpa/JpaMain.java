package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        // 웹 서버, DB 당 하나만 생성 됨.
        // Thread 간 공유 하면 안 됨.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // code
        try {

            // INSERT
//            Member member = new Member();
//
//            member.setId(2L);
//            member.setName("HelloBR");
//            em.persist(member);

            // UPDATE
            // Member findMember = em.find(Member.class, 2L);
            // findMember.setName("HelloB");

            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }

            // em.persist(findMember); 를 할 필요 없음.

            // DELETE
            // em.remove(findMember);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
