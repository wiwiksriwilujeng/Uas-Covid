
package com.nguga.tugascovid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Deaths {

    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("detail")
    @Expose
    private String detail;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
