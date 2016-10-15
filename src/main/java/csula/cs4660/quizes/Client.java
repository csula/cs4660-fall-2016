package csula.cs4660.quizes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import csula.cs4660.quizes.models.DTO;
import csula.cs4660.quizes.models.State;

import java.io.IOException;
import java.util.Optional;

/**
 * Quiz 2 Java client to handle request and response
 */
public class Client {
    private static final String SERVER_URL = "http://159.203.227.70:9000";

    static {
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                = new com.fasterxml.jackson.databind.ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public static Optional<State> getState(String id) {
        HttpResponse<State> response = null;
        try {
            response = Unirest.post(String.format("%s/getState", SERVER_URL))
                .body(new DTO().setId(id))
                .asObject(State.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (response != null) {
            return Optional.ofNullable(response.getBody());
        } else {
            return Optional.empty();
        }
    }

    public static Optional<DTO> stateTransition(String id, String action) {
        HttpResponse<DTO> response = null;
        try {
            response = Unirest.post(String.format("%s/state", SERVER_URL))
                .body(new DTO().setId(id).setAction(action))
                .asObject(DTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (response != null) {
            return Optional.ofNullable(response.getBody());
        } else {
            return Optional.empty();
        }
    }
}
