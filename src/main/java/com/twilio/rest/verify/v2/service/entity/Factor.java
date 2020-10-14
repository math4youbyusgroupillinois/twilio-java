/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.verify.v2.service.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
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

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Factor extends Resource {
    private static final long serialVersionUID = 201328569010526L;

    public enum FactorStatuses {
        UNVERIFIED("unverified"),
        VERIFIED("verified");

        private final String value;

        private FactorStatuses(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a FactorStatuses from a string.
         * @param value string value
         * @return generated FactorStatuses
         */
        @JsonCreator
        public static FactorStatuses forValue(final String value) {
            return Promoter.enumFromString(value, FactorStatuses.values());
        }
    }

    public enum FactorTypes {
        PUSH("push");

        private final String value;

        private FactorTypes(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a FactorTypes from a string.
         * @param value string value
         * @return generated FactorTypes
         */
        @JsonCreator
        public static FactorTypes forValue(final String value) {
            return Promoter.enumFromString(value, FactorTypes.values());
        }
    }

    public enum NotificationPlatforms {
        APN("apn"),
        FCM("fcm");

        private final String value;

        private NotificationPlatforms(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a NotificationPlatforms from a string.
         * @param value string value
         * @return generated NotificationPlatforms
         */
        @JsonCreator
        public static NotificationPlatforms forValue(final String value) {
            return Promoter.enumFromString(value, NotificationPlatforms.values());
        }
    }

    /**
     * Create a FactorCreator to execute create.
     *
     * @param pathServiceSid Service Sid.
     * @param pathIdentity Unique external identifier of the Entity
     * @param friendlyName The friendly name of this Factor
     * @param factorType The Type of this Factor
     * @return FactorCreator capable of executing the create
     */
    public static FactorCreator creator(final String pathServiceSid,
                                        final String pathIdentity,
                                        final String friendlyName,
                                        final Factor.FactorTypes factorType) {
        return new FactorCreator(pathServiceSid, pathIdentity, friendlyName, factorType);
    }

    /**
     * Create a FactorDeleter to execute delete.
     *
     * @param pathServiceSid Service Sid.
     * @param pathIdentity Unique external identifier of the Entity
     * @param pathSid A string that uniquely identifies this Factor.
     * @return FactorDeleter capable of executing the delete
     */
    public static FactorDeleter deleter(final String pathServiceSid,
                                        final String pathIdentity,
                                        final String pathSid) {
        return new FactorDeleter(pathServiceSid, pathIdentity, pathSid);
    }

    /**
     * Create a FactorFetcher to execute fetch.
     *
     * @param pathServiceSid Service Sid.
     * @param pathIdentity Unique external identifier of the Entity
     * @param pathSid A string that uniquely identifies this Factor.
     * @return FactorFetcher capable of executing the fetch
     */
    public static FactorFetcher fetcher(final String pathServiceSid,
                                        final String pathIdentity,
                                        final String pathSid) {
        return new FactorFetcher(pathServiceSid, pathIdentity, pathSid);
    }

    /**
     * Create a FactorReader to execute read.
     *
     * @param pathServiceSid Service Sid.
     * @param pathIdentity Unique external identifier of the Entity
     * @return FactorReader capable of executing the read
     */
    public static FactorReader reader(final String pathServiceSid,
                                      final String pathIdentity) {
        return new FactorReader(pathServiceSid, pathIdentity);
    }

    /**
     * Create a FactorUpdater to execute update.
     *
     * @param pathServiceSid Service Sid.
     * @param pathIdentity Unique external identifier of the Entity
     * @param pathSid A string that uniquely identifies this Factor.
     * @return FactorUpdater capable of executing the update
     */
    public static FactorUpdater updater(final String pathServiceSid,
                                        final String pathIdentity,
                                        final String pathSid) {
        return new FactorUpdater(pathServiceSid, pathIdentity, pathSid);
    }

    /**
     * Converts a JSON String into a Factor object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Factor object represented by the provided JSON
     */
    public static Factor fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Factor.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Factor object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Factor object represented by the provided JSON
     */
    public static Factor fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Factor.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String serviceSid;
    private final String entitySid;
    private final String identity;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String friendlyName;
    private final Factor.FactorStatuses status;
    private final Factor.FactorTypes factorType;
    private final Map<String, Object> config;
    private final URI url;

    @JsonCreator
    private Factor(@JsonProperty("sid")
                   final String sid,
                   @JsonProperty("account_sid")
                   final String accountSid,
                   @JsonProperty("service_sid")
                   final String serviceSid,
                   @JsonProperty("entity_sid")
                   final String entitySid,
                   @JsonProperty("identity")
                   final String identity,
                   @JsonProperty("date_created")
                   final String dateCreated,
                   @JsonProperty("date_updated")
                   final String dateUpdated,
                   @JsonProperty("friendly_name")
                   final String friendlyName,
                   @JsonProperty("status")
                   final Factor.FactorStatuses status,
                   @JsonProperty("factor_type")
                   final Factor.FactorTypes factorType,
                   @JsonProperty("config")
                   final Map<String, Object> config,
                   @JsonProperty("url")
                   final URI url) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.entitySid = entitySid;
        this.identity = identity;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.friendlyName = friendlyName;
        this.status = status;
        this.factorType = factorType;
        this.config = config;
        this.url = url;
    }

    /**
     * Returns A string that uniquely identifies this Factor..
     *
     * @return A string that uniquely identifies this Factor.
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns Account Sid..
     *
     * @return Account Sid.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns Service Sid..
     *
     * @return Service Sid.
     */
    public final String getServiceSid() {
        return this.serviceSid;
    }

    /**
     * Returns Entity Sid..
     *
     * @return Entity Sid.
     */
    public final String getEntitySid() {
        return this.entitySid;
    }

    /**
     * Returns Unique external identifier of the Entity.
     *
     * @return Unique external identifier of the Entity
     */
    public final String getIdentity() {
        return this.identity;
    }

    /**
     * Returns The date this Factor was created.
     *
     * @return The date this Factor was created
     */
    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The date this Factor was updated.
     *
     * @return The date this Factor was updated
     */
    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns A human readable description of this resource..
     *
     * @return A human readable description of this resource.
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The Status of this Factor.
     *
     * @return The Status of this Factor
     */
    public final Factor.FactorStatuses getStatus() {
        return this.status;
    }

    /**
     * Returns The Type of this Factor.
     *
     * @return The Type of this Factor
     */
    public final Factor.FactorTypes getFactorType() {
        return this.factorType;
    }

    /**
     * Returns The config.
     *
     * @return The config
     */
    public final Map<String, Object> getConfig() {
        return this.config;
    }

    /**
     * Returns The URL of this resource..
     *
     * @return The URL of this resource.
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

        Factor other = (Factor) o;

        return Objects.equals(sid, other.sid) &&
               Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(serviceSid, other.serviceSid) &&
               Objects.equals(entitySid, other.entitySid) &&
               Objects.equals(identity, other.identity) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(friendlyName, other.friendlyName) &&
               Objects.equals(status, other.status) &&
               Objects.equals(factorType, other.factorType) &&
               Objects.equals(config, other.config) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            serviceSid,
                            entitySid,
                            identity,
                            dateCreated,
                            dateUpdated,
                            friendlyName,
                            status,
                            factorType,
                            config,
                            url);
    }
}