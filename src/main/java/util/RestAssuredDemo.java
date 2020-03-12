package util;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredDemo {

    @Test
    public void testXueqin(){
        given().proxy("127.0.0.1",8888)
                .log().all().queryParam("code","sogo")
                .header("Cookie","aliyungf_tc=AQAAACOVpAyV/gQAw5iet0x5kLi2khDh; acw_tc=2760820515839923083374616e2c4b8cd3eadd71a9c902e77ddedc2fc79ffd; xq_a_token=a664afb60c7036c7947578ac1a5860c4cfb6b3b5; xqat=a664afb60c7036c7947578ac1a5860c4cfb6b3b5; xq_r_token=01d9e7361ed17caf0fa5eff6465d1c90dbde9ae2; xq_id_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1aWQiOi0xLCJpc3MiOiJ1YyIsImV4cCI6MTU4NTM2MjYwNywiY3RtIjoxNTgzOTkyMjYxODY1LCJjaWQiOiJkOWQwbjRBWnVwIn0.K2Xhdry4pMvj0zOOCJDEkhJNjakC4W3f_b80KWf9Fp0QqDlxMi8nutxHzqwhm9D_BhqxvcMGGE9EyEUFgGekJvcXczd1ZvYEmyCVSks0Kl9b89Nj3uQtCX3b5bkgXzkPxDJxvrI6SKrahYmrxSywk-59f8V08Qn6nVz0kH8OdO_FMMTE992MyBP9uOO4uwfI-TNKk9hNPFwa-jcwMHPkGxckBQhB8wMmKANUtfL2X0O1GbYOn56WtVBmMjcAh8FZNIO4Qk4o8W8c1-2MkHBw7TpRnGoC_i_otb5VwYP59CXs4hysoyMW3d0nQSE9SaW_OQC1LMlaHUKyQXxvOHzNIQ; u=531583992308344; cookiesu=321583992310013; Hm_lvt_1db88642e346389874251b5a1eded6e3=1583992298; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1583992310; device_id=24700f9f1986800ab4fcc880530dd0ed")
                .when().get("https://xueqiu.com/stock/search.json")
                .then().log().all().statusCode(200)
        .body("stocks[0].code",equalTo("SOGO"))
        .body("stocks[0].name",equalTo("搜狗"));
    }
}
