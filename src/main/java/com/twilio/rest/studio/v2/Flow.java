/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.studio.v2;

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
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Flow extends Resource {
    private static final long serialVersionUID = 55575307420038L;

    public enum Status {
        DRAFT("draft"),
        PUBLISHED("published");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Status from a string.
         * @param value string value
         * @return generated Status
         */
        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    /**
     * Create a FlowCreator to execute create.
     *
     * @param friendlyName The string that you assigned to describe the Flow
     * @param status The status of the Flow
     * @param definition JSON representation of flow definition
     * @return FlowCreator capable of executing the create
     */
    public static FlowCreator creator(final String friendlyName,
                                      final Flow.Status status,
                                      final Map<String, Object> definition) {
        return new FlowCreator(friendlyName, status, definition);
    }

    /**
     * Create a FlowUpdater to execute update.
     *
     * @param pathSid The SID that identifies the resource to fetch
     * @param status The status of the Flow
     * @return FlowUpdater capable of executing the update
     */
    public static FlowUpdater updater(final String pathSid,
                                      final Flow.Status status) {
        return new FlowUpdater(pathSid, status);
    }

    /**
     * Create a FlowReader to execute read.
     *
     * @return FlowReader capable of executing the read
     */
    public static FlowReader reader() {
        return new FlowReader();
    }

    /**
     * Create a FlowFetcher to execute fetch.
     *
     * @param pathSid The SID that identifies the resource to fetch
     * @return FlowFetcher capable of executing the fetch
     */
    public static FlowFetcher fetcher(final String pathSid) {
        return new FlowFetcher(pathSid);
    }

    /**
     * Create a FlowDeleter to execute delete.
     *
     * @param pathSid The SID that identifies the resource to delete
     * @return FlowDeleter capable of executing the delete
     */
    public static FlowDeleter deleter(final String pathSid) {
        return new FlowDeleter(pathSid);
    }

    /**
     * Converts a JSON String into a Flow object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Flow object represented by the provided JSON
     */
    public static Flow fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Flow.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Flow object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Flow object represented by the provided JSON
     */
    public static Flow fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Flow.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String friendlyName;
    private final Map<String, Object> definition;
    private final Flow.Status status;
    private final Integer revision;
    private final String commitMessage;
    private final Boolean valid;
    private final List<Map<String, Object>> errors;
    private final List<Map<String, Object>> warnings;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final URI webhookUrl;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Flow(@JsonProperty("sid")
                 final String sid,
                 @JsonProperty("account_sid")
                 final String accountSid,
                 @JsonProperty("friendly_name")
                 final String friendlyName,
                 @JsonProperty("definition")
                 final Map<String, Object> definition,
                 @JsonProperty("status")
                 final Flow.Status status,
                 @JsonProperty("revision")
                 final Integer revision,
                 @JsonProperty("commit_message")
                 final String commitMessage,
                 @JsonProperty("valid")
                 final Boolean valid,
                 @JsonProperty("errors")
                 final List<Map<String, Object>> errors,
                 @JsonProperty("warnings")
                 final List<Map<String, Object>> warnings,
                 @JsonProperty("date_created")
                 final String dateCreated,
                 @JsonProperty("date_updated")
                 final String dateUpdated,
                 @JsonProperty("webhook_url")
                 final URI webhookUrl,
                 @JsonProperty("url")
                 final URI url,
                 @JsonProperty("links")
                 final Map<String, String> links) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.friendlyName = friendlyName;
        this.definition = definition;
        this.status = status;
        this.revision = revision;
        this.commitMessage = commitMessage;
        this.valid = valid;
        this.errors = errors;
        this.warnings = warnings;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.webhookUrl = webhookUrl;
        this.url = url;
        this.links = links;
    }

    /**
     * Returns The unique string that identifies the resource.
     *
     * @return The unique string that identifies the resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The SID of the Account that created the resource.
     *
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The string that you assigned to describe the Flow.
     *
     * @return The string that you assigned to describe the Flow
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns JSON representation of flow definition.
     *
     * @return JSON representation of flow definition
     */
    public final Map<String, Object> getDefinition() {
        return this.definition;
    }

    /**
     * Returns The status of the Flow.
     *
     * @return The status of the Flow
     */
    public final Flow.Status getStatus() {
        return this.status;
    }

    /**
     * Returns The latest revision number of the Flow's definition.
     *
     * @return The latest revision number of the Flow's definition
     */
    public final Integer getRevision() {
        return this.revision;
    }

    /**
     * Returns Description on change made in the revision.
     *
     * @return Description on change made in the revision
     */
    public final String getCommitMessage() {
        return this.commitMessage;
    }

    /**
     * Returns Boolean if the flow definition is valid.
     *
     * @return Boolean if the flow definition is valid
     */
    public final Boolean getValid() {
        return this.valid;
    }

    /**
     * Returns List of error in the flow definition.
     *
     * @return List of error in the flow definition
     */
    public final List<Map<String, Object>> getErrors() {
        return this.errors;
    }

    /**
     * Returns List of warnings in the flow definition.
     *
     * @return List of warnings in the flow definition
     */
    public final List<Map<String, Object>> getWarnings() {
        return this.warnings;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the resource was created.
     *
     * @return The ISO 8601 date and time in GMT when the resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the resource was last updated.
     *
     * @return The ISO 8601 date and time in GMT when the resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The webhook_url.
     *
     * @return The webhook_url
     */
    public final URI getWebhookUrl() {
        return this.webhookUrl;
    }

    /**
     * Returns The absolute URL of the resource.
     *
     * @return The absolute URL of the resource
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns Nested resource URLs.
     *
     * @return Nested resource URLs
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

        Flow other = (Flow) o;

        return Objects.equals(sid, other.sid) &&
               Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(friendlyName, other.friendlyName) &&
               Objects.equals(definition, other.definition) &&
               Objects.equals(status, other.status) &&
               Objects.equals(revision, other.revision) &&
               Objects.equals(commitMessage, other.commitMessage) &&
               Objects.equals(valid, other.valid) &&
               Objects.equals(errors, other.errors) &&
               Objects.equals(warnings, other.warnings) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(webhookUrl, other.webhookUrl) &&
               Objects.equals(url, other.url) &&
               Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            friendlyName,
                            definition,
                            status,
                            revision,
                            commitMessage,
                            valid,
                            errors,
                            warnings,
                            dateCreated,
                            dateUpdated,
                            webhookUrl,
                            url,
                            links);
    }
}