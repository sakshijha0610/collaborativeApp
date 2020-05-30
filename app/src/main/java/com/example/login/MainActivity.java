package com.example.login;

//import android.util.Log;
import android.content.Intent;
//import android.support.annotation.NonNull;
import androidx.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
//import android.widget.TextView;
//import com.google.android.gms.tasks.Task;
//import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
//import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.auth.api.Auth;
//import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;

public class MainActivity extends AppCompatActivity  {
    Button signInButton;
    private GoogleSignInClient mGoogleSignInClient;
  //  TextView textView;
    private static final int RC_SIGN_IN = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoogleSignInOptions gso =  new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

    //    GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        signInButton= findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {

            GoogleSignInResult result;
            result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);

            //Task task = GoogleSignIn.getSignedInAccountFromIntent(data);
            //assert result != null;
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {

        if(result!=null && result.isSuccess()){
            updateUI();
        }else{
            Toast.makeText(getApplicationContext(),"Sign in cancel",Toast.LENGTH_LONG).show();
        }

        /*try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.

            updateUI();

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("Warning", "signInResult:failed code=" + e.getStatusCode());

        }*/
    }

    public void updateUI(){
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(intent);
    }


   /*
   MIGHT INCLUDE
   @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }*/



}
