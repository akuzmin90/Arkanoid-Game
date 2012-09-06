package com.alex.arkanoid.utils;

import android.media.MediaPlayer;
import android.view.View;
import android.view.View.OnClickListener;

public abstract class SoundedClickListener implements OnClickListener {

	private MediaPlayer click;
	
	public SoundedClickListener(MediaPlayer click) {
		super();
		this.click = click;
	}
	
	public void onClick(View arg0) {
		click.seekTo(0);
		click.start();
		onSoundClick(arg0);
	}
	
	public abstract void onSoundClick(View arg0);

}
