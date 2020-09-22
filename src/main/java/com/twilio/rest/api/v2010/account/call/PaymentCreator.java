/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.call;

import com.twilio.base.Creator;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Map;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class PaymentCreator extends Creator<Payment> {
    private String pathAccountSid;
    private final String pathCallSid;
    private final String idempotencyKey;
    private final URI statusCallback;
    private Payment.BankAccountType bankAccountType;
    private BigDecimal chargeAmount;
    private String currency;
    private String description;
    private String input;
    private Integer minPostalCodeLength;
    private Map<String, Object> parameter;
    private String paymentConnector;
    private Payment.PaymentMethod paymentMethod;
    private Boolean postalCode;
    private Boolean securityCode;
    private Integer timeout;
    private Payment.TokenType tokenType;
    private String validCardTypes;

    /**
     * Construct a new PaymentCreator.
     *
     * @param pathCallSid The SID of the call that will create the resource.
     * @param idempotencyKey A unique token that will be used to ensure that
     *                       multiple API calls with the same information do not
     *                       result in multiple transactions.
     * @param statusCallback Provide an absolute or relative URL to receive status
     *                       updates regarding your Pay session..
     */
    public PaymentCreator(final String pathCallSid,
                          final String idempotencyKey,
                          final URI statusCallback) {
        this.pathCallSid = pathCallSid;
        this.idempotencyKey = idempotencyKey;
        this.statusCallback = statusCallback;
    }

    /**
     * Construct a new PaymentCreator.
     *
     * @param pathAccountSid The SID of the Account that will create the resource
     * @param pathCallSid The SID of the call that will create the resource.
     * @param idempotencyKey A unique token that will be used to ensure that
     *                       multiple API calls with the same information do not
     *                       result in multiple transactions.
     * @param statusCallback Provide an absolute or relative URL to receive status
     *                       updates regarding your Pay session..
     */
    public PaymentCreator(final String pathAccountSid,
                          final String pathCallSid,
                          final String idempotencyKey,
                          final URI statusCallback) {
        this.pathAccountSid = pathAccountSid;
        this.pathCallSid = pathCallSid;
        this.idempotencyKey = idempotencyKey;
        this.statusCallback = statusCallback;
    }

    /**
     * Type of bank account if payment source is ACH. One of `consumer-checking`,
     * `consumer-savings`, or `commercial-checking`. The default value is
     * `consumer-checking`..
     *
     * @param bankAccountType Type of bank account if payment source is ACH.
     * @return this
     */
    public PaymentCreator setBankAccountType(final Payment.BankAccountType bankAccountType) {
        this.bankAccountType = bankAccountType;
        return this;
    }

    /**
     * A positive decimal value less than 1,000,000 to charge against the credit
     * card or bank account. Default currency can be overwritten with `currency`
     * field. Leave blank or set to 0 to tokenize..
     *
     * @param chargeAmount A positive decimal value less than 1,000,000 to charge
     *                     against the credit card or bank account.
     * @return this
     */
    public PaymentCreator setChargeAmount(final BigDecimal chargeAmount) {
        this.chargeAmount = chargeAmount;
        return this;
    }

    /**
     * The currency of the `charge_amount`, formatted as <a
     * href="http://www.iso.org/iso/home/standards/currency_codes.htm">ISO 4127</a>
     * format. The default value is `USD` and all values allowed from the
     * &lt;Pay&gt; Connector are accepted..
     *
     * @param currency The currency of the `charge_amount`.
     * @return this
     */
    public PaymentCreator setCurrency(final String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * The description can be used to provide more details regarding the
     * transaction. This information is submitted along with the payment details to
     * the Payment Connector which are then posted on the transactions..
     *
     * @param description The description can be used to provide more details
     *                    regarding the transaction.
     * @return this
     */
    public PaymentCreator setDescription(final String description) {
        this.description = description;
        return this;
    }

    /**
     * A list of inputs that should be accepted. Currently only `dtmf` is supported.
     * All digits captured during a pay session are redacted from the logs..
     *
     * @param input A list of inputs that should be accepted. Currently only `dtmf`
     *              is supported.
     * @return this
     */
    public PaymentCreator setInput(final String input) {
        this.input = input;
        return this;
    }

    /**
     * A positive integer that is used to validate the length of the `PostalCode`
     * inputted by the user. User must enter this many digits..
     *
     * @param minPostalCodeLength A positive integer that is used to validate the
     *                            length of the `PostalCode` inputted by the user.
     * @return this
     */
    public PaymentCreator setMinPostalCodeLength(final Integer minPostalCodeLength) {
        this.minPostalCodeLength = minPostalCodeLength;
        return this;
    }

    /**
     * A single level JSON string that is required when accepting certain
     * information specific only to ACH payments. The information that has to be
     * included here depends on the &lt;Pay&gt; Connector. <a
     * href="https://www.twilio.com/console/voice/pay-connectors">Read more</a>..
     *
     * @param parameter A single level JSON string that is required when accepting
     *                  certain information specific only to ACH payments.
     * @return this
     */
    public PaymentCreator setParameter(final Map<String, Object> parameter) {
        this.parameter = parameter;
        return this;
    }

    /**
     * This is the unique name corresponding to the Payment Gateway Connector
     * installed in the Twilio Add-ons. Learn more about <a
     * href="https://www.twilio.com/console/voice/pay-connectors">&lt;Pay&gt;
     * Connectors</a>. The default value is `Default`..
     *
     * @param paymentConnector This is the unique name corresponding to the Payment
     *                         Gateway Connector installed in the Twilio Add-ons.
     * @return this
     */
    public PaymentCreator setPaymentConnector(final String paymentConnector) {
        this.paymentConnector = paymentConnector;
        return this;
    }

    /**
     * Type of payment being captured. One of `credit-card` or `ach-debit`. The
     * default value is `credit-card`..
     *
     * @param paymentMethod Type of payment being captured.
     * @return this
     */
    public PaymentCreator setPaymentMethod(final Payment.PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    /**
     * Indicates whether the credit card postal code (zip code) is a required piece
     * of payment information that must be provided by the caller. The default is
     * `true`..
     *
     * @param postalCode Indicates whether the credit card PostalCode (zip code) is
     *                   a required piece of payment information that must be
     *                   provided by the caller.
     * @return this
     */
    public PaymentCreator setPostalCode(final Boolean postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    /**
     * Indicates whether the credit card security code is a required piece of
     * payment information that must be provided by the caller. The default is
     * `true`..
     *
     * @param securityCode Indicates whether the credit card security code is a
     *                     required piece of payment information that must be
     *                     provided by the caller.
     * @return this
     */
    public PaymentCreator setSecurityCode(final Boolean securityCode) {
        this.securityCode = securityCode;
        return this;
    }

    /**
     * The number of seconds that &lt;Pay&gt; should wait for the caller to press a
     * digit between each subsequent digit, after the first one, before moving on to
     * validate the digits captured. The default is `5`, maximum is `600`..
     *
     * @param timeout The number of seconds that &lt;Pay&gt; should wait for the
     *                caller to press a digit between each subsequent digit, after
     *                the first one, before moving on to validate the digits
     *                captured.
     * @return this
     */
    public PaymentCreator setTimeout(final Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    /**
     * Indicates whether the payment method should be tokenized as a `one-time` or
     * `reusable` token. The default value is `reusable`. Do not enter a charge
     * amount when tokenizing. If a charge amount is entered, the payment method
     * will be charged and not tokenized..
     *
     * @param tokenType Indicates whether the payment method should be tokenized as
     *                  a `one-time` or `reusable` token.
     * @return this
     */
    public PaymentCreator setTokenType(final Payment.TokenType tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    /**
     * Credit card types separated by space that Pay should accept. The default
     * value is `visa mastercard amex`.
     *
     * @param validCardTypes Credit card types separated by space that Pay should
     *                       accept.
     * @return this
     */
    public PaymentCreator setValidCardTypes(final String validCardTypes) {
        this.validCardTypes = validCardTypes;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Payment
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Payment create(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/Calls/" + this.pathCallSid + "/Payments.json"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Payment creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Payment.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (idempotencyKey != null) {
            request.addPostParam("IdempotencyKey", idempotencyKey);
        }

        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());
        }

        if (bankAccountType != null) {
            request.addPostParam("BankAccountType", bankAccountType.toString());
        }

        if (chargeAmount != null) {
            request.addPostParam("ChargeAmount", chargeAmount.toString());
        }

        if (currency != null) {
            request.addPostParam("Currency", currency);
        }

        if (description != null) {
            request.addPostParam("Description", description);
        }

        if (input != null) {
            request.addPostParam("Input", input);
        }

        if (minPostalCodeLength != null) {
            request.addPostParam("MinPostalCodeLength", minPostalCodeLength.toString());
        }

        if (parameter != null) {
            request.addPostParam("Parameter", Converter.mapToJson(parameter));
        }

        if (paymentConnector != null) {
            request.addPostParam("PaymentConnector", paymentConnector);
        }

        if (paymentMethod != null) {
            request.addPostParam("PaymentMethod", paymentMethod.toString());
        }

        if (postalCode != null) {
            request.addPostParam("PostalCode", postalCode.toString());
        }

        if (securityCode != null) {
            request.addPostParam("SecurityCode", securityCode.toString());
        }

        if (timeout != null) {
            request.addPostParam("Timeout", timeout.toString());
        }

        if (tokenType != null) {
            request.addPostParam("TokenType", tokenType.toString());
        }

        if (validCardTypes != null) {
            request.addPostParam("ValidCardTypes", validCardTypes);
        }
    }
}