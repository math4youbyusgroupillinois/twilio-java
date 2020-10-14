/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.accounts.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
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
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class AuthTokenPromotion extends Resource {
    private static final long serialVersionUID = 204657511452107L;

    /**
     * Create a AuthTokenPromotionUpdater to execute update.
     *
     * @return AuthTokenPromotionUpdater capable of executing the update
     */
    public static AuthTokenPromotionUpdater updater() {
        return new AuthTokenPromotionUpdater();
    }

    /**
     * Converts a JSON String into a AuthTokenPromotion object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return AuthTokenPromotion object represented by the provided JSON
     */
    public static AuthTokenPromotion fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AuthTokenPromotion.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a AuthTokenPromotion object using the
     * provided ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return AuthTokenPromotion object represented by the provided JSON
     */
    public static AuthTokenPromotion fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AuthTokenPromotion.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String authToken;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;

    @JsonCreator
    private AuthTokenPromotion(@JsonProperty("account_sid")
                               final String accountSid,
                               @JsonProperty("auth_token")
                               final String authToken,
                               @JsonProperty("date_created")
                               final String dateCreated,
                               @JsonProperty("date_updated")
                               final String dateUpdated,
                               @JsonProperty("url")
                               final URI url) {
        this.accountSid = accountSid;
        this.authToken = authToken;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
    }

    /**
     * Returns The SID of the Account that the secondary Auth Token was created for.
     *
     * @return The SID of the Account that the secondary Auth Token was created for
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The promoted Auth Token.
     *
     * @return The promoted Auth Token
     */
    public final String getAuthToken() {
        return this.authToken;
    }

    /**
     * Returns The ISO 8601 formatted date and time in UTC when the resource was
     * created.
     *
     * @return The ISO 8601 formatted date and time in UTC when the resource was
     *         created
     */
    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The ISO 8601 formatted date and time in UTC when the resource was
     * last updated.
     *
     * @return The ISO 8601 formatted date and time in UTC when the resource was
     *         last updated
     */
    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The URI for this resource, relative to `https://accounts.twilio.com`.
     *
     * @return The URI for this resource, relative to `https://accounts.twilio.com`
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AuthTokenPromotion other = (AuthTokenPromotion) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(authToken, other.authToken) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            authToken,
                            dateCreated,
                            dateUpdated,
                            url);
    }
}