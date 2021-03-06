package me.blr3.parsestagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    public EditText username;
    public EditText password;
    public EditText email;
    public EditText phonenum;
    public Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



        username = (EditText) findViewById(R.id.etEUsername);
        password = (EditText) findViewById(R.id.etSPassword);
        email = (EditText) findViewById(R.id.etEmail);
        phonenum = (EditText) findViewById(R.id.etPhoneNum);
        register = (Button) findViewById(R.id.btnSignUp);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the ParseUser
                ParseUser user = new ParseUser();
                // Set core properties
                user.setUsername(username.getText().toString());
                user.setPassword(password.getText().toString());
                user.setEmail(email.getText().toString());
                // Set custom properties
                user.put("phone", phonenum.getText().toString());

                // logincallback so we know when network request was completed
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Log.d("SignUpActivity", "Sign Up successful");
                            final Intent intent = new Intent(SignUpActivity.this, TimelineActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Log.e("SignUpActivity", "Sign Up failure");
                            e.printStackTrace();
                        }
                    }
                });


            }
        });


        // Invoke signUpInBackground
    }
}
