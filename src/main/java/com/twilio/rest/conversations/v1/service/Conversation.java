/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.conversations.v1.service;

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

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Conversation extends Resource {
    private static final long serialVersionUID = 235657538705254L;

    public enum WebhookEnabledType {
        TRUE("true"),
        FALSE("false");

        private final String value;

        private WebhookEnabledType(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a WebhookEnabledType from a string.
         * @param value string value
         * @return generated WebhookEnabledType
         */
        @JsonCreator
        public static WebhookEnabledType forValue(final String value) {
            return Promoter.enumFromString(value, WebhookEnabledType.values());
        }
    }

    public enum State {
        INACTIVE("inactive"),
        ACTIVE("active"),
        CLOSED("closed");

        private final String value;

        private State(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a State from a string.
         * @param value string value
         * @return generated State
         */
        @JsonCreator
        public static State forValue(final String value) {
            return Promoter.enumFromString(value, State.values());
        }
    }

    /**
     * Create a ConversationCreator to execute create.
     *
     * @param pathChatServiceSid The SID of the Conversation Service that the
     *                           resource is associated with.
     * @return ConversationCreator capable of executing the create
     */
    public static ConversationCreator creator(final String pathChatServiceSid) {
        return new ConversationCreator(pathChatServiceSid);
    }

    /**
     * Create a ConversationUpdater to execute update.
     *
     * @param pathChatServiceSid The SID of the Conversation Service that the
     *                           resource is associated with.
     * @param pathSid A 34 character string that uniquely identifies this resource.
     * @return ConversationUpdater capable of executing the update
     */
    public static ConversationUpdater updater(final String pathChatServiceSid,
                                              final String pathSid) {
        return new ConversationUpdater(pathChatServiceSid, pathSid);
    }

    /**
     * Create a ConversationDeleter to execute delete.
     *
     * @param pathChatServiceSid The SID of the Conversation Service that the
     *                           resource is associated with.
     * @param pathSid A 34 character string that uniquely identifies this resource.
     * @return ConversationDeleter capable of executing the delete
     */
    public static ConversationDeleter deleter(final String pathChatServiceSid,
                                              final String pathSid) {
        return new ConversationDeleter(pathChatServiceSid, pathSid);
    }

    /**
     * Create a ConversationFetcher to execute fetch.
     *
     * @param pathChatServiceSid The SID of the Conversation Service that the
     *                           resource is associated with.
     * @param pathSid A 34 character string that uniquely identifies this resource.
     * @return ConversationFetcher capable of executing the fetch
     */
    public static ConversationFetcher fetcher(final String pathChatServiceSid,
                                              final String pathSid) {
        return new ConversationFetcher(pathChatServiceSid, pathSid);
    }

    /**
     * Create a ConversationReader to execute read.
     *
     * @param pathChatServiceSid The SID of the Conversation Service that the
     *                           resource is associated with.
     * @return ConversationReader capable of executing the read
     */
    public static ConversationReader reader(final String pathChatServiceSid) {
        return new ConversationReader(pathChatServiceSid);
    }

    /**
     * Converts a JSON String into a Conversation object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Conversation object represented by the provided JSON
     */
    public static Conversation fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Conversation.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Conversation object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Conversation object represented by the provided JSON
     */
    public static Conversation fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Conversation.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String chatServiceSid;
    private final String messagingServiceSid;
    private final String sid;
    private final String friendlyName;
    private final String uniqueName;
    private final String attributes;
    private final Conversation.State state;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final Map<String, Object> timers;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Conversation(@JsonProperty("account_sid")
                         final String accountSid,
                         @JsonProperty("chat_service_sid")
                         final String chatServiceSid,
                         @JsonProperty("messaging_service_sid")
                         final String messagingServiceSid,
                         @JsonProperty("sid")
                         final String sid,
                         @JsonProperty("friendly_name")
                         final String friendlyName,
                         @JsonProperty("unique_name")
                         final String uniqueName,
                         @JsonProperty("attributes")
                         final String attributes,
                         @JsonProperty("state")
                         final Conversation.State state,
                         @JsonProperty("date_created")
                         final String dateCreated,
                         @JsonProperty("date_updated")
                         final String dateUpdated,
                         @JsonProperty("timers")
                         final Map<String, Object> timers,
                         @JsonProperty("url")
                         final URI url,
                         @JsonProperty("links")
                         final Map<String, String> links) {
        this.accountSid = accountSid;
        this.chatServiceSid = chatServiceSid;
        this.messagingServiceSid = messagingServiceSid;
        this.sid = sid;
        this.friendlyName = friendlyName;
        this.uniqueName = uniqueName;
        this.attributes = attributes;
        this.state = state;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.timers = timers;
        this.url = url;
        this.links = links;
    }

    /**
     * Returns The unique ID of the Account responsible for this conversation..
     *
     * @return The unique ID of the Account responsible for this conversation.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The unique ID of the Conversation Service this conversation belongs
     * to..
     *
     * @return The unique ID of the Conversation Service this conversation belongs
     *         to.
     */
    public final String getChatServiceSid() {
        return this.chatServiceSid;
    }

    /**
     * Returns The unique ID of the Messaging Service this conversation belongs to..
     *
     * @return The unique ID of the Messaging Service this conversation belongs to.
     */
    public final String getMessagingServiceSid() {
        return this.messagingServiceSid;
    }

    /**
     * Returns A 34 character string that uniquely identifies this resource..
     *
     * @return A 34 character string that uniquely identifies this resource.
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The human-readable name of this conversation..
     *
     * @return The human-readable name of this conversation.
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns An application-defined string that uniquely identifies the resource.
     *
     * @return An application-defined string that uniquely identifies the resource
     */
    public final String getUniqueName() {
        return this.uniqueName;
    }

    /**
     * Returns An optional string metadata field you can use to store any data you
     * wish..
     *
     * @return An optional string metadata field you can use to store any data you
     *         wish.
     */
    public final String getAttributes() {
        return this.attributes;
    }

    /**
     * Returns Current state of this conversation..
     *
     * @return Current state of this conversation.
     */
    public final Conversation.State getState() {
        return this.state;
    }

    /**
     * Returns The date that this resource was created..
     *
     * @return The date that this resource was created.
     */
    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The date that this resource was last updated..
     *
     * @return The date that this resource was last updated.
     */
    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns Timer date values for this conversation..
     *
     * @return Timer date values for this conversation.
     */
    public final Map<String, Object> getTimers() {
        return this.timers;
    }

    /**
     * Returns An absolute URL for this conversation..
     *
     * @return An absolute URL for this conversation.
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns Absolute URLs to access the participants, messages and webhooks of
     * this conversation..
     *
     * @return Absolute URLs to access the participants, messages and webhooks of
     *         this conversation.
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Conversation other = (Conversation) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(chatServiceSid, other.chatServiceSid) &&
               Objects.equals(messagingServiceSid, other.messagingServiceSid) &&
               Objects.equals(sid, other.sid) &&
               Objects.equals(friendlyName, other.friendlyName) &&
               Objects.equals(uniqueName, other.uniqueName) &&
               Objects.equals(attributes, other.attributes) &&
               Objects.equals(state, other.state) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(timers, other.timers) &&
               Objects.equals(url, other.url) &&
               Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            chatServiceSid,
                            messagingServiceSid,
                            sid,
                            friendlyName,
                            uniqueName,
                            attributes,
                            state,
                            dateCreated,
                            dateUpdated,
                            timers,
                            url,
                            links);
    }
}