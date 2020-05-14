import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(LoginSmokeTest.class)
@Suite.SuiteClasses({KinoPoiskTest.class, OssuTest.class})
public class LoginSmokeTest {
}
