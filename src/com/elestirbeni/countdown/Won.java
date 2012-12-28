package com.elestirbeni.countdown;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Won extends Activity implements View.OnClickListener {
	Button playAgain;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.endwon);
		playAgain = (Button) findViewById(R.id.bPlayAgainWon);
		playAgain.setOnClickListener(this);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent newGame = new Intent(
				"com.elestirbeni.countdown.COUNTDOWNACTIVITY"); // CountDownActivity
		startActivity(newGame);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent openMenu = new Intent("com.elestirbeni.countdown.MENU");
		startActivity(openMenu);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

	}

}
