
import bugiraportti.Main;
import bugiraportti.dao.DBUserDao;
import bugiraportti.domain.User;
import bugiraportti.domain.UserService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Main.class)
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("application-test.properties")
public class UserServiceTest {

    private User u1;
    private static UserService service;
    private static GenericApplicationContext ctx;

    public UserServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        ctx = new AnnotationConfigApplicationContext(Main.class);
        service = ctx.getBean(UserService.class);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void kirjautuminenToimiiRekisteröitymisenJälkeen() throws SQLException {
        assertEquals(service.login("matti"), false);
        service.register("testi", "matti");
        assertEquals(service.login("matti"), true);
        service.logout();
    }

    @Test
    public void palauttaaOikeanKirjaantuneen() throws SQLException {
        service.register("kokeilu", "uusi");
        service.login("uusi");
        assertEquals(service.getLoggedUser().getUsername(), "uusi");

    }

}
