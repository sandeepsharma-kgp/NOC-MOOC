package io.kgp.myblog;

import com.google.gson.annotations.SerializedName;

/**
 * Created by BREEZY on 15-Mar-17.
 */

public class AuthenticationRequest {

    @SerializedName("username")
    String username;

    @SerializedName("password")
    String password;

    public AuthenticationRequest(String username,String password){
        this.username=username;
        this.password=password;
    }

}
