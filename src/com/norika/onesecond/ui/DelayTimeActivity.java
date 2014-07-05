package com.norika.onesecond.ui;

import com.norika.onesecond.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DelayTimeActivity extends Activity {
	private TextView tvs[] = new TextView[5];
	private TextView tvs_num[] = new TextView[5];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delay_time);

		tvs[0] = (TextView) findViewById(R.id.delay_time_reason_tv1);
		tvs[1] = (TextView) findViewById(R.id.delay_time_reason_tv2);
		tvs[2] = (TextView) findViewById(R.id.delay_time_reason_tv3);
		tvs[3] = (TextView) findViewById(R.id.delay_time_reason_tv4);
		tvs[4] = (TextView) findViewById(R.id.delay_time_reason_tv5);

		tvs_num[0] = (TextView) findViewById(R.id.delay_time_reason_num_tv1);
		tvs_num[1] = (TextView) findViewById(R.id.delay_time_reason_num_tv2);
		tvs_num[2] = (TextView) findViewById(R.id.delay_time_reason_num_tv3);
		tvs_num[3] = (TextView) findViewById(R.id.delay_time_reason_num_tv4);
		tvs_num[4] = (TextView) findViewById(R.id.delay_time_reason_num_tv5);

		initValue();
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		this.finish();
		overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
	}

	public void initValue() {
		tvs[0].setText("琐事优先");
		tvs[1].setText("分析问题烦乱\n无代码，猜测，不思考");
		tvs[2].setText("专注度不够\n注意力分散");
		tvs[3].setText("缺乏利他之心\n去粗取精，对他人认可");
		tvs[4].setText("对微难的退缩");

		tvs_num[0].setText("+1");
		tvs_num[1].setText("+4");
		tvs_num[2].setText("+3");
		tvs_num[3].setText("+1");
		tvs_num[4].setText("+1");
	}

}
