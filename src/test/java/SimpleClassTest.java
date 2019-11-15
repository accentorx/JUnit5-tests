import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

class SimpleClassTest {

    SimpleClass simpleClass;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter){

        this.testInfo = testInfo;
        this.testReporter = testReporter;

        simpleClass = new SimpleClass();
    }

    @Nested
    class AddTest{

        @Test
        @DisplayName("Testing add method")
        @Tag("Math")
        void testAdd(){

            int expected = 2;
            int actual = simpleClass.add(1, 1);
            assertEquals(expected, actual, "hello from fail");

            testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tag " + testInfo.getTags());
        }
    }


    @AfterEach
    void cleanup(){

        System.out.println("hello from @AfterEach annotation");
    }

    @BeforeAll
    static void beforeAllInit(){

        System.out.println("Start testing");
    }

    @AfterAll
    static void afterAllInit(){

        System.out.println("End of testing");
    }



    @Test
    @DisplayName("Testing divide method")
    void testDivide(){

        assertThrows(ArithmeticException.class, () -> simpleClass.divide(1, 0), "divide by zero should throw");
    }

    @RepeatedTest(3)
    @DisplayName("Testing exceptions")
    void testExceptionThrow(){

        assertThrows(RuntimeException.class, () -> simpleClass.exceptionThrow());
    }

    @Test
    @Disabled
    @DisplayName("This method is disabled")
    void methodForFailingTesting(){
        fail();
    }

    @Test
    @DisplayName("Multiply method")
    void testMultiply(){

        assertAll(
                () -> assertThrows(RuntimeException.class, () -> simpleClass.exceptionThrow()),
                () ->assertThrows(ArithmeticException.class, () -> simpleClass.divide(1, 0))
        );
    }


    @Test
    void testAssume(){
        boolean isTrue = true;

        assumeTrue(isTrue);
        System.out.println("Variable isTrue is true");
    }

    @RepeatedTest(10)
    @DisplayName("Testing generated value of method")
    void testGenerateRandom(){

        SimpleClass simpleClass2 = new SimpleClass();

        int unexpected = 2;
        int actual = simpleClass2.generateRandom( 10);

        assertNotEquals(unexpected, actual, () -> "the actual number is " + actual);
        System.out.println("Actual number is " + actual);
    }
}