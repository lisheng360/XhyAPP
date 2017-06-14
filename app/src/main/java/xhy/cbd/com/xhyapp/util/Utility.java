package xhy.cbd.com.xhyapp.util;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 作者: lisheng on 2017/6/6.
 * 邮箱:1021337635@qq.com
 */

public class Utility {
    /**
     *
     * 解析和处理服务器返回的数据
     */
    public  static  boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allProvinces=new JSONArray((response));
                for (int i=0;i<allProvinces.length();i++){
                    JSONObject provinceObject=allProvinces.getJSONObject(i);
//                    Province province=new Province();
//                    province.setProvinceName(provinceObject.getString("name"));
//                    province.setProvinceCode(provinceObject.getInt("id"));
//                    province.save();
                }
                return true;
            }catch (JSONException ex){
                ex.printStackTrace();
            }
        }
        return false;
    }



}
