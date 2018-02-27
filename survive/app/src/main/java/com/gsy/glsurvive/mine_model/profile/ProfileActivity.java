package com.gsy.glsurvive.mine_model.profile;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.gsy.glsurvive.R;
import com.gsy.glsurvive.base.BaseActivity;
import com.gsy.glsurvive.utils.CustomDatePicker;
import com.gsy.glsurvive.utils.LogUtil;
import com.gsy.glsurvive.utils.PermissionUtil;
import com.gsy.glsurvive.utils.StatusBarUtil;
import com.gsy.glsurvive.utils.DateWheelView;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import static com.gsy.glsurvive.utils.PermissionUtil.REQUEST_CODE_ASK_STORAGE;

/**
 * Created by TR-AND2 on 2017/12/11.
 */

public class ProfileActivity extends BaseActivity implements ProfileView {
    private LinearLayout back;
    private ImageView photo_img;
    private EditText nickName_et,signature_et;
    private TextView save_data,birthday_tv,sex_tv,sex_cancel,sex_confirm,location_tv;
    private File mCurrentPhotoFile;
    private PopupWindow mPopWindow,sexPopWindow;
    private RelativeLayout sex;
    private CustomDatePicker customDatePicker;
    private RelativeLayout birthday,location;
    private String now;
    private static final String[] sex_list = new String[]{"男", "女", "保密"};
    private String sexChoose;
    public static final int REQUEST_CODE_SELECT = 100;
    private String filePath;
    private SharedPreferences sharedPreferences;
    @Override
    public void addLayout() {
        setContentView(R.layout.activity_profile);
    }

