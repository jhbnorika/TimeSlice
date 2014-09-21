package com.norika.onesecond.ui;

import com.norika.onesecond.R;
import com.norika.onesecond.model.ColorType;
import com.norika.onesecond.model.TaskType;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TaskDetailsActivity extends Activity {
	private TextView tv_title;
	private TaskType taskType;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task_details);
		initViews();
		initValues();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	private void initViews() {
		tv_title = (TextView) findViewById(R.id.task_details_tv_details);

		taskType = (TaskType) getIntent().getSerializableExtra(ColorType.TYPE);
		int[] colors = ColorType.getColors(taskType);
		if (colors == null || colors.length != 3)
			return;
	}

	private void initValues() {
		switch (taskType) {
		case THREE_MONTH:
			tv_title.setText("三个月");
			break;
		case ONE_MONTH:
			tv_title.setText("一个月");
			break;
		case ONE_WEEK:
			tv_title.setText("一周");
		case ONE_DAY:
			tv_title.setText("一天");
		case NOT_DO:
			tv_title.setText("不要做");
		case I_NEED:
			tv_title.setText("需要做");
		default:
			break;
		}
	}

}
