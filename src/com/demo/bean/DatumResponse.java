package com.demo.bean;

public class DatumResponse extends BaseResponse {
    private Object data;

    public DatumResponse() {
        super();
    }
    
    public DatumResponse (Object date) {
        this.data = date;
    }

    public DatumResponse(Integer code) {
        super(code);
    }

    public DatumResponse(Integer code, String message) {
        super(code, message);
    }

    public DatumResponse setDatum(Object date) {
        this.data = date;
        return this;
    }

    public Object getDatum() {
        return data;
    }
}
