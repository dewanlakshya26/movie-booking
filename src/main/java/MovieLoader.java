
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;


class MovieLoader {
    static Map<String, Enums.TicketType> audi1 = new HashMap<>();
    static Map<String, Enums.TicketType> audi2 = new HashMap<>();
    static Map<String, Enums.TicketType> audi3 = new HashMap<>();

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
        Enums.ShowNumber[] showNo = Enums.ShowNumber.values();
        for (Enums.ShowNumber show : showNo) {
            String audiNumber = show.getAudiNo();
            JSONObject showseats = (JSONObject) showList.get(audiNumber);
            loadSeat(showseats, show);
        }
    }

    private void loadSeat(JSONObject movieObject, Enums.ShowNumber show) {
        switch (show) {
            case AUDI1:
                audi1.putAll(loadSeatsInAudi(movieObject, audi1));
            case AUDI2:
                audi2.putAll(loadSeatsInAudi(movieObject, audi2));
            case AUDI3:
                audi3.putAll(loadSeatsInAudi(movieObject, audi3));
        }


    }

    private Map<String, Enums.TicketType> loadSeatsInAudi(JSONObject movieObject, Map<String, Enums.TicketType> audi) {
        EnumSet.allOf(Enums.TicketType.class).forEach((category) ->
            loadSeatWithCategory(audi, (String) movieObject.get(category.name()),category));
        return audi;
    }

    private Map<String, Enums.TicketType> loadSeatWithCategory(Map<String, Enums.TicketType> audi, String platinumMovie, Enums.TicketType ticketType) {
        String[] platinumMovieList = platinumMovie.split(",");
        for (String platinumSeat : platinumMovieList
        ) {
            audi.put(platinumSeat, ticketType);
        }
        return audi;
    }


}






