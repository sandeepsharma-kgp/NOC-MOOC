package io.kgp.myblog;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.icu.text.DateFormat;
import android.os.AsyncTask;
import android.support.annotation.BoolRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthenticationActivity extends AppCompatActivity {

    EditText username , password;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        Button signInButton = (Button) findViewById(R.id.signInButton);
        signInButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (isFormValid()){
                    //perform sign in
                    performSignIn();
                }

            }
        });

        Button registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (isFormValid()){
                    //perform registration
                    performRegistration();
                }
            }
        });

        //Initializing progress dialog
        progressDialog=new ProgressDialog(this);
        progressDialog.setIndeterminate(true); // to show for circular indicator
        progressDialog.setMessage("Plese Wait");
    }

    private Boolean isFormValid(){
        if(username.getText().toString().trim().isEmpty()){
            Toast.makeText(this,"Username can't be left empty",Toast.LENGTH_LONG).show();
            return false;
        }

        if(password.getText().toString().trim().isEmpty()){
            Toast.makeText(this,"Password can't be left empty",Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    private void performSignIn(){
//        //mock an api call for signing in // async task is used for this
//        new SignInTask().execute(username.getText().toString(),password.getText().toString());
        showProgressDialog(true);
        ApiManager.getApiInterface().login(new AuthenticationRequest(username.getText().toString().trim(),password.getText().toString().trim()))
                .enqueue(new Callback<MessageResponse>() {
                    @Override
                    public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {
                        showProgressDialog(false);
                        if (response.isSuccessful()){
                            showAlert("Welcome",response.body().getMessage());
                        } else {
                            try {
                                String errorMessage = response.errorBody().string();

                                try {
                                    ErrorResponse errorResponse = new Gson().fromJson(errorMessage,ErrorResponse.class);
                                    showAlert("Sign-In Failed",errorResponse.getError());
                                } catch(JsonSyntaxException jsonException){
                                    jsonException.printStackTrace();
                                    showAlert("Sign-In Failed","Something went wrong");
                                }


                            } catch (IOException e) {
                                e.printStackTrace();
                                showAlert("Sign-In Failed","Something went wrong");
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<MessageResponse> call, Throwable t) {

                    }
                });
    }

    private void performRegistration(){

        showProgressDialog(true);
        ApiManager.getApiInterface().registration(new AuthenticationRequest(username.getText().toString().trim(),password.getText().toString().trim()))
                .enqueue(new Callback<MessageResponse>() {
                    @Override
                    public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {
                        showProgressDialog(false);
                        if (response.isSuccessful()){
                            showAlert("Welcome",response.body().getMessage());
                        } else {
                            try {
                                String errorMessage = response.errorBody().string();

                                try {
                                    ErrorResponse errorResponse = new Gson().fromJson(errorMessage,ErrorResponse.class);
                                    showAlert("Registration Failed",errorResponse.getError());
                                }  catch(JsonSyntaxException jsonException){
                                    jsonException.printStackTrace();
                                    showAlert("Registration Failed","Something went wrong");
                                }

                            } catch (IOException e) {
                                e.printStackTrace();
                                showAlert("Registration Failed","Something went wrong");
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<MessageResponse> call, Throwable t) {

                    }
                });

    }

    private void showProgressDialog(Boolean shouldShould){
        if (shouldShould){
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }

    }

    private void showAlert(String title, String message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    class SignInTask extends AsyncTask<String,Void,Boolean>{

        String mockUsername="test";
        String mockPassword="password";

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            showProgressDialog(true);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean){
            super.onPostExecute(aBoolean);
            showProgressDialog(false);

            if (aBoolean){
                showAlert("Welcome","You have successfully logged in");
            } else {
                showAlert("Failed","Username/Password is Incorrect!!");
            }
        }

        @Override
        protected Boolean doInBackground(String... strings){
            String username=strings[0];
            String password= strings[1];

//            //do something with this
//
//            return true; // or false
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }


            return username.contentEquals(mockUsername) && password.contentEquals(mockPassword);
        }

    }

}
