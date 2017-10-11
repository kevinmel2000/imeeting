package com.imeeting.website.domain;

/**
 * Created by mrapry on 10/10/17.
 */
public class Find {

    private String key;
    private String value;

    public Find(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Find() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
