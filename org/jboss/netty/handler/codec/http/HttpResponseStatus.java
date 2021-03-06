package org.jboss.netty.handler.codec.http;

import org.apache.commons.compress.archivers.zip.UnixStat;
import org.apache.http.HttpStatus;

public class HttpResponseStatus implements Comparable<HttpResponseStatus> {
    public static final HttpResponseStatus ACCEPTED = new HttpResponseStatus(HttpStatus.SC_ACCEPTED, "Accepted");
    public static final HttpResponseStatus BAD_GATEWAY = new HttpResponseStatus(HttpStatus.SC_BAD_GATEWAY, "Bad Gateway");
    public static final HttpResponseStatus BAD_REQUEST = new HttpResponseStatus(HttpStatus.SC_BAD_REQUEST, "Bad Request");
    public static final HttpResponseStatus CONFLICT = new HttpResponseStatus(HttpStatus.SC_CONFLICT, "Conflict");
    public static final HttpResponseStatus CONTINUE = new HttpResponseStatus(100, "Continue");
    public static final HttpResponseStatus CREATED = new HttpResponseStatus(HttpStatus.SC_CREATED, "Created");
    public static final HttpResponseStatus EXPECTATION_FAILED = new HttpResponseStatus(HttpStatus.SC_EXPECTATION_FAILED, "Expectation Failed");
    public static final HttpResponseStatus FAILED_DEPENDENCY = new HttpResponseStatus(HttpStatus.SC_FAILED_DEPENDENCY, "Failed Dependency");
    public static final HttpResponseStatus FORBIDDEN = new HttpResponseStatus(HttpStatus.SC_FORBIDDEN, "Forbidden");
    public static final HttpResponseStatus FOUND = new HttpResponseStatus(HttpStatus.SC_MOVED_TEMPORARILY, "Found");
    public static final HttpResponseStatus GATEWAY_TIMEOUT = new HttpResponseStatus(504, "Gateway Timeout");
    public static final HttpResponseStatus GONE = new HttpResponseStatus(HttpStatus.SC_GONE, "Gone");
    public static final HttpResponseStatus HTTP_VERSION_NOT_SUPPORTED = new HttpResponseStatus(HttpStatus.SC_HTTP_VERSION_NOT_SUPPORTED, "HTTP Version Not Supported");
    public static final HttpResponseStatus INSUFFICIENT_STORAGE = new HttpResponseStatus(HttpStatus.SC_INSUFFICIENT_STORAGE, "Insufficient Storage");
    public static final HttpResponseStatus INTERNAL_SERVER_ERROR = new HttpResponseStatus(500, "Internal Server Error");
    public static final HttpResponseStatus LENGTH_REQUIRED = new HttpResponseStatus(HttpStatus.SC_LENGTH_REQUIRED, "Length Required");
    public static final HttpResponseStatus LOCKED = new HttpResponseStatus(HttpStatus.SC_LOCKED, "Locked");
    public static final HttpResponseStatus METHOD_NOT_ALLOWED = new HttpResponseStatus(HttpStatus.SC_METHOD_NOT_ALLOWED, "Method Not Allowed");
    public static final HttpResponseStatus MOVED_PERMANENTLY = new HttpResponseStatus(HttpStatus.SC_MOVED_PERMANENTLY, "Moved Permanently");
    public static final HttpResponseStatus MULTIPLE_CHOICES = new HttpResponseStatus(HttpStatus.SC_MULTIPLE_CHOICES, "Multiple Choices");
    public static final HttpResponseStatus MULTI_STATUS = new HttpResponseStatus(HttpStatus.SC_MULTI_STATUS, "Multi-Status");
    public static final HttpResponseStatus NETWORK_AUTHENTICATION_REQUIRED = new HttpResponseStatus(UnixStat.DEFAULT_LINK_PERM, "Network Authentication Required");
    public static final HttpResponseStatus NON_AUTHORITATIVE_INFORMATION = new HttpResponseStatus(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, "Non-Authoritative Information");
    public static final HttpResponseStatus NOT_ACCEPTABLE = new HttpResponseStatus(HttpStatus.SC_NOT_ACCEPTABLE, "Not Acceptable");
    public static final HttpResponseStatus NOT_EXTENDED = new HttpResponseStatus(510, "Not Extended");
    public static final HttpResponseStatus NOT_FOUND = new HttpResponseStatus(HttpStatus.SC_NOT_FOUND, "Not Found");
    public static final HttpResponseStatus NOT_IMPLEMENTED = new HttpResponseStatus(HttpStatus.SC_NOT_IMPLEMENTED, "Not Implemented");
    public static final HttpResponseStatus NOT_MODIFIED = new HttpResponseStatus(HttpStatus.SC_NOT_MODIFIED, "Not Modified");
    public static final HttpResponseStatus NO_CONTENT = new HttpResponseStatus(HttpStatus.SC_NO_CONTENT, "No Content");
    public static final HttpResponseStatus OK = new HttpResponseStatus(200, "OK");
    public static final HttpResponseStatus PARTIAL_CONTENT = new HttpResponseStatus(HttpStatus.SC_PARTIAL_CONTENT, "Partial Content");
    public static final HttpResponseStatus PAYMENT_REQUIRED = new HttpResponseStatus(HttpStatus.SC_PAYMENT_REQUIRED, "Payment Required");
    public static final HttpResponseStatus PRECONDITION_FAILED = new HttpResponseStatus(HttpStatus.SC_PRECONDITION_FAILED, "Precondition Failed");
    public static final HttpResponseStatus PRECONDITION_REQUIRED = new HttpResponseStatus(428, "Precondition Required");
    public static final HttpResponseStatus PROCESSING = new HttpResponseStatus(102, "Processing");
    public static final HttpResponseStatus PROXY_AUTHENTICATION_REQUIRED = new HttpResponseStatus(HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED, "Proxy Authentication Required");
    public static final HttpResponseStatus REQUESTED_RANGE_NOT_SATISFIABLE = new HttpResponseStatus(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE, "Requested Range Not Satisfiable");
    public static final HttpResponseStatus REQUEST_ENTITY_TOO_LARGE = new HttpResponseStatus(HttpStatus.SC_REQUEST_TOO_LONG, "Request Entity Too Large");
    public static final HttpResponseStatus REQUEST_HEADER_FIELDS_TOO_LARGE = new HttpResponseStatus(431, "Request Header Fields Too Large");
    public static final HttpResponseStatus REQUEST_TIMEOUT = new HttpResponseStatus(HttpStatus.SC_REQUEST_TIMEOUT, "Request Timeout");
    public static final HttpResponseStatus REQUEST_URI_TOO_LONG = new HttpResponseStatus(HttpStatus.SC_REQUEST_URI_TOO_LONG, "Request-URI Too Long");
    public static final HttpResponseStatus RESET_CONTENT = new HttpResponseStatus(HttpStatus.SC_RESET_CONTENT, "Reset Content");
    public static final HttpResponseStatus SEE_OTHER = new HttpResponseStatus(HttpStatus.SC_SEE_OTHER, "See Other");
    public static final HttpResponseStatus SERVICE_UNAVAILABLE = new HttpResponseStatus(HttpStatus.SC_SERVICE_UNAVAILABLE, "Service Unavailable");
    public static final HttpResponseStatus SWITCHING_PROTOCOLS = new HttpResponseStatus(101, "Switching Protocols");
    public static final HttpResponseStatus TEMPORARY_REDIRECT = new HttpResponseStatus(307, "Temporary Redirect");
    public static final HttpResponseStatus TOO_MANY_REQUESTS = new HttpResponseStatus(429, "Too Many Requests");
    public static final HttpResponseStatus UNAUTHORIZED = new HttpResponseStatus(HttpStatus.SC_UNAUTHORIZED, "Unauthorized");
    public static final HttpResponseStatus UNORDERED_COLLECTION = new HttpResponseStatus(425, "Unordered Collection");
    public static final HttpResponseStatus UNPROCESSABLE_ENTITY = new HttpResponseStatus(HttpStatus.SC_UNPROCESSABLE_ENTITY, "Unprocessable Entity");
    public static final HttpResponseStatus UNSUPPORTED_MEDIA_TYPE = new HttpResponseStatus(HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE, "Unsupported Media Type");
    public static final HttpResponseStatus UPGRADE_REQUIRED = new HttpResponseStatus(426, "Upgrade Required");
    public static final HttpResponseStatus USE_PROXY = new HttpResponseStatus(HttpStatus.SC_USE_PROXY, "Use Proxy");
    public static final HttpResponseStatus VARIANT_ALSO_NEGOTIATES = new HttpResponseStatus(506, "Variant Also Negotiates");
    private final int code;
    private final String reasonPhrase;

