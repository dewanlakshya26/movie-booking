package com.booking.movieProcessor;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertFalse;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MovieLoaderTest {

    private MovieLoader movieLoaderInstance;

    @BeforeAll
    void init(){
        movieLoaderInstance = new MovieLoader();
    }


    @Test
    @DisplayName("should load movies when we create instance of Loader class")
    void loadMoviesWithCategories(){
        JSONObject dummyJsonObject = (JSONObject) new JSONObject().put("1","{\n" +
                "    \"PLATINUM\": \"A1,A2,A3,A4,A5,A6,A7,A8,A9\",\n" +
                "    \"GOLD\": \"B1,B2,B3,B4,B5,B6\",\n" +
                "    \"SILVER\": \"C2,C3,C4,C5,C6,C7\"\n" +
                "  }");
        assertFalse(MovieLoader.audi1.isEmpty());
    }

    @Test
    @DisplayName("load seat into second auditrium when called")
    void fillSecondAuditorium(){
        JSONObject dummyJsonObject = (JSONObject) new JSONObject().put("2","{\n" +
                "    \"PLATINUM\": \"A1,A2,A3,A4,A5,A6,A7,A8,A9\",\n" +
                "    \"GOLD\": \"B1,B2,B3,B4,B5,B6\",\n" +
                "    \"SILVER\": \"C2,C3,C4,C5,C6,C7\"\n" +
                "  }");
        assertFalse(MovieLoader.audi2.isEmpty());
    }

}
