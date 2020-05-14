import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(SearchSmokeTest.class)
@Suite.SuiteClasses({KannonDanceTest.class, KinoPoiskTest.class, OssuTest.class})
public class SearchSmokeTest {
}