    public static HttpResponseStatus valueOf(int code) {
        switch (code) {
            case 100:
                return CONTINUE;
            case 101:
                return SWITCHING_PROTOCOLS;
            case 102:
                return PROCESSING;
            case 200:
                return OK;
            case HttpStatus.SC_CREATED /*201*/:
                return CREATED;
            case HttpStatus.SC_ACCEPTED /*202*/:
                return ACCEPTED;
            case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /*203*/:
                return NON_AUTHORITATIVE_INFORMATION;
            case HttpStatus.SC_NO_CONTENT /*204*/:
                return NO_CONTENT;
            case HttpStatus.SC_RESET_CONTENT /*205*/:
                return RESET_CONTENT;
            case HttpStatus.SC_PARTIAL_CONTENT /*206*/:
                return PARTIAL_CONTENT;
            case HttpStatus.SC_MULTI_STATUS /*207*/:
                return MULTI_STATUS;
            case HttpStatus.SC_MULTIPLE_CHOICES /*300*/:
                return MULTIPLE_CHOICES;
            case HttpStatus.SC_MOVED_PERMANENTLY /*301*/:
                return MOVED_PERMANENTLY;
            case HttpStatus.SC_MOVED_TEMPORARILY /*302*/:
                return FOUND;
            case HttpStatus.SC_SEE_OTHER /*303*/:
                return SEE_OTHER;
            case HttpStatus.SC_NOT_MODIFIED /*304*/:
                return NOT_MODIFIED;
            case HttpStatus.SC_USE_PROXY /*305*/:
                return USE_PROXY;
            case 307:
                return TEMPORARY_REDIRECT;
            case HttpStatus.SC_BAD_REQUEST /*400*/:
                return BAD_REQUEST;
            case HttpStatus.SC_UNAUTHORIZED /*401*/:
                return UNAUTHORIZED;
            case HttpStatus.SC_PAYMENT_REQUIRED /*402*/:
                return PAYMENT_REQUIRED;
            case HttpStatus.SC_FORBIDDEN /*403*/:
                return FORBIDDEN;
            case HttpStatus.SC_NOT_FOUND /*404*/:
                return NOT_FOUND;
            case HttpStatus.SC_METHOD_NOT_ALLOWED /*405*/:
                return METHOD_NOT_ALLOWED;
            case HttpStatus.SC_NOT_ACCEPTABLE /*406*/:
                return NOT_ACCEPTABLE;
            case HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED /*407*/:
                return PROXY_AUTHENTICATION_REQUIRED;
            case HttpStatus.SC_REQUEST_TIMEOUT /*408*/:
                return REQUEST_TIMEOUT;
            case HttpStatus.SC_CONFLICT /*409*/:
                return CONFLICT;
            case HttpStatus.SC_GONE /*410*/:
                return GONE;
            case HttpStatus.SC_LENGTH_REQUIRED /*411*/:
                return LENGTH_REQUIRED;
            case HttpStatus.SC_PRECONDITION_FAILED /*412*/:
                return PRECONDITION_FAILED;
            case HttpStatus.SC_REQUEST_TOO_LONG /*413*/:
                return REQUEST_ENTITY_TOO_LARGE;
            case HttpStatus.SC_REQUEST_URI_TOO_LONG /*414*/:
                return REQUEST_URI_TOO_LONG;
            case HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE /*415*/:
                return UNSUPPORTED_MEDIA_TYPE;
            case HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE /*416*/:
                return REQUESTED_RANGE_NOT_SATISFIABLE;
            case HttpStatus.SC_EXPECTATION_FAILED /*417*/:
                return EXPECTATION_FAILED;
            case HttpStatus.SC_UNPROCESSABLE_ENTITY /*422*/:
                return UNPROCESSABLE_ENTITY;
            case HttpStatus.SC_LOCKED /*423*/:
                return LOCKED;
            case HttpStatus.SC_FAILED_DEPENDENCY /*424*/:
                return FAILED_DEPENDENCY;
            case 425:
                return UNORDERED_COLLECTION;
            case 426:
                return UPGRADE_REQUIRED;
            case 428:
                return PRECONDITION_REQUIRED;
            case 429:
                return TOO_MANY_REQUESTS;
            case 431:
                return REQUEST_HEADER_FIELDS_TOO_LARGE;
            case 500:
                return INTERNAL_SERVER_ERROR;
            case HttpStatus.SC_NOT_IMPLEMENTED /*501*/:
                return NOT_IMPLEMENTED;
            case HttpStatus.SC_BAD_GATEWAY /*502*/:
                return BAD_GATEWAY;
            case HttpStatus.SC_SERVICE_UNAVAILABLE /*503*/:
                return SERVICE_UNAVAILABLE;
            case 504:
                return GATEWAY_TIMEOUT;
            case HttpStatus.SC_HTTP_VERSION_NOT_SUPPORTED /*505*/:
                return HTTP_VERSION_NOT_SUPPORTED;
            case 506:
                return VARIANT_ALSO_NEGOTIATES;
            case HttpStatus.SC_INSUFFICIENT_STORAGE /*507*/:
                return INSUFFICIENT_STORAGE;
            case 510:
                return NOT_EXTENDED;
            case UnixStat.DEFAULT_LINK_PERM /*511*/:
                return NETWORK_AUTHENTICATION_REQUIRED;
            default:
                String reasonPhrase;
                if (code < 100) {
                    reasonPhrase = "Unknown Status";
                } else if (code < 200) {
                    reasonPhrase = "Informational";
                } else if (code < HttpStatus.SC_MULTIPLE_CHOICES) {
                    reasonPhrase = "Successful";
                } else if (code < HttpStatus.SC_BAD_REQUEST) {
                    reasonPhrase = "Redirection";
                } else if (code < 500) {
                    reasonPhrase = "Client Error";
                } else if (code < 600) {
                    reasonPhrase = "Server Error";
                } else {
                    reasonPhrase = "Unknown Status";
                }
                return new HttpResponseStatus(code, reasonPhrase + " (" + code + ')');
        }
    }

