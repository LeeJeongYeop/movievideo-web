package com.nayak.movievideo.utils;

/**
 * Created by nayak on 26/09/2018.
 */
public class AjaxResponse {
    private AjaxResponseCode status;
    private String message;
    private Object data;

    private AjaxResponse(AjaxResponseBuilder builder) {
        this.status = builder.status;
        this.message = builder.message;
        this.data = builder.data;
    }

    public String getStatus() {
        return status.getStatusText();
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return "AjaxResponse{" +
                "status='" + status.getStatusText() + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class AjaxResponseBuilder {
        private AjaxResponseCode status;
        private String message;
        private Object data;

        private AjaxResponseBuilder(AjaxResponseCode status) {
            this.status = status;
        }

        public static AjaxResponseBuilder create(AjaxResponseCode status) {
            return new AjaxResponseBuilder(status);
        }

        public static AjaxResponseBuilder create(Boolean status) {
            return new AjaxResponseBuilder(status ? AjaxResponseCode.SUCCESS : AjaxResponseCode.FAIL);
        }

        public AjaxResponseBuilder setMessage(String message) {
            this.message = message;
            return this;
        }

        public AjaxResponseBuilder setData(Object data) {
            this.data = data;
            return this;
        }

        public AjaxResponse build() {
            return new AjaxResponse(this);
        }
    }

    public enum AjaxResponseCode {
        SUCCESS("success"), FAIL("fail");

        private String statusText;

        AjaxResponseCode(String statusText) {
            this.statusText = statusText;
        }

        public String getStatusText() {
            return statusText;
        }
    }
}
