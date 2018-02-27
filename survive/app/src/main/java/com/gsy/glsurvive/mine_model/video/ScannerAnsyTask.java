//package com.gsy.glsurvive.mine_model.video;
//
//import android.app.Activity;
//import android.app.ProgressDialog;
//import android.content.DialogInterface;
//import android.graphics.Bitmap;
//import android.media.MediaMetadataRetriever;
//import android.os.AsyncTask;
//import android.os.Environment;
//import android.util.Log;
//import android.view.KeyEvent;
//
//import com.gsy.glsurvive.R;
//import com.gsy.glsurvive.mine_model.video.LocalVideoBean;
//
//import java.io.File;
//import java.io.FileFilter;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by TR-AND2 on 2018/1/9.
// */
//
//public class ScannerAnsyTask extends AsyncTask<Void, Integer, List<LocalVideoBean>> {
//    private List<LocalVideoBean> mMediaInfoList = new ArrayList<>(); // 媒体列表类
//    private Activity mActivity; // 依附于某个Activity，因为AsyncTask要在UI线程中执行
//    private ProgressDialog mProgressDialog;
//    public ScannerAnsyTask(Activity activity) {
//        super();
//        this.mActivity=activity;
//    }
//    //ProgressDialog模拟网络请求
//    public void loading() {
//        mProgressDialog = new ProgressDialog(mActivity, R.style.CustomProgressDialog);
//        mProgressDialog.setCancelable(false);
//        mProgressDialog.setIndeterminate(true);
//        mProgressDialog.show();
//        mProgressDialog.setContentView(R.layout.loading_dialog);
//        mProgressDialog.setOnKeyListener(onKeyListener);
//    }
//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//        loading();
//    }
//
//    @Override
//    protected List<LocalVideoBean> doInBackground(Void... params) {
//        mMediaInfoList = getVideoFile(mMediaInfoList, Environment.getExternalStorageDirectory());
////      mMediaInfoList = filterVideo(mMediaInfoList); // 这里可以选择不过滤小文件
//
//        return mMediaInfoList;
//    }
//
//    @Override
//    protected void onProgressUpdate(Integer... values) {
//        super.onProgressUpdate(values);
//    }
//
//    /**
//     * 获取视频文件
//     *
//     * @param list
//     * @param file
//     * @return
//     */
//    private List<LocalVideoBean> getVideoFile(final List<LocalVideoBean> list, File file) {
//
//        file.listFiles(new FileFilter() {
//
//            @Override
//            public boolean accept(File file) {
//                String name = file.getName();
//                int i = name.indexOf('.');
//                if ( i!=-1) {
//                    name = name.substring(i);
//                    if (name.equalsIgnoreCase(".mp4") && file.getParentFile().getName().equalsIgnoreCase("guide")) {
//                        LocalVideoBean video = new LocalVideoBean();
//                        file.getUsableSpace();
//                        video.setName(file.getName());
//                        video.setPath(file.getAbsolutePath());
//                        video.setBitmap(getVideoThumbnail(file.getAbsolutePath()));
//                        list.add(video);
//                        Log.e("msg","list:"+list);
//                        mProgressDialog.dismiss();
//                        return true;
//                    }
//                    // 判断是不是目录
//                }
//                else if (file.isDirectory()) {
//                    getVideoFile(list, file);
//                }
//                return false;
//            }
//        });
//
//        return list;
//    }
//    public static Bitmap getVideoThumbnail(String filePath) {
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
//    //判断mProgressDialog的消失条件
//    private DialogInterface.OnKeyListener onKeyListener = new DialogInterface.OnKeyListener() {
//        @Override
//        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
//            if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
//                mProgressDialog.dismiss();
//            }
//            return false;
//        }
//    };
//}