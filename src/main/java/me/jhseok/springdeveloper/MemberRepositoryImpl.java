// 예: 직접 구현한 커스텀 리포지토리 예시
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final EntityManager em;

    public MemberRepositoryImpl(EntityManager em) {
        this.em = em; // 직접 주입받아 사용
    }

    @Override
    public List<Member> findCustom() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }
}