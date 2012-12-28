package com.elestirbeni.countdown;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends Activity implements View.OnClickListener {

	Button bStart;
	Button bHow;
	Button bAbout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		initialize();

	}

	public void initialize() {
		bStart = (Button) findViewById(R.id.bStart);
		bHow = (Button) findViewById(R.id.bHowTo);
		bAbout = (Button) findViewById(R.id.bAbout);

		bStart.setOnClickListener(this);
		bHow.setOnClickListener(this);
		bAbout.setOnClickListener(this);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bStart:
			Intent openGame = new Intent(
					"com.elestirbeni.countdown.COUNTDOWNACTIVITY");
			startActivity(openGame);
			break;
		case R.id.bHowTo:
			Intent openHow = new Intent("com.elestirbeni.countdown.HOW");
			startActivity(openHow);
			break;
		case R.id.bAbout:
			Intent openAbout = new Intent("com.elestirbeni.countdown.ABOUT");
			startActivity(openAbout);
			break;
		}

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		// handler.removeCallbacks(runnable);
		finish();
	}

}
