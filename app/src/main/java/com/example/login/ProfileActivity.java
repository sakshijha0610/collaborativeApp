package com.example.login;

import android.content.Intent;
//import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.widget.ImageView;
import android.widget.TextView;
//import android.net.Uri;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
//import com.google.android.gms.tasks.Tasks;


public class ProfileActivity extends AppCompatActivity  {
    Button logoutBtn;
    TextView textName,textEmail,userId;
   // ImageView profileImage;
    private GoogleSignInClient mGoogleSignInClient;
    private GoogleSignInOptions gso;

   /* private void gotoMainActivity(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileactivity);

         gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        textName = findViewById(R.id.name);
        textEmail = findViewById(R.id.email);
        userId =findViewById(R.id.userId);
        logoutBtn = findViewById(R.id.logoutBtn);


        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if (acct != null) {
            String personName = acct.getDisplayName();
           // String personGivenName = acct.getGivenName();
            //String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            textName.setText(personName);
            textEmail.setText(personEmail);

        }


        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
                //signOut();
            }
        });
    }


  /*  private void signOut() {
        mGoogleSignInClient.signOut().addOnCompleteListener(this, new OnCompleteListener<gso>() {
                    @Override
                    public void onComplete(@NonNull Task<gso> task) {

                        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });

    }*/
}