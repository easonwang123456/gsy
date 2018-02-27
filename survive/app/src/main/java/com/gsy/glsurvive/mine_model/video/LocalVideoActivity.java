package com.gsy.glsurvive.mine_model.video;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.utils.StatusBarUtil;
import com.gsy.glsurvive.utils.ToastUtils;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by TR-AND2 on 2017/12/25.
 */

public class LocalVideoActivity extends BaseActivity {
    private LinearLayout back;
    private ScannerAnsyTask scannerAnsyTask;
    private RecyclerView recyclerView;
    private LocalVideoAdapter localVideoAdapter;
    private ProgressDialog mProgressDialog;

    @Override
    public void addLayout() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(LocalVideoActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ToastUtils.showToast(this, "检查权限是否开启");
            }

        }
        setContentView(R.layout.activity_local_video);
        StatusBarUtil.setTranslucentForImageView(LocalVideoActivity.this, null);
        localVideoAdapter = new LocalVideoAdapter();
        loading();
    }

    @Override
    public void initView() {
        back = (LinearLayout) findViewById(R.id.video_back);
        recyclerView = (RecyclerView) findViewById(R.id.local_video_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(LocalVideoActivity.this));

    }

    @Override
    public void afterView() {
        localVideoAdapter.setOnItemClickListener(new LocalVideoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, String path, String title) {
                Intent intent = new Intent();
                intent.setAction(android.content.Intent.ACTION_VIEW);
                File file = new File(path);
                Uri uri;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    Uri contentUri = FileProvider.getUriForFile(LocalVideoActivity.this, getApplicationContext().getPackageName() + ".fileprovider", file);
                    intent.setDataAndType(contentUri, "video/*");
                } else {
                    uri = Uri.fromFile(file);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setDataAndType(uri, "video/*");
                }
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        scannerAnsyTask=new ScannerAnsyTask();
//        scannerAnsyTask.execute();
//        try {
//            localVideoAdapter.addDatas(scannerAnsyTask.get(), LocalVideoActivity.this);
//            recyclerView.setAdapter(localVideoAdapter);
//            mProgressDialog.dismiss();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        scannerAnsyTask = new ScannerAnsyTask();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                scannerAnsyTask.execute();
                try {
                    localVideoAdapter.addDatas(scannerAnsyTask.get(), LocalVideoActivity.this);
                    recyclerView.setAdapter(localVideoAdapter);
                    mProgressDialog.dismiss();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }, 100);

    }

    //ProgressDialog模拟网络请求
    public void loading() {
        mProgressDialog = new ProgressDialog(LocalVideoActivity.this, R.style.CustomProgressDialog);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.show();
        mProgressDialog.setContentView(R.layout.loading_dialog);
        mProgressDialog.setOnKeyListener(onKeyListener);
    }

    //判断mProgressDialog的消失条件
    private DialogInterface.OnKeyListener onKeyListener = new DialogInterface.OnKeyListener() {
        @Override
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
                mProgressDialog.dismiss();
            }
            return false;
        }
    };

    class ScannerAnsyTask extends AsyncTask<Void, Integer, List<LocalVideoBean>> {
        private List<LocalVideoBean> mMediaInfoList = new ArrayList<>(); // 媒体列表类
        private Activity mActivity; // 依附于某个Activity，因为AsyncTask要在UI线程中执行

        public ScannerAnsyTask() {
            super();
        }


        @Override
        protected List<LocalVideoBean> doInBackground(Void... params) {
            mMediaInfoList = getVideoFile(mMediaInfoList, Environment.getExternalStorageDirectory());
//      mMediaInfoList = filterVideo(mMediaInfoList); // 这里可以选择不过滤小文件

            return mMediaInfoList;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

        }

        /**
         * 获取视频文件
         *
         * @param list
         * @param file
         * @return
         */
        private List<LocalVideoBean> getVideoFile(final List<LocalVideoBean> list, File file) {

            file.listFiles(new FileFilter() {

                @Override
                public boolean accept(File file) {
                    String name = file.getName();
                    int i = name.indexOf('.');
                    if (i != -1) {
                        name = name.substring(i);
                        if (name.equalsIgnoreCase(".mp4") && file.getParentFile().getName().equalsIgnoreCase("guide")) {
                            LocalVideoBean video = new LocalVideoBean();
                            file.getUsableSpace();
                            video.setName(file.getName());
                            video.setPath(file.getAbsolutePath());
                            video.setBitmap(getVideoThumbnail(file.getAbsolutePath()));
                            list.add(video);
                            Log.e("msg", "list:" + list);
                            return true;
                        }
                        // 判断是不是目录
                    } else if (file.isDirectory()) {
                        getVideoFile(list, file);
                    }
                    return false;
                }
            });

            return list;
        }

        public Bitmap getVideoThumbnail(String filePath) {
            Bitmap b = null;
            MediaMetadataRetriever retriever = new MediaMetadataRetriever();
            try {
                retriever.setDataSource(filePath);
                b = retriever.getFrameAtTime();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (RuntimeException e) {
                e.printStackTrace();

            } finally {
                try {
                    retriever.release();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
            return b;
        }
    }
}


