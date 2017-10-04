package com.umang.developer.scarnesdice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Instance variables to store scores of user and computer
    private int userOverallScore;
    private int userTurnScore;
    private int computerOverallScore;
    private int computerTurnScore;

    //Instance variables for score textview elements
    private TextView userOverallScoreTextView;
    private TextView computerOverallScoreTextView;
    private TextView userTurnScoreTextView;
    private TextView computerTurnScoreTextView;

    //Instance variable for the dice imageview element
    private ImageView diceImageView;

    //Instance variables for button elements
    private Button rollButton;
    private Button holdButton;
    private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hooking the XML code with the Java objects
        userOverallScoreTextView = (TextView) findViewById(R.id.your_score_text_view);
        computerOverallScoreTextView = (TextView) findViewById(R.id.com_score_text_view);
        userTurnScoreTextView = (TextView) findViewById(R.id.user_turn_score);
        computerTurnScoreTextView = (TextView) findViewById(R.id.com_turn_score);
        diceImageView = (ImageView) findViewById(R.id.dice_image_view);
        rollButton = (Button) findViewById(R.id.roll_button);
        holdButton = (Button) findViewById(R.id.hold_button);
        resetButton = (Button) findViewById(R.id.reset_button);


    }

    /**
     * This method is called when the ROLL button is clicked
     *
     * @param view is the ROLL button
     */
    public void rollDice(View view) {
        //Get random dice number from the getDiceNumber() method
        int diceNumber = getDiceNumber();

        //Displaying correct dice face according to the dice number
        displayDiceFace(diceNumber);

        //User playing method
        playUserTurn(diceNumber);

    }


    /**
     * This method is used to play by the user
     *
     * @param diceNumber is the number on the die face
     */
    private void playUserTurn(int diceNumber) {

        //Logic if the diceNumber is not 1
        if (diceNumber != 1) {

            //Updating the userTurnScore with incrementing it with the diceNumber
            userTurnScore += diceNumber;

            //Updating the userTurnScoreTextView with the current userTurnScore value
            updateUserTurnScoreTextView();
        } else {

            //If the diceNumber becomes one, then update the userOverallScore
            userOverallScore = userTurnScore;

            //Resets the userTurnScore to zero
            userTurnScore = 0;

            //Updating the userTurnScoreTextView with the current userTurnScore value
            updateUserTurnScoreTextView();

            //Updating the userOverallScoreTextView wit the current userOverallScore value
            updateUserOverallScoreTextView();
        }
    }

    /**
     * This method updates the userOverallScoreTextView with the current userOverallScore value
     */
    private void updateUserOverallScoreTextView() {
        userOverallScoreTextView.setText("" + userOverallScore);
    }


    /**
     * This method resets the scores when the user clicks the RESET button.
     *
     * @param view is the Reset Button
     */
    public void resetGame(View view) {
        //Assigning zero to all the score counter variables
        userOverallScore = 0;
        userTurnScore = 0;
        computerOverallScore = 0;
        computerTurnScore = 0;

        //Displaying all reset scores to all the score textviews
        userOverallScoreTextView.setText("" + userOverallScore);
        userTurnScoreTextView.setText("" + userTurnScore);
        computerOverallScoreTextView.setText("" + computerOverallScore);
        computerTurnScoreTextView.setText("" + computerTurnScore);
    }


    /**
     * This method randomly chooses a  number between 1 to 6 and returns it.
     *
     * @return Dice number in the range of 1 to 6
     */
    private int getDiceNumber() {
        //Using Math.random() for generating the random number from 1 to 6
        return (1 + (int) (Math.random() * ((6 - 1) + 1)));
    }

    /**
     * This method updates the userTurnScoreTextView with the userTurnScore value
     */
    private void updateUserTurnScoreTextView() {
        userTurnScoreTextView.setText("" + userTurnScore);
    }

    /**
     * This method displaying the dice face according to the dice number in parameter
     *
     * @param diceNumber is the dice number on the dice to be displayed
     */
    private void displayDiceFace(int diceNumber) {
        switch (diceNumber) {
            case 1:
                diceImageView.setImageResource(R.drawable.dice1);
                break;
            case 2:
                diceImageView.setImageResource(R.drawable.dice2);
                break;
            case 3:
                diceImageView.setImageResource(R.drawable.dice3);
                break;
            case 4:
                diceImageView.setImageResource(R.drawable.dice4);
                break;
            case 5:
                diceImageView.setImageResource(R.drawable.dice5);
                break;
            case 6:
                diceImageView.setImageResource(R.drawable.dice6);
                break;
            default:
                diceImageView.destroyDrawingCache();
        }
    }

}
