package com.android.norika.play.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.norika.play.R;

public class ThinkingMyselfActivity extends Activity {
	private TextView[] tvs = new TextView[4];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_three_month);

		tvs[0] = (TextView) findViewById(R.id.three_thinking_tv1);
		tvs[1] = (TextView) findViewById(R.id.three_thinking_tv2);
		tvs[2] = (TextView) findViewById(R.id.three_thinking_tv3);
		tvs[3] = (TextView) findViewById(R.id.three_thinking_tv4);

		freshValue();
	}

	private void freshValue() {
		tvs[0].setText("积极思考\n依附可触摸现实\n赋予想象力");
		tvs[1].setText("实现梦想\n追求技术极致\n远离人之反感");
		tvs[2].setText("唯一的对手就是自己\n被自己投射过的别人\n被自己投射过的世界");
		tvs[3].setText("学的多，知道的多\n知道的多，忘记的多\n忘记的多，知道的'少'");
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		this.finish();
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
	}

}
