
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import static enums.Enums.*;
import java.io.*;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;


class MovieLoader {
    static Map<String, TicketType> audi1 = new HashMap<>();
    static Map<String, TicketType> audi2 = new HashMap<>();
    static Map<String, TicketType> audi3 = new HashMap<>();

    public MovieLoader() {
        loadMovieFromSeed();
    }

    void loadMovieFromSeed() {
        JSONParser jsonParser = new JSONParser();

        String showListPath = new File("").getAbsolutePath()+"/src/main/resources/movie-list.json";
        try (FileReader reader = new FileReader(showListPath)) {
            Object obj = jsonParser.parse(reader);
            JSONObject showList = (JSONObject) obj;

            loadSeatsPerAudi(showList);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

    private void loadSeatsPerAudi(JSONObject showList) {
        ShowNumber[] showNo = ShowNumber.values();
        for (ShowNumber show : showNo) {
            String audiNumber = show.getAudiNo();
            JSONObject showseats = (JSONObject) showList.get(audiNumber);
            loadSeat(showseats, show);
        }
    }

    private void loadSeat(JSONObject movieObject, ShowNumber show) {
        switch (show) {
            case AUDI1:
                audi1.putAll(loadSeatsInAudi(movieObject, audi1));
            case AUDI2:
                audi2.putAll(loadSeatsInAudi(movieObject, audi2));
            case AUDI3:
                audi3.putAll(loadSeatsInAudi(movieObject, audi3));
        }


    }

    private Map<String, TicketType> loadSeatsInAudi(JSONObject movieObject, Map<String, TicketType> audi) {
        EnumSet.allOf(TicketType.class).forEach((category) ->
            loadSeatWithCategory(audi, (String) movieObject.get(category.name()),category));
        return audi;
    }

    private Map<String, TicketType> loadSeatWithCategory(Map<String, TicketType> audi, String platinumMovie, TicketType ticketType) {
        String[] platinumMovieList = platinumMovie.split(",");
        for (String platinumSeat : platinumMovieList
        ) {
            audi.put(platinumSeat, ticketType);
        }
        return audi;
    }


}






