package io.kgp.myblog;

import com.google.gson.annotations.SerializedName;

/**
 * Created by BREEZY on 15-Mar-17.
 */

public class ErrorResponse {

    @SerializedName("error")
    String error;

    public String getError() {
        return error;
    }
}
