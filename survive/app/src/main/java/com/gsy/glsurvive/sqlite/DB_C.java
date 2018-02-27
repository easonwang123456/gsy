package com.gsy.glsurvive.sqlite;

/**
 * Created by Administrator on 2017/3/6.
 */
import java.util.ArrayList;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.gsy.glsurvive.firstpage_model.first_search.FirstSearchResult;
public class DB_C {
    private SQLiteDatabase db;
    public DB_C(Context context){
        db=new DB_M(context).getWritableDatabase();
    }

    public void add(int userId,String historyItem){

        String sql="insert into "+ DB_M.table_name +" values (null,' "+userId
                +" ','"+historyItem+" ')";
        Log.e("msg","sql"+sql);
        db.execSQL(sql);
    }
    public void delete(ArrayList<FirstSearchResult.ContentBean> list,int position){
        Log.e("msg", "delete: "+position);
        for (int i=0;i<list.size();i++){
            if(i==position) {
                String sql = "delete from " + DB_M.table_name + " where historyItem='" + list.get(position).getName() + "'";

                db.execSQL(sql);
            }
        }
    }
    public void deleteAll(){
        db.execSQL("delete from " + DB_M.table_name);
    }
    /**
     * 查看所有数据
     */
    public ArrayList<FirstSearchResult.ContentBean> showAll(){
        ArrayList<FirstSearchResult.ContentBean> list=new ArrayList<>();
        String sql="select * from " +DB_M.table_name ;
        Cursor cursor= db.rawQuery(sql,null);
        Log.e("msg","list:"+list);
        while(cursor.moveToNext()){
            FirstSearchResult.ContentBean contentBean=new FirstSearchResult.ContentBean();
            contentBean.setId(cursor.getInt(cursor.getColumnIndex("userId")));
            contentBean.setName(cursor.getString(cursor.getColumnIndex("historyItem")));
            list.add(contentBean);
        }
        cursor.close();
        Log.e("msg","list:"+list);
        return list;
    }


}
