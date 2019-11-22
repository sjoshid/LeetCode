package com.practice;

/**
 * https://leetcode.com/problems/next-closest-time/
 */
public class NextClosestTime {
	public String nextClosestTime(String time) {

		int hrs = Integer.parseInt(time.substring(0, 2));
		int mins = Integer.parseInt(time.substring(3, 5));


		while (true) {
			mins++;

			if (mins == 60) {
				mins = 0;
				hrs++;
			}
			// check(hrs, mins, time);
			if (hrs == 24) {
				hrs = 0;
			}
			String hrsStr = Integer.toString(hrs);
			if (hrsStr.length() == 1) {
				hrsStr = "0" + hrsStr;
			}
			String minsStr = Integer.toString(mins);
			if (minsStr.length() == 1) {
				minsStr = "0" + minsStr;
			}
			String newTime = hrsStr + ":" + minsStr;

			if (check(hrsStr, minsStr, time)) {
				return newTime;
			}
			if (time.equals(newTime)) {
				return time;
			}
		}
	}

	boolean check(String hrsStr, String minsStr, String time) {

		boolean isHrs = true;

		for (int i = 0; i < hrsStr.length(); i++) {
			String c = hrsStr.substring(i, i + 1);

			if (!time.contains(c)) {
				isHrs = false;
				break;
			}
		}
		boolean isMins = true;
		if (isHrs) {
			for (int i = 0; i < minsStr.length(); i++) {
				String c = minsStr.substring(i, i + 1);

				if (!time.contains(c)) {
					isMins = false;
					break;
				}
			}
		}
		if (isHrs && isMins) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		NextClosestTime nct = new NextClosestTime();
		nct.nextClosestTime("01:01");
	}
}
