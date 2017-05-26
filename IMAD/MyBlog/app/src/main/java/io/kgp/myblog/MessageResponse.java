package io.kgp.myblog;

import com.google.gson.annotations.SerializedName;

/**
 * Created by BREEZY on 15-Mar-17.
 */

public class MessageResponse {

    @SerializedName("message")
    String message;

    public String getMessage(){
        return message;
    }
}
