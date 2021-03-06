/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.message;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class MediaReader extends Reader<Media> {
    private String pathAccountSid;
    private final String pathMessageSid;
    private ZonedDateTime dateCreated;
    private ZonedDateTime dateCreatedBefore;
    private ZonedDateTime dateCreatedAfter;

    /**
     * Construct a new MediaReader.
     *
     * @param pathMessageSid The SID of the Message resource that this Media
     *                       resource belongs to
     */
    public MediaReader(final String pathMessageSid) {
        this.pathMessageSid = pathMessageSid;
    }

    /**
     * Construct a new MediaReader.
     *
     * @param pathAccountSid The SID of the Account that created the resource(s) to
     *                       read
     * @param pathMessageSid The SID of the Message resource that this Media
     *                       resource belongs to
     */
    public MediaReader(final String pathAccountSid,
                       final String pathMessageSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathMessageSid = pathMessageSid;
    }

    /**
     * Only include media that was created on this date. Specify a date as
     * `YYYY-MM-DD` in GMT, for example: `2009-07-06`, to read media that was
     * created on this date. You can also specify an inequality, such as
     * `StartTime&lt;=YYYY-MM-DD`, to read media that was created on or before
     * midnight of this date, and `StartTime&gt;=YYYY-MM-DD` to read media that was
     * created on or after midnight of this date..
     *
     * @param dateCreated Only include media that was created on this date
     * @return this
     */
    public MediaReader setDateCreated(final ZonedDateTime dateCreated) {
        this.dateCreatedBefore = null;
        this.dateCreatedAfter = null;
        this.dateCreated = dateCreated;
        return this;
    }

    /**
     * Only include media that was created on this date. Specify a date as
     * `YYYY-MM-DD` in GMT, for example: `2009-07-06`, to read media that was
     * created on this date. You can also specify an inequality, such as
     * `StartTime&lt;=YYYY-MM-DD`, to read media that was created on or before
     * midnight of this date, and `StartTime&gt;=YYYY-MM-DD` to read media that was
     * created on or after midnight of this date..
     *
     * @param dateCreatedBefore Only include media that was created on this date
     * @return this
     */
    public MediaReader setDateCreatedBefore(final ZonedDateTime dateCreatedBefore) {
        this.dateCreated = null;
        this.dateCreatedBefore = dateCreatedBefore;
        return this;
    }

    /**
     * Only include media that was created on this date. Specify a date as
     * `YYYY-MM-DD` in GMT, for example: `2009-07-06`, to read media that was
     * created on this date. You can also specify an inequality, such as
     * `StartTime&lt;=YYYY-MM-DD`, to read media that was created on or before
     * midnight of this date, and `StartTime&gt;=YYYY-MM-DD` to read media that was
     * created on or after midnight of this date..
     *
     * @param dateCreatedAfter Only include media that was created on this date
     * @return this
     */
    public MediaReader setDateCreatedAfter(final ZonedDateTime dateCreatedAfter) {
        this.dateCreated = null;
        this.dateCreatedAfter = dateCreatedAfter;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Media ResourceSet
     */
    @Override
    public ResourceSet<Media> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    /**
     * Make the request to the Twilio API to perform the read.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Media ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Media> firstPage(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/Messages/" + this.pathMessageSid + "/Media.json"
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the target page from the Twilio API.
     *
     * @param targetUrl API-generated URL for the requested results page
     * @param client TwilioRestClient with which to make the request
     * @return Media ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Media> getPage(final String targetUrl, final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }

    /**
     * Retrieve the next page from the Twilio API.
     *
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Next Page
     */
    @Override
    public Page<Media> nextPage(final Page<Media> page,
                                final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.API.toString())
        );
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the previous page from the Twilio API.
     *
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Previous Page
     */
    @Override
    public Page<Media> previousPage(final Page<Media> page,
                                    final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.API.toString())
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of Media Resources for a given request.
     *
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<Media> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Media read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
           throw new ApiException(restException);
        }

        return Page.fromJson(
            "media_list",
            response.getContent(),
            Media.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     *
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (dateCreated != null) {
            request.addQueryParam("DateCreated", dateCreated.format(DateTimeFormatter.ofPattern(Request.QUERY_STRING_DATE_TIME_FORMAT)));
        } else if (dateCreatedAfter != null || dateCreatedBefore != null) {
            request.addQueryDateTimeRange("DateCreated", dateCreatedAfter, dateCreatedBefore);
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}