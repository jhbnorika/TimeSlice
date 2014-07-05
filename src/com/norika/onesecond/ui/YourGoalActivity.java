package com.norika.onesecond.ui;

import com.norika.onesecond.R;
import com.norika.onesecond.model.ColorType;
import com.norika.onesecond.model.TASK_TYPE;
import com.norika.onesecond.utils.CommonUtils;
import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class YourGoalActivity extends Activity implements OnClickListener {
	private TextView tvs[] = new TextView[6];
	private boolean isDefault = true;
	private TextView changingTime;
	private BroadcastReceiver dataChangedReceiver;
	private static final String TIMECHANGE = Intent.ACTION_DATE_CHANGED;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_your_goal);

		tvs[0] = (TextView) findViewById(R.id.your_three_month_goal);
		tvs[1] = (TextView) findViewById(R.id.your_month_goal);
		tvs[2] = (TextView) findViewById(R.id.your_week_goal);
		tvs[3] = (TextView) findViewById(R.id.your_day_goal);
		tvs[4] = (TextView) findViewById(R.id.your_not_need);
		tvs[5] = (TextView) findViewById(R.id.your_need);

		changingTime = (TextView) findViewById(R.id.your_goal_deadline);
		changingTime.setOnClickListener(this);

		tvs[0].setOnClickListener(this);
		tvs[1].setOnClickListener(this);
		tvs[2].setOnClickListener(this);
		tvs[3].setOnClickListener(this);
		tvs[4].setOnClickListener(this);
		tvs[5].setOnClickListener(this);

		freshData();
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (!isDefault)
			registerReceiver(dataChangedReceiver, new IntentFilter(TIMECHANGE));
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (!isDefault)
			unregisterReceiver(dataChangedReceiver);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_your_goal, menu);
		return true;
	}

	public void freshData() {
		tvs[0].setText("完成来聚吧项目 & Android知识体系\n 投资待定");
		tvs[1].setText("锻炼身体，照镜子反思\n读书计划：自控力");
		tvs[2].setText("色彩转换程序，健康每日程序\n读书整理：代码艺术");
		tvs[3].setText("冥想20分[5次/分]，乔布斯，英语，阅读，早餐，OOM，UML，.9.png\nViewPage，ExpandedListView");
		tvs[4].setText("少用搜索引擎、远离微知识、睡7小时\n无用网页，补充糖分[不是食用甜食]");
		tvs[5].setText("12月衣服、亚马逊书籍\n1月元旦手机、空调");

		dataChangedReceiver = new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				Toast.makeText(YourGoalActivity.this, "日期变化", Toast.LENGTH_SHORT).show();
				if (intent.getAction().equals(TIMECHANGE))
					changingTime.setText(CommonUtils.getRemainTime());
			}
		};

		((TextView) findViewById(R.id.your_delaytime_days)).setText("+4");
	}

	public void onClick$iv_settings(View view) {

	}

	public void onClick$tv_delay_time(View view) {
		startActivity(new Intent(YourGoalActivity.this, DelayTimeActivity.class));
		overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.your_goal_deadline:
			if (isDefault) {
				registerReceiver(dataChangedReceiver, new IntentFilter(TIMECHANGE));
				changingTime.setText(CommonUtils.getRemainTime());
				isDefault = false;
			} else {
				unregisterReceiver(dataChangedReceiver);
				changingTime.setText(R.string.deadline);
				isDefault = true;
			}
			break;
		case R.id.your_three_month_goal:
			intoActivity(TASK_TYPE.THREE_MONTH);
			break;
		case R.id.your_month_goal:
			intoActivity(TASK_TYPE.ONE_MONTH);
			break;
		case R.id.your_week_goal:
			intoActivity(TASK_TYPE.ONE_WEEK);
			break;
		case R.id.your_day_goal:
			intoActivity(TASK_TYPE.ONE_DAY);
			break;
		case R.id.your_not_need:
			intoActivity(TASK_TYPE.NOT_DO);
			break;
		case R.id.your_need:
			intoActivity(TASK_TYPE.I_NEED);
			break;
		default:
			break;
		}
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		this.finish();
	}

	private void intoActivity(TASK_TYPE taskType) {
		if (taskType == null)
			return;

		Intent in = new Intent(YourGoalActivity.this, TaskDetailsActivity.class);
		in.putExtra(ColorType.TYPE, taskType);
		startActivity(in);
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
	}
}
