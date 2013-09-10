package com.bignerdranch.android.leakapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";

	private static Leaky leak;

	class Leaky {
		void doSomething() {
			Log.e(TAG, "I'm leaky");
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (leak == null) {
			leak = new Leaky();
			leak.doSomething();
		}
	}
}
