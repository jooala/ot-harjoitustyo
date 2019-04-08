import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import bugiraportti.domain.User;

public class UserTest {

    User user;

    public UserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        user = new User(1, "test", "demo");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstuktoriAsettaaOikein() {
        assertEquals(1, user.getId());
        assertEquals("test", user.getName());
        assertEquals("demo", user.getUsername());
        user = new User("toinen", "testi");
        assertEquals("toinen", user.getName());
        assertEquals("testi", user.getUsername());
    }

    @Test
    public void userIlmanKonstruktoria() {
        user = new User();
        assertEquals(0, user.getId());
        assertEquals(null, user.getName());
        assertEquals(null, user.getUsername());
    }

    @Test
    public void setteritToimii() {
        user.setId(2);
        user.setName("uusi");
        user.setUsername("minä");
        assertEquals(2, user.getId());
        assertEquals("uusi", user.getName());
        assertEquals("minä", user.getUsername());
    }
}
