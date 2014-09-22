package com.android.norika.play.model;

import android.content.Context;

import com.android.norika.play.R;

public class ColorType {
	private static Context mContext;

	public static final String TYPE = "type";
	public static final int[] REDS = new int[3];

	public ColorType() {

	}

	public static void init(Context context) {
		mContext = context;
		REDS[0] = mContext.getResources().getColor(R.color.details1_1);
		REDS[1] = mContext.getResources().getColor(R.color.details1_2);
		REDS[2] = mContext.getResources().getColor(R.color.details1_3);
	}

	public static int[] getColors(TaskType taskType) {
		switch (taskType) {
		case THREE_MONTH:
			return REDS;
		case ONE_MONTH:
			return REDS;
		case ONE_WEEK:
			return REDS;
		case ONE_DAY:
			return REDS;
		case NOT_DO:
			return REDS;
		case I_NEED:
			return REDS;
		default:
			return null;
		}
	}

}
