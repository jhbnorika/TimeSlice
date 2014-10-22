package com.android.norika.play.backup;

import java.io.IOException;

import android.app.backup.BackupAgentHelper;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.ParcelFileDescriptor;

public class PlayBackupAgentHelper extends BackupAgentHelper {

    @Override
    public void onBackup(ParcelFileDescriptor oldState, BackupDataOutput data, ParcelFileDescriptor newState)
            throws IOException {
        super.onBackup(oldState, data, newState);
    }

    @Override
    public void onRestore(BackupDataInput data, int appVersionCode, ParcelFileDescriptor newState) throws IOException {
        super.onRestore(data, appVersionCode, newState);

        PackageInfo info;
        try {
            String name = getPackageName();
            info = getPackageManager().getPackageInfo(name, 0);
        } catch (NameNotFoundException nnfe) {
            info = null;
        }

        int version;
        if (info != null) {
            version = info.versionCode;
        }

    }

}
