package com.elestirbeni.countdown;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CountDownActivity extends Activity implements View.OnClickListener {
	/** Called when the activity is first created. */
	Button num1, num2, num3, num4, num5, num6;
	Button add, sub, mul, div;
	Button reset;
	TextView leftTime, targetValue;

	int rand1 = 0, rand2 = 0, rand3 = 0, rand4 = 0, rand5 = 0, rand6 = 0,
			randTarget = 0;

	int time = 90;

	Handler handler;
	MyRunnable runnable;

	int temp1 = 0;
	int temp2 = 0;
	int calc = 0; // 0=>nothing selected. 1=>+, 2=>-, 3=>x, 4=>/ for
					// calculation.

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		initialize();
		setRandomNumbersToButtons();

		handler = new Handler();
		runnable = new MyRunnable();

		new Thread(runnable).start();

	}

	public void initialize() {
		// it is very important to set the time for each activity creating.
		time = 90;

		num1 = (Button) findViewById(R.id.bNum1);
		num2 = (Button) findViewById(R.id.bNum2);
		num3 = (Button) findViewById(R.id.bNum3);
		num4 = (Button) findViewById(R.id.bNum4);
		num5 = (Button) findViewById(R.id.bNum5);
		num6 = (Button) findViewById(R.id.bNum6);

		add = (Button) findViewById(R.id.bAdd);
		sub = (Button) findViewById(R.id.bSub);
		mul = (Button) findViewById(R.id.bMul);
		div = (Button) findViewById(R.id.bDiv);

		reset = (Button) findViewById(R.id.bReset);

		leftTime = (TextView) findViewById(R.id.tvTime);
		targetValue = (TextView) findViewById(R.id.tvTarget);

		num1.setOnClickListener(this);
		num2.setOnClickListener(this);
		num3.setOnClickListener(this);
		num4.setOnClickListener(this);
		num5.setOnClickListener(this);
		num6.setOnClickListener(this);

		add.setOnClickListener(this);
		sub.setOnClickListener(this);
		mul.setOnClickListener(this);
		div.setOnClickListener(this);

		reset.setOnClickListener(this);
	}

	private void setRandomNumbersToButtons() {
		Random rand = new Random();
		rand1 = rand.nextInt(9) + 1;
		rand2 = rand.nextInt(9) + 1;
		rand3 = rand.nextInt(9) + 1;
		rand4 = rand.nextInt(9) + 1;
		rand5 = rand.nextInt(9) + 1;

		rand6 = rand.nextInt(50) + 50;
		num1.setText(rand1 + "");
		num2.setText(rand2 + "");
		num3.setText(rand3 + "");
		num4.setText(rand4 + "");
		num5.setText(rand5 + "");
		num6.setText(rand6 + "");

		targetValue.setText(rand.nextInt(500) + 500 + "");

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bNum1:
			if (temp1 == 0) {
				String str = num1.getText().toString();
				temp1 = Integer.parseInt(str);
				num1.setEnabled(false);
			} else if (temp2 == 0 && temp1 != 0) {
				if (calc == 0) {
					Context context = getApplicationContext();
					CharSequence text = "First you need to choose the calculation!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
					toast.show();
				} else {
					String str = num1.getText().toString();
					temp2 = Integer.parseInt(str);
					// if you reach, means there is no problem to make the calc.
					switch (calc) {
					case 1:
						num1.setText(temp1 + temp2 + "");
						break;
					case 2:
						num1.setText(temp1 - temp2 + "");
						break;
					case 3:
						num1.setText(temp1 * temp2 + "");
						break;
					case 4:
						num1.setText(temp1 / temp2 + "");
						break;
					}
					if (num1.getText().toString()
							.equals(targetValue.toString())) {
						Intent won = new Intent("com.elestirbeni.countdown.WON");
						startActivity(won);
					}
					num1.setEnabled(true);
					temp1 = 0;
					temp2 = 0;
					calc = 0;
				}
			}
			break;
		case R.id.bNum2:

			if (temp1 == 0) {
				String str = num2.getText().toString();
				temp1 = Integer.parseInt(str);
				num2.setEnabled(false);
			} else if (temp2 == 0 && temp1 != 0) {
				if (calc == 0) {
					Context context = getApplicationContext();
					CharSequence text = "First you need to choose the calculation!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
					toast.show();
				} else {
					String str = num2.getText().toString();
					temp2 = Integer.parseInt(str);

					// if you reach, means there is no problem to make the calc.
					switch (calc) {
					case 1:
						num2.setText(temp1 + temp2 + "");
						break;
					case 2:
						num2.setText(temp1 - temp2 + "");
						break;
					case 3:
						num2.setText(temp1 * temp2 + "");
						break;
					case 4:
						num2.setText(temp1 / temp2 + "");
						break;
					}
					if (num2.getText().toString()
							.equals(targetValue.getText().toString())) {
						Intent won = new Intent("com.elestirbeni.countdown.WON");
						startActivity(won);
					}
					num2.setEnabled(true);
					temp1 = 0;
					temp2 = 0;
					calc = 0;
				}
			}

			break;
		case R.id.bNum3:

			if (temp1 == 0) {
				String str = num3.getText().toString();
				temp1 = Integer.parseInt(str);
				num3.setEnabled(false);
			} else if (temp2 == 0 && temp1 != 0) {
				if (calc == 0) {
					Context context = getApplicationContext();
					CharSequence text = "First you need to choose the calculation!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
					toast.show();
				} else {
					String str = num3.getText().toString();
					temp2 = Integer.parseInt(str);

					// if you reach, means there is no problem to make the calc.
					switch (calc) {
					case 1:
						num3.setText(temp1 + temp2 + "");
						break;
					case 2:
						num3.setText(temp1 - temp2 + "");
						break;
					case 3:
						num3.setText(temp1 * temp2 + "");
						break;
					case 4:
						num3.setText(temp1 / temp2 + "");
						break;
					}
					if (num3.getText().toString()
							.equals(targetValue.getText().toString())) {
						Intent won = new Intent("com.elestirbeni.countdown.WON"); // CountDownActivity
						startActivity(won);
					}
					num3.setEnabled(true);
					temp1 = 0;
					temp2 = 0;
					calc = 0;
				}
			}

			break;
		case R.id.bNum4:

			if (temp1 == 0) {
				String str = num4.getText().toString();
				temp1 = Integer.parseInt(str);
				num4.setEnabled(false);
			} else if (temp2 == 0 && temp1 != 0) {
				if (calc == 0) {
					Context context = getApplicationContext();
					CharSequence text = "First you need to choose the calculation!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
					toast.show();
				} else {
					String str = num4.getText().toString();
					temp2 = Integer.parseInt(str);

					// if you reach, means there is no problem to make the calc.
					switch (calc) {
					case 1:
						num4.setText(temp1 + temp2 + "");
						break;
					case 2:
						num4.setText(temp1 - temp2 + "");
						break;
					case 3:
						num4.setText(temp1 * temp2 + "");
						break;
					case 4:
						num4.setText(temp1 / temp2 + "");
						break;
					}
					if (num4.getText().toString()
							.equals(targetValue.getText().toString())) {
						Intent won = new Intent("com.elestirbeni.countdown.WON"); // CountDownActivity
						startActivity(won);
					}
					num4.setEnabled(true);
					temp1 = 0;
					temp2 = 0;
					calc = 0;
				}
			}

			break;
		case R.id.bNum5:

			if (temp1 == 0) {
				String str = num5.getText().toString();
				temp1 = Integer.parseInt(str);
				num5.setEnabled(false);
			} else if (temp2 == 0 && temp1 != 0) {
				if (calc == 0) {
					Context context = getApplicationContext();
					CharSequence text = "First you need to choose the calculation!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
					toast.show();
				} else {
					String str = num5.getText().toString();
					temp2 = Integer.parseInt(str);

					// if you reach, means there is no problem to make the calc.
					switch (calc) {
					case 1:
						num5.setText(temp1 + temp2 + "");
						break;
					case 2:
						num5.setText(temp1 - temp2 + "");
						break;
					case 3:
						num5.setText(temp1 * temp2 + "");
						break;
					case 4:
						num5.setText(temp1 / temp2 + "");
						break;
					}
					if (num5.getText().toString()
							.equals(targetValue.getText().toString())) {
						Intent won = new Intent("com.elestirbeni.countdown.WON"); // CountDownActivity
						startActivity(won);
					}
					num5.setEnabled(true);
					temp1 = 0;
					temp2 = 0;
					calc = 0;
				}
			}

			break;
		case R.id.bNum6:

			if (temp1 == 0) {
				String str = num6.getText().toString();
				temp1 = Integer.parseInt(str);
				num6.setEnabled(false);
			} else if (temp2 == 0 && temp1 != 0) {
				if (calc == 0) {
					Context context = getApplicationContext();
					CharSequence text = "First you need to choose the calculation!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
					toast.show();
				} else {
					String str = num6.getText().toString();
					temp2 = Integer.parseInt(str);

					// if you reach, means there is no problem to make the calc.
					switch (calc) {
					case 1:
						num6.setText(temp1 + temp2 + "");
						break;
					case 2:
						num6.setText(temp1 - temp2 + "");
						break;
					case 3:
						num6.setText(temp1 * temp2 + "");
						break;
					case 4:
						num6.setText(temp1 / temp2 + "");
						break;
					}
					if (num6.getText().toString()
							.equals(targetValue.getText().toString())) {
						Intent won = new Intent("com.elestirbeni.countdown.WON"); // CountDownActivity
						startActivity(won);
					}
					num6.setEnabled(true);
					temp1 = 0;
					temp2 = 0;
					calc = 0;
				}
			}

			break;

		case R.id.bAdd:
			if (temp1 != 0 && temp2 == 0)
				calc = 1;
			else {
				Context context = getApplicationContext();
				CharSequence text = "First you need to choose the 1st number!";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.show();
			}
			break;
		case R.id.bSub:
			if (temp1 != 0 && temp2 == 0)
				calc = 2;
			else {
				Context context = getApplicationContext();
				CharSequence text = "First you need to choose the 1st number!";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.show();
			}

			break;
		case R.id.bMul:
			if (temp1 != 0 && temp2 == 0)
				calc = 3;
			else {
				Context context = getApplicationContext();
				CharSequence text = "First you need to choose the 1st number!";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.show();
			}

			break;
		case R.id.bDiv:
			if (temp1 != 0 && temp2 == 0)
				calc = 4;
			else {
				Context context = getApplicationContext();
				CharSequence text = "First you need to choose the 1st number!";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.show();
			}

			break;
		case R.id.bReset: // reset button clicked.

			Context context = getApplicationContext();
			CharSequence text = "Reset!";
			int duration = Toast.LENGTH_SHORT;

			Toast toast = Toast.makeText(context, text, duration);
			toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
			toast.show();

			num1.setEnabled(true);
			num2.setEnabled(true);
			num3.setEnabled(true);
			num4.setEnabled(true);
			num5.setEnabled(true);
			num6.setEnabled(true);

			num1.setText(rand1 + "");
			num2.setText(rand2 + "");
			num3.setText(rand3 + "");
			num4.setText(rand4 + "");
			num5.setText(rand5 + "");
			num6.setText(rand6 + "");

			temp1 = 0;
			temp2 = 0;
			calc = 0;
			break;
		}

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		// handler.removeCallbacks(runnable);
		Intent openMenu = new Intent("com.elestirbeni.countdown.MENU");
		startActivity(openMenu);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		handler.removeCallbacks(runnable);
		finish();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		// handler.removeCallbacks(runnable);
		super.onDestroy();
		runnable.killRunnable();

	}

	/*
	 * @Override protected void onRestart() { // TODO Auto-generated method stub
	 * super.onRestart(); }
	 * 
	 * @Override protected void onResume() { // TODO Auto-generated method stub
	 * super.onResume(); time = 90; }
	 * 
	 * @Override protected void onStart() { // TODO Auto-generated method stub
	 * super.onStart(); }
	 * 
	 * @Override protected void onStop() { // TODO Auto-generated method stub
	 * super.onStop(); handler.removeCallbacks(runnable); }
	 */
	public class MyRunnable implements Runnable {
		private boolean killMe = false;

		public void run() {
			for (int i = time; i >= 0; i--) {
				if (killMe == true) {
					return;
				}
				final int value = i;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (!(value >= 0)) {
					Intent lost = new Intent("com.elestirbeni.countdown.LOST");
					startActivity(lost);
				}
				handler.post(new Runnable() {
					public void run() {
						leftTime.setText(value + "");
					}
				});
			}
			Intent lost = new Intent("com.elestirbeni.countdown.LOST");
			startActivity(lost);

		}

		public void killRunnable() {
			killMe = true;
		}

	}

}