    @Override
    public void initView() {
        sharedPreferences=this.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        //设置状态栏
        StatusBarUtil.setTranslucentForImageView(ProfileActivity.this,null);
        back= (LinearLayout) findViewById(R.id.H5_back);
        nickName_et= (EditText) findViewById(R.id.nickName_et);
        signature_et= (EditText) findViewById(R.id.signature_et);
        save_data= (TextView) findViewById(R.id.save_data);
        photo_img= (ImageView) findViewById(R.id.picture_iv);
        birthday= (RelativeLayout) findViewById(R.id.birthday);
        birthday_tv= (TextView) findViewById(R.id.birthday_tv);
        sex= (RelativeLayout) findViewById(R.id.sex);
        sex_tv= (TextView) findViewById(R.id.sex_tv);
        location= (RelativeLayout) findViewById(R.id.city);
        location_tv= (TextView) findViewById(R.id.city_tv);
        refreshInfo();

    }
    public void refreshInfo(){
        Log.e("msg","refreshImgUrl:"+sharedPreferences.getString("imgUrl",null));
        Picasso.with(ProfileActivity.this).load(sharedPreferences.getString("imgUrl",null)).into(photo_img);
        String name=sharedPreferences.getString("nickName",null);
        String signature=sharedPreferences.getString("signature",null);
        String sex=sharedPreferences.getString("sex",null);
        String birthday=sharedPreferences.getString("birthday",null);
        String location=sharedPreferences.getString("location",null);
        nickName_et.setText(name);
        signature_et.setText(signature);
        sex_tv.setText(sex);
        birthday_tv.setText(birthday);
        location_tv.setText(location);
 }
    @Override
    public void afterView() {
        initDatePicker();
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectAddress();
            }
        });
        sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermissionUtil.backgroundAlpha(0.5f,ProfileActivity.this);
                View contentView = LayoutInflater.from(ProfileActivity.this).inflate(R.layout.wheel_view, null);
                sex_cancel= (TextView)contentView.findViewById(R.id.sex_cancel);
                sex_confirm= (TextView) contentView.findViewById(R.id.sex_confirm);
                //绑定弹出界面的内容到popwindow控件上，设置该popwindow的长和宽，200px，单位是像素。
                sexPopWindow = new PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT,true);
                //设置SelectPicPopupWindow弹出窗体动画效果
                sexPopWindow.setAnimationStyle(R.style.popupAnimation);
                sexPopWindow.setFocusable(true); //设置PopupWindow可获得焦点
                sexPopWindow.showAtLocation(contentView, Gravity.BOTTOM, 0,0);
                DateWheelView wheelView = (DateWheelView) contentView.findViewById(R.id.wheel_view);
                wheelView.setOffset(1);
                wheelView.setItems(Arrays.asList(sex_list));
                wheelView.setSeletion(3);
                wheelView.setOnWheelViewListener(new DateWheelView.OnWheelViewListener() {
                    @Override
                    public void onSelected(int selectedIndex, String item) {
                          sexChoose=item;
                    }
                });
                sex_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sexPopWindow.dismiss();
                        PermissionUtil.backgroundAlpha(1f,ProfileActivity.this);
                    }
                });

                sex_confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sexPopWindow.dismiss();
                        sex_tv.setText(sexChoose);
                        PermissionUtil.backgroundAlpha(1f,ProfileActivity.this);
                    }
                });
            }
        });

        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDatePicker.show(now.split(" ")[0]);
            }
        });

        photo_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermissionUtil.setCameraPermisson(ProfileActivity.this);
                PermissionUtil.backgroundAlpha(0.5f,ProfileActivity.this);
                View contentView = LayoutInflater.from(ProfileActivity.this).inflate(R.layout.window_camera_icon, null);
                //绑定弹出界面的内容到popwindow控件上，设置该popwindow的长和宽，200px，单位是像素。
                mPopWindow = new PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT,true);
                //设置SelectPicPopupWindow弹出窗体动画效果
                mPopWindow.setAnimationStyle(R.style.popupAnimation);
                mPopWindow.setAnimationStyle(R.style.popupAnimation);
                mPopWindow.setFocusable(true); //设置PopupWindow可获得焦点
                mPopWindow.showAtLocation(contentView, Gravity.BOTTOM, 0,0);
                Button btn_gallery= (Button) contentView.findViewById(R.id.btn_gallery);
                Button btn_camera= (Button) contentView.findViewById(R.id.btn_camera);
                Button btn_cancel= (Button) contentView.findViewById(R.id.btn_cancel);
                btn_gallery.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPopWindow.dismiss();
                        PictureSelector.create(ProfileActivity.this)
                                .openGallery(PictureMimeType.ofImage())
                                .imageFormat(PictureMimeType.PNG)
                                .maxSelectNum(1)// 最大图片选择数量 int
                                .enableCrop(true)// 是否裁剪 true or false
                                .compress(true)// 是否压缩 true or false
                                .cropCompressQuality(10)// 裁剪压缩质量 默认 90 int
                                .minimumCompressSize(100)// 小于 100kb 的图片不压缩
                                .withAspectRatio(1, 1)// int 裁剪比例 如 16:9 3:2 3:4 1:1 可自定义
                                .forResult(PictureConfig.CHOOSE_REQUEST);

                    }
                });

                btn_camera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                          mPopWindow.dismiss();
                        PictureSelector.create(ProfileActivity.this)
                                .openCamera(PictureMimeType.ofImage())
                                .imageFormat(PictureMimeType.PNG)
                                .maxSelectNum(1)// 最大图片选择数量 int
                                .enableCrop(true)// 是否裁剪 true or false
                                .compress(true)// 是否压缩 true or false
                                .cropCompressQuality(10)// 裁剪压缩质量 默认 90 int
                                .minimumCompressSize(100)// 小于 100kb 的图片不压缩
                                .withAspectRatio(1, 1)// int 裁剪比例 如 16:9 3:2 3:4 1:1 可自定义
                                .forResult(PictureConfig.CHOOSE_REQUEST);

                    }
                });
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPopWindow.dismiss();
                        PermissionUtil.backgroundAlpha(1f,ProfileActivity.this);
                    }
                });

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        save_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ProfilePresenter(ProfileActivity.this).imgUrlUpLoad(ProfileActivity.this,filePath);
                new ProfilePresenter(ProfileActivity.this).profileUpload(ProfileActivity.this,nickName_et.getText().toString(),sex_tv.getText().toString(),signature_et.getText().toString(),birthday_tv.getText().toString(),location_tv.getText().toString());

            }
        });


    }

    @Override
    public void showMessage() {
        PermissionUtil.backgroundAlpha(1f,ProfileActivity.this);
    }

    @Override
    public void dismissPopWindow(PopupWindow popupWindow) {

    }

    @Override
    public void showImgUrl(String url) {
        //对数据进行编辑，返回editor对象
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString("imgUrl",url);
        editor.commit();//将数据持久化到存储介质中
        Log.e("msg","showImgUrl:"+url);
    }

    @Override
    public void showResetUserInfo(ProfileResult.PostBean postBean) {
        //对数据进行编辑，返回editor对象
        SharedPreferences.Editor editor =sharedPreferences.edit();
        Log.e("msg","name:"+postBean.getNickName().trim());
        String name=postBean.getNickName().trim();
        String signature=postBean.getSignature().trim();
        String sex=postBean.getSex().trim();
        String birthday=postBean.getBirthday().trim();
        String location=postBean.getLocation().trim();
        editor.putString("nickName",name);
        editor.putString("signature",signature);
        editor.putString("sex",sex);
        editor.putString("birthday",birthday);
        editor.putString("location",location);
        editor.commit();//将数据持久化到存储介质中
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    List<LocalMedia> selectList =new ArrayList<>();
    if (resultCode == RESULT_OK) {
        switch (requestCode) {
            case PictureConfig.CHOOSE_REQUEST:
                // 图片选择结果回调
             selectList = PictureSelector.obtainMultipleResult(data);
                Log.e("msg","  selectList:"+selectList.get(0).isCompressed());
                // 例如 LocalMedia 里面返回三种 path
                // 1.media.getPath(); 为原图 path
                // 2.media.getCutPath();为裁剪后 path，需判断 media.isCut();是否为 true
                  //3.media.getCompressPath();为压缩后 path，需判断 media.isCompressed();是否为 true
                // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                if(selectList.get(0).isCompressed()){
                     filePath =selectList.get(0).getCompressPath();
                    Glide.with(ProfileActivity.this).load(Uri.fromFile(new File(filePath))).into(photo_img);
                    LogUtil.e("msg","filepath:"+filePath);
                }
                PermissionUtil.backgroundAlpha(1f,ProfileActivity.this);
                break;
        }
    }
}

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_STORAGE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    // Permission Denied
                    Toast.makeText(this, "授权失败！", Toast.LENGTH_SHORT).show();
                    mPopWindow.dismiss();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        now = sdf.format(new Date());

        customDatePicker = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                birthday_tv.setText(time.split(" ")[0]);
            }
        }, "1900-01-01 00:00", now); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker.showSpecificTime(false); // 不显示时和分
        customDatePicker.setIsLoop(false); // 不允许循环滚动

}
    private void selectAddress() {
      //  PermissionUtil.backgroundAlpha(0.5f,ProfileActivity.this);
        CityPicker cityPicker = new CityPicker.Builder(ProfileActivity.this)
                .textSize(14)
                .province("四川省")
                .city("成都市")
                .district("双流区")
                .textColor(Color.parseColor("#000000"))
                .provinceCyclic(true)
                .cityCyclic(false)
                .districtCyclic(false)
                .visibleItemsCount(5)
                .itemPadding(18)
                .onlyShowProvinceAndCity(false)
                .build();
        cityPicker.show();
        //监听方法，获取选择结果
        cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
            @Override
            public void onSelected(String... citySelected) {
                //省份
                String province = citySelected[0];
                //城市
                String city = citySelected[1];
                //区县（如果设定了两级联动，那么该项返回空）
                String district = citySelected[2];
                //邮编
                String code = citySelected[3];
                //为TextView赋值
                location_tv.setText(province.trim() + "-" + city.trim() + "-" + district.trim());


            }
        });

    }


}
