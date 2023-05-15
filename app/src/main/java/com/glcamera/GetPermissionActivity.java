package com.glcamera;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;


/** 动态请求权限的Activity */
public class GetPermissionActivity extends Activity {
	/** 在线激活所需的权限 */
	private static final String[] NEEDED_PERMISSIONS = new String[]{
			Manifest.permission.CAMERA,
			Manifest.permission.READ_EXTERNAL_STORAGE,
			Manifest.permission.RECORD_AUDIO,
			Manifest.permission.WRITE_EXTERNAL_STORAGE
	};
	private static final int ACTION_REQUEST_PERMISSIONS = 0x001;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.support_simple_spinner_dropdown_item);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			if (checkSelfPermission(NEEDED_PERMISSIONS[0]) == PackageManager.PERMISSION_GRANTED) {
				finish();
			} else {
				requestPermissions(NEEDED_PERMISSIONS,ACTION_REQUEST_PERMISSIONS);
			}
		}

	}
}
