package com.nikhil.searchforpackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    AlertDialog.Builder builder = new AlertDialog.Builder(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView)findViewById(R.id.appNameList);
        List<String> AppList = new ArrayList<>();
        int count=0;

        Context context = this;
        PackageManager p = context.getPackageManager();
        List<ApplicationInfo> packages = p.getInstalledApplications(PackageManager.GET_META_DATA);

        for (ApplicationInfo packageInfo : packages) {
            Log.d("TAG", "Installed package :" + packageInfo.packageName);
            AppList.add(packageInfo.packageName);
            count++;
            if (packageInfo.packageName.contains("com.google.android.youtube")){
                Log.d("CHECK","This is inside the 'if'");
                Toast.makeText(context,"YouTube is Installed",Toast.LENGTH_SHORT).show();
            }
        }
        Toast.makeText(context,"Count is "+count,Toast.LENGTH_SHORT).show();
    }

}
