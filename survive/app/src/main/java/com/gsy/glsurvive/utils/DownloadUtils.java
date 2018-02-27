package com.gsy.glsurvive.utils;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import static android.content.Context.DOWNLOAD_SERVICE;

/**
 * Created by TR-AND2 on 2018/1/9.
 */

public class DownloadUtils {
    public static void downLoadFile(String source,String fileName,String dir,Context context){

        DownloadManager downloadManager = (DownloadManager)context.getSystemService(DOWNLOAD_SERVICE);


        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(source));

        // 显示下载界面
        request.setVisibleInDownloadsUi(true);

        // 设置下载路径和文件名
        request.setDestinationInExternalPublicDir(dir, fileName);

       long downloadId = downloadManager.enqueue(request);
        downloadManager.getUriForDownloadedFile(downloadId );
        Log.e("msg",""+downloadManager.getUriForDownloadedFile(downloadId ));
    }

}
