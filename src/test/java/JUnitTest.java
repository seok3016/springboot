import org.junit.jupiter.api.*;

public class JUnitTest {
    @DisplayName("1 + 2는 3이다")
    @Test
    public void junitTest() {
        int a = 1;
        int b = 2;
        int sum = 3;
        Assertions.assertEquals(sum, a + b); // 값이 같은지 확인
    }

    @DisplayName("1 + 3는 3이다.")
    @Test
    public void junitFailedTest() {
        int a = 1;
        int b = 3;
        int sum = 3;
        Assertions.assertEquals(sum, a + b);
    }
    @BeforeEach
    public void prepare(){
        System.out.println("준비");
    }
    @AfterEach
    public void cleanup(){
        System.out.println("설겆이");
    }

    @BeforeAll
    public static void prepareAll(){
        System.out.println("최초준비");
    }

    @AfterAll
    public static void cleanupAll(){
        System.out.println("최종마무리");
    }
}

//beaforeall 과 AfterAll은 모두 static이여야 한다