    public HttpResponseStatus(int code, String reasonPhrase) {
        if (code < 0) {
            throw new IllegalArgumentException("code: " + code + " (expected: 0+)");
        } else if (reasonPhrase == null) {
            throw new NullPointerException("reasonPhrase");
        } else {
            int i = 0;
            while (i < reasonPhrase.length()) {
                switch (reasonPhrase.charAt(i)) {
                    case '\n':
                    case '\r':
                        throw new IllegalArgumentException("reasonPhrase contains one of the following prohibited characters: \\r\\n: " + reasonPhrase);
                    default:
                        i++;
                }
            }
            this.code = code;
            this.reasonPhrase = reasonPhrase;
        }
    }

    public int getCode() {
        return this.code;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    public int hashCode() {
        return getCode();
    }

    public boolean equals(Object o) {
        if ((o instanceof HttpResponseStatus) && getCode() == ((HttpResponseStatus) o).getCode()) {
            return true;
        }
        return false;
    }

    public int compareTo(HttpResponseStatus o) {
        return getCode() - o.getCode();
    }

    public String toString() {
        StringBuilder buf = new StringBuilder(this.reasonPhrase.length() + 5);
        buf.append(this.code);
        buf.append(' ');
        buf.append(this.reasonPhrase);
        return buf.toString();
    }
}
