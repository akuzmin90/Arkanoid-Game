package com.alex.arkanoid.activity;

import roboguice.activity.RoboActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.alex.arkanoid.R;
import com.alex.arkanoid.utils.SoundedClickListener;

public class MenuActivity extends RoboActivity {
	
	private MediaPlayer click;
	private MediaPlayer backgroundMusic;
	private int musicPosition = 0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        
        click = MediaPlayer.create(this, R.raw.click_sound);
        backgroundMusic = MediaPlayer.create(this, R.raw.menu_music);
        
        View newGameButton = findViewById(R.id.newGameButton);
        newGameButton.setOnClickListener(new SoundedClickListener(click) {
			@Override
			public void onSoundClick(View arg0) {
				onStartGameClick();
			}
		});

        View aboutButton = findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(new SoundedClickListener(click) {
			@Override
			public void onSoundClick(View arg0) {
				
			}
		});

        View exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new SoundedClickListener(click) {
			@Override
			public void onSoundClick(View arg0) {
				finish();
			}
		});
        
    }

    @Override
    public void onResume() {
    	super.onResume();
    	if (null == backgroundMusic) {
    		backgroundMusic = MediaPlayer.create(this, R.raw.menu_music);
    	}
    	backgroundMusic.seekTo(musicPosition);
    	backgroundMusic.start();
    	backgroundMusic.setLooping(true);
    }

    @Override
    public void onPause() {
    	super.onPause();
    	backgroundMusic.stop();
    	backgroundMusic.release();
    	backgroundMusic = null;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
    	musicPosition = backgroundMusic.getCurrentPosition();
    	super.onSaveInstanceState(savedInstanceState);
    }

    private void onStartGameClick() {
    	Intent gameIntent = new Intent(this, GameActivity.class);
    	startActivity(gameIntent);
    }

}
