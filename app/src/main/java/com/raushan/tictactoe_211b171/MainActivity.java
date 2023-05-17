package com.raushan.tictactoe_211b171;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isWinner = false;
    int imageClicked =-1;
    int player = 1; // player1 is cross2
    int[][] winningstates = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
    int[] gamestate = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

    public void load(View view) {

        ImageView v = (ImageView) view;
        int tag = Integer.parseInt(v.getTag().toString());
        imageClicked = gamestate[tag];
        if (isWinner == false && imageClicked == -1) {
            if (player == 1) {
                v.setImageResource(R.drawable.cross2);
                gamestate[tag] = player;
                Toast.makeText(this, tag + "" + "cross", Toast.LENGTH_SHORT).show();
                player = 0;//zero player
            } else {
                v.setImageResource(R.drawable.zero2);
                Toast.makeText(this, tag + "" + "zero", Toast.LENGTH_SHORT).show();
                player = 1;
            }
            for (int i = 0; i < winningstates.length; i++) {
                if (gamestate[winningstates[i][0]] == gamestate[winningstates[i][1]] && gamestate[winningstates[i][1]] == gamestate[winningstates[i][2]] && gamestate[winningstates[i][0]] > -1) {
                    Toast.makeText(this, "winning is" + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    isWinner = true;
                }
            }
        }
    }
    public void reset(View view) {
        GridLayout gridlayout=findViewById(R.id.gridlayout);
        int total_images=gridlayout.getChildCount();
        for (int i=0;i< total_images;i++){
            ImageView v = (ImageView) gridlayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        isWinner=false;
        imageClicked =-1;
        player=1;
        for (int i=0;i<gamestate.length;i++)
            gamestate[i]=-1;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}