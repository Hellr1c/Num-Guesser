package alvaro.mt.seatworktwu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvHint;
    private EditText etGuess;
    private Button btnSubmit;

    private int randomNumber;
    private int numberOfAttempts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHint = findViewById(R.id.tv_hint);
        etGuess = findViewById(R.id.et_guess);
        btnSubmit = findViewById(R.id.btn_submit);

        // Generate a random number between 1 and 100
        randomNumber = (int) (Math.random() * 100) + 1;

        // Set the number of attempts to 0
        numberOfAttempts = 0;

        // Set the click listener for the submit button
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the user's guess
                int guess = Integer.parseInt(etGuess.getText().toString());

                // Check if the user input is invalid
                if (guess < 1 || guess > 100) {
                    // Display an error message to the user
                    tvHint.setText("Please enter a number between 1 and 100.");
                    return;
                }

                // Check if the guess is correct
                if (guess == randomNumber) {
                    // The user guessed correctly
                    tvHint.setText("You correctly guessed " + randomNumber + " in: " + numberOfAttempts + " attempts.");
                } else {
                    // The user guessed incorrectly
                    numberOfAttempts++;

                    // Give the user a hint
                    if (guess > randomNumber) {
                        tvHint.setText("LOWER");
                    } else {
                        tvHint.setText("HIGHER");
                    }
                }

                // Check if the user has reached the maximum number of attempts
                if (numberOfAttempts == 100) {
                    // The user lost
                    tvHint.setText("You lost! The correct number was " + randomNumber);
                }
            }
        });
    }
}