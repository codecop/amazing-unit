package amazing;

public class AmazingUnitTest {

    private static boolean success = true;

    public static void main(String[] args) {
        // (1) failing assertTrue should set state to failed
        beforeTest();
        
        assertTrue(false);
        // assert: will sehen Red
        success = !success;
        
        reportTestState();

        // (2) success assertTrue should set state to true
        beforeTest();
        
        assertTrue(true);
        
        // assert: will Green
        reportTestState();

        // (3) failed followed by success should leave state to false.
        beforeTest();
        
        assertTrue(false);
        assertTrue(true);
        // assert: will sehen Red
        success = !success;

        reportTestState();
    }

    private static void reportTestState() {
        if (success) {
            System.out.println("Green");
        } else {
            System.out.println("Red");
        }
    }

    private static void beforeTest() {
        success = true;
    }
    
    private static void assertTrue(boolean b) {
        success = success && b;
    }
}

/*
 * Test List
 * - assertTrue
 * - assertEqual
 * - define test, find test, run test
 * - fixtures (before, after)
 */
