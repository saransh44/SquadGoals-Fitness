package guptagaming.com.wireframe;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUp extends ActionBarActivity {

    private EditText mUsername;
    private EditText mPassword;
    private EditText mEmail;
    private EditText mRe;
    private EditText mDate;
    private Button Submit;
    private Spinner dob;
    private static RadioGroup gender;
    private static RadioButton genderSelect;

    private Boolean isMale = true;
    int uDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_sign_up);
        //Intent intent = getIntent();
        //String name = intent.getStringExtra(getString(R.string.key_name));

        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        mEmail = (EditText) findViewById(R.id.email);
        Submit = (Button) findViewById(R.id.Confirmation);
        mRe = (EditText) findViewById(R.id.Re);
        mDate = (EditText) findViewById(R.id.birth);
        //dob = (Spinner) findViewById(R.id.time);
        gender = (RadioGroup) findViewById(R.id.Gender);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uName = mUsername.getText().toString();
                String uPass = mPassword.getText().toString();
                String mReEnter = mRe.getText().toString();
                String uEmail = mEmail.getText().toString();

                if(mDate.getText().toString() != null) {
                    uDate = Integer.parseInt(mDate.getText().toString());
                }

                int selectedId = gender.getCheckedRadioButtonId();
                genderSelect = (RadioButton) findViewById(selectedId);
                String gend = genderSelect.getText().toString();

                if (gend.equals("Female"))
                {
                    isMale = false;
                }

                if(!mReEnter.equals(uPass))
                {
                    //Toast.makeText(secondView.this, gend, Toast.LENGTH_LONG).show();
                    Toast.makeText(SignUp.this, "Password and Re-Entered password don't match", Toast.LENGTH_LONG).show();
                }
                else {
                    if (uDate > 1915)
                    {

                        final ParseUser user = new ParseUser();
                        user.setUsername(uName);
                        user.setPassword(uPass);
                        user.setEmail(uEmail);
                        user.put("birthDate", uDate);
                        user.put("genderBool", isMale);
                        //ParseUser user = new Member(uName, uPass, uEmail, uDate, isMale);
                        //final Member user = new Member(uName, uPass, uEmail, uDate, isMale);
                        //user = (ParseUser) user;

                        user.signUpInBackground(new SignUpCallback() {
                            @Override
                            public void done(com.parse.ParseException e) {
                                if (e == null) {
                                    Toast.makeText(SignUp.this, "Sign up Successful! Hooray!", Toast.LENGTH_LONG).show();
                                    LandingPage();

                                } else {
                                    Toast.makeText(SignUp.this, "Oh No! Sign up failed.", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                    else
                    {
                        Toast.makeText(SignUp.this, "Invalid Birthdate", Toast.LENGTH_LONG).show();
                    }
                }
            }

        });

    }

    public void LandingPage() {
        Intent i = new Intent(this, LandingPage.class);
        //goalsI(i);
        //i.putExtra("user", (Serializable) user);
        startActivity(i);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
