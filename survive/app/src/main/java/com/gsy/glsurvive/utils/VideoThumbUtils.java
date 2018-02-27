   //package com.example.tr_and2.guide.utils;
//
//import android.content.Context;
//import android.database.Cursor;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.media.MediaMetadataRetriever;
//import android.media.ThumbnailUtils;
//import android.os.AsyncTask;
//import android.provider.MediaStore;
//import android.text.TextUtils;
//import android.util.Log;
//import android.widget.ImageView;
//
//import com.example.tr_and2.guide.mine_model.video.LocalVideoBean;
//import com.gsy.glyys.entity.EntityVideo;
//import com.nostra13.universalimageloader.core.ImageLoader;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
//import static android.R.attr.path;
//
///**
// * Created by TR-PC-ZTZ on 2018/1/9.
// * 获取本地视频及缩略图
// */
//
//public class VideoThumbUtils {
//
//    public static  List<LocalVideoBean> getList(Context context) {
//        List<LocalVideoBean> sysVideoList = new ArrayList<>();
//        // MediaStore.Video.Thumbnails.DATA:视频缩略图的文件路径
//        String[] thumbColumns = {MediaStore.Video.Thumbnails.DATA,
//                MediaStore.Video.Thumbnails.VIDEO_ID};
//        // 视频其他信息的查询条件
//        String[] mediaColumns = {MediaStore.Video.Media._ID,
//                MediaStore.Video.Media.DATA, MediaStore.Video.Media.DURATION};
//
//        Cursor cursor = context.getContentResolver().query(MediaStore.Video.Media
//                        .EXTERNAL_CONTENT_URI,
//                mediaColumns, null, null, null);
//
//        if (cursor == null) {
//            return sysVideoList;
//        }
//        if (cursor.moveToFirst()) {
//            do {
//                LocalVideoBean info = new LocalVideoBean();
//                int id = cursor.getInt(cursor
//                        .getColumnIndex(MediaStore.Video.Media._ID));
//                Cursor thumbCursor = context.getContentResolver().query(
//                        MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI,
//                        thumbColumns, MediaStore.Video.Thumbnails.VIDEO_ID
//                                + "=" + id, null, null);
//                if (thumbCursor.moveToFirst()) {
//                    info.setPath(thumbCursor.getString(thumbCursor
//                            .getColumnIndex(MediaStore.Video.Thumbnails.DATA)));
//                }
//                info.setPath(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media
//                        .DATA)));
//                info.setBitmap(getVideoThumbnail(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media
//                        .DATA))));
////                info.setDuration(cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Video
////                        .Media.DURATION)));
//                sysVideoList.add(info);
//            } while (cursor.moveToNext());
//        }
//        for (int i = 0; i < sysVideoList.size(); i++) {
//            Log.e("tga",sysVideoList.get(i).toString());
//        }
//        return sysVideoList;
//    }
//    public static  Bitmap getVideoThumbnail(String filePath) {
//        Bitmap b=null;
//        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
//        try {
//            retriever.setDataSource(filePath);
//            b=retriever.getFrameAtTime();
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//
//        } finally {
//            try {
//                retriever.release();
//            } catch (RuntimeException e) {
//                e.printStackTrace();
//            }
//        }
//        return b;
//    }
//}
