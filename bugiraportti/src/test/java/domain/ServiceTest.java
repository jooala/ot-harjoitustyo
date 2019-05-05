package domain;


import bugiraportti.Main;
import bugiraportti.dao.DBBugDao;
import bugiraportti.dao.DBUserDao;
import bugiraportti.domain.Bug;
import bugiraportti.domain.BugService;
import bugiraportti.domain.User;
import bugiraportti.domain.UserService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
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
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@SpringBootTest(classes = Main.class)
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("application-test.properties")
public class ServiceTest {

    private User u1;
    private static UserService service;
    private static BugService bugService;
    private static DBUserDao userdao;
    private static DBBugDao bugdao;
    private static GenericApplicationContext ctx;

    public ServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        ctx = new AnnotationConfigApplicationContext(Main.class);
        service = ctx.getBean(UserService.class);
        bugService = ctx.getBean(BugService.class);
        userdao = ctx.getBean(DBUserDao.class);
        bugdao = ctx.getBean(DBBugDao.class);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws SQLException {
        bugService.reportBug("otsikko", "tiivistelmä", 5, "jotain askeleita", "toivottu tulos", "oikea tulos");
        bugService.reportBug("aa", "toka", 9, "aa", "hello", "asddsa");
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
    public void rekisteröityminenPalauttaaFalseJaTrue() throws SQLException {
        assertEquals(service.register("esko", "hello"), true);
        assertEquals(service.register("esko", "hello"), false);
    }
    @Test
    public void palauttaaOikeanKirjaantuneen() throws SQLException {
        service.register("kokeilu", "uusi");
        service.login("uusi");
        assertEquals(service.getLoggedUser().getUsername(), "uusi");

    }

    @Test
    public void reportBugLuoBugin() throws SQLException {
        Bug bug = bugService.findBug(1);
        assertEquals("otsikko", bug.getTitle());
    }

    @Test
    public void saveBugToimii() throws SQLException {
        Bug bug = bugService.findBug(1);
        assertEquals(false, bug.getSolved());
        bugService.save(1, true);
        bug = bugService.findBug(1);
        assertEquals(true, bug.getSolved());
    }

    @Test
    public void oldBugJaPriorityBugToimii() throws SQLException {
        bugService.save(1, false);
        List<Bug> bugs = bugService.oldBug();
        assertEquals(1, bugs.get(0).getId());
        List<Bug> pbugs = bugService.priorityBug();
        assertEquals(2, pbugs.get(0).getId());
    }

    @Test
    public void listBugsToimii() throws SQLException {
        ObservableList<Bug> bugs = bugService.listBugs();
        assertEquals(1, bugs.get(0).getId());
        assertEquals("aa", bugs.get(1).getTitle());
    }
    
    @Test
    public void deleteToimiiKummassakinDaossa() throws SQLException {
        User user = new User("taas", "täällä");
        userdao.create(user);
        assertEquals(userdao.findByUsername("täällä").getName(), "taas");
        userdao.delete(userdao.findByUsername("täällä").getId());
        assertEquals(userdao.findByUsername("täällä"), null);
        Bug bug = new Bug("jaa", "kek", 10, "jee", "world", "hello", false);
        bugdao.create(bug);
        assertEquals(bugdao.findPriority().get(0).getPriority(), 10);
        bugdao.delete(bugdao.findPriority().get(0).getId());
        assertEquals(bugdao.findPriority().get(0).getPriority(), 9);
    }
    
    @Test
    public void bugUpdateToimii() throws SQLException {
        assertEquals(bugdao.read(1).getTitle(), "otsikko");
        Bug bug = bugdao.read(1);
        bug.setTitle("mita");
        bugdao.update(bug);
        assertEquals(bugdao.read(1).getTitle(), "mita");
    }
    
    @Test
    public void listUserToimii() throws SQLException {
        User user = new User("hello" , "world");
        userdao.create(user);
        assertEquals(userdao.list().get(2).getName(), "hello");
    }
    
    @Test 
    public void readUserToimii() throws SQLException {
        User user = new User("aaa", "demo");
        userdao.create(user);
        assertEquals(userdao.read(1).getId(), 1);
    }
    
    @Test
    public void updateUserToimii() throws SQLException {
        User user = userdao.read(1);
        assertEquals(userdao.read(1).getName(), "aaa");
        user.setName("late");
        userdao.update(user);
        assertEquals(userdao.read(1).getName(), "late");
    }
 }
