import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class WeatherTest {

    private final String url="https://api.openweathermap.org/data/2.5";
    private final String key="6a8619ae65a31734d3eee5ccfa69efa1";

    @Before
    public void setSpec() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(url)
                .addParam("APPID",key)
                 .build();
        RestAssured.responseSpecification=new ResponseSpecBuilder()
                 .expectStatusCode(200)
                 .build();
    }

    @Test
    public void test1(){
        given()
                 .param("q","Saint Petersburg")
                 .get("/weather")
                 .then()
                 .assertThat()
                 .body("id", equalTo(498817),
                          "coord.lon",equalTo(30.26f),
                          "coord.lat", equalTo(59.89f),
                          "name", equalTo("Saint Petersburg"));


    }

    @Test
    public void test2(){
        given()
                 .param("bbox","28,45,30,49,10")
                 .when()
                 .get("box/city")
                 .then()
                 .assertThat()
                 .body("cnt", equalTo(29),
                          "list[0].name", equalTo("Chisinau"));
    }
}
