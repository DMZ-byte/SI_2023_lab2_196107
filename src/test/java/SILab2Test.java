import org.junit.Test;
import static org.junit.Assert.*;

public class SILab2Test {
    @Test
    public void testEveryBranchCriterion() {

        assertTrue(function(null, null));
        assertTrue(function(null, "password", "example@example.com"));
        assertTrue(function(new User(), null, null));
        assertTrue(function(new User(), null, "example@example.com"));
        assertTrue(function(new User(), "password", null));
        assertFalse(function(new User(), "password", "example@example.com"));
        assertFalse(function(new User(), "password", "example@example.com", null));
        assertFalse(function(new User(), "password", "example@example.com", null, null));
        assertFalse(function(new User(), "password", "example@example.com", "example", null));
        assertFalse(function(new User(), "password", "example@example.com", "example", [User1]));
        assertFalse(function(new User(), "password", "example@example.com", "example", [User1, User2]));
        assertFalse(function(new User(), "password", "example@example.com", "example", null, [User1]));
        assertFalse(function(new User(), "password", "example@example.com", "example", null, [User1, User2]));
    }
    @Test
    public void testMultipleConditionCriterion() {

        assertTrue(function(0, 0, 0));
        assertTrue(function(0, 1, 1));
        assertTrue(function(1, 0, 0));
        assertTrue(function(1, 0, 1));
        assertTrue(function(1, 1, 0));
        assertFalse(function(1, 1, 1));
    }
}
