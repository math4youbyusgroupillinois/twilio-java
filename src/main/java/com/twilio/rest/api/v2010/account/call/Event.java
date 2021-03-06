/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.call;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Event extends Resource {
    private static final long serialVersionUID = 85868637030157L;

    /**
     * Create a EventReader to execute read.
     *
     * @param pathAccountSid Account Sid.
     * @param pathCallSid Call Sid.
     * @return EventReader capable of executing the read
     */
    public static EventReader reader(final String pathAccountSid,
                                     final String pathCallSid) {
        return new EventReader(pathAccountSid, pathCallSid);
    }

    /**
     * Create a EventReader to execute read.
     *
     * @param pathCallSid Call Sid.
     * @return EventReader capable of executing the read
     */
    public static EventReader reader(final String pathCallSid) {
        return new EventReader(pathCallSid);
    }

    /**
     * Converts a JSON String into a Event object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Event object represented by the provided JSON
     */
    public static Event fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Event.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Event object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Event object represented by the provided JSON
     */
    public static Event fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Event.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final Map<String, Object> request;
    private final Map<String, Object> response;

    @JsonCreator
    private Event(@JsonProperty("request")
                  final Map<String, Object> request,
                  @JsonProperty("response")
                  final Map<String, Object> response) {
        this.request = request;
        this.response = response;
    }

    /**
     * Returns Call Request..
     *
     * @return Call Request.
     */
    public final Map<String, Object> getRequest() {
        return this.request;
    }

    /**
     * Returns Call Response with Events..
     *
     * @return Call Response with Events.
     */
    public final Map<String, Object> getResponse() {
        return this.response;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Event other = (Event) o;

        return Objects.equals(request, other.request) &&
               Objects.equals(response, other.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(request,
                            response);
    }
}