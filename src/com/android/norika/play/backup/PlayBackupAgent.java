package com.android.norika.play.backup;

import java.io.IOException;

import android.app.backup.BackupAgent;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.os.ParcelFileDescriptor;

/**
 * Do More
 * <ul>
 * <li>
 * 将数据格式版本化。例如需要在恢复数据时修正格式，可以建立一个备份代理，在数据恢复过程中如果发现当前版本和备份时的版本不一致，可以执行必要的兼容性修正工作
 * 。详情请参阅检查恢复数据的版本。</li>
 * <li>
 * 不是备份整个文件，而是指定备份部分数据及指定恢复各部分数据。（这也有助于管理不同版本的数据，因为是把数据作为唯一Entity来读写，而不是读写整个文件。</li>
 * <li>
 * 备份数据库中的数据。如果用到SQLite数据库并且希望用户重装系统时能恢复其中数据，需要建立自定义的BackupAgent。它在备份时读取库中数据，
 * 而在恢复时建表并插入数据。</li>
 * </ul>
 * 
 * @author Norika
 */
public class PlayBackupAgent extends BackupAgent {

    @Override
    public void onBackup(ParcelFileDescriptor oldState, BackupDataOutput data, ParcelFileDescriptor newState)
            throws IOException {

    }

    @Override
    public void onRestore(BackupDataInput data, int appVersionCode, ParcelFileDescriptor newState) throws IOException {

    }

}
