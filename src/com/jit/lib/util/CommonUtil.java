package com.jit.lib.util;

import java.io.File;

import android.os.Environment;
import android.os.StatFs;

public class CommonUtil {

	public static boolean checkSDCardExist() {
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static long getAvailaleSize() {
		File path = Environment.getExternalStorageDirectory(); // 取得sdcard文件路径
		StatFs stat = new StatFs(path.getPath());
		long blockSize = stat.getBlockSize();
		long availableBlocks = stat.getAvailableBlocks();
		// return availableBlocks * blockSize;
		// (availableBlocks * blockSize)/1024 KIB 单位
		return (availableBlocks * blockSize) / 1024 / 1024;// MIB单位
	}
}
