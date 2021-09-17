package amazing;

public class AmazingUnitTest {

    private static boolean success = true;

    public static void main(String[] args) {
        // (1) failing assertTrue should set state to failed
        assertTrue(false);
        // assert: will sehen Red
        if (success) {
            System.out.println("Green");
        } else {
            System.out.println("expected: Red");
        }

        // (2) success assertTrue should set state to true
        assertTrue(true);
        // assert: will Green
        if (success) {
            System.out.println("expected: Green");
        } else {
            System.out.println("Red");
        }
    }

    private static void assertTrue(boolean b) {
        success = b;
    }
}

/*
 * Test List
 * - assertTrue
 * - assertEqual
 * - define test, find test, run test
 * - fixtures (before, after)
 */
