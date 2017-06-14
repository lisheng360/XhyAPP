package xhy.cbd.com.xhyapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.typechange.BooleanOrm;

import java.util.List;

import xhy.cbd.com.xhyapp.db.User;

public class LoginActivity extends AppCompatActivity {

    //手机串号
    private String imei="";
    //sim卡串号
    private String imsi="";

    private Button loginButton;
    private EditText userNameText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //初始化IMSI和IMEI
//        TelephonyManager tm = (TelephonyManager) this
//                .getSystemService(this.TELEPHONY_SERVICE);
//        imei= ((TelephonyManager) this.getSystemService(TELEPHONY_SERVICE)).getDeviceId();//获取IMEI
//        imsi= tm.getSubscriberId();//获取手机IMSI号



        //判断是否第一次登录

        if(IsReg()){
            //跳过登录页
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }

        //初始化
        loginButton=(Button)findViewById(R.id.login_button) ;
        userNameText=(EditText)findViewById(R.id.loginName_text) ;

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断是否填写用户名
                if(TextUtils.isEmpty(userNameText.getText())){
                    //调用注册方法
                  Boolean flag= UserReg(userNameText.getText().toString());
                  if(flag){
                      Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                      startActivity(intent);
                      finish();
                  }
                }
            }
        });





    }

    /**
     * 注册用户
     * @param userName
     */
    private Boolean UserReg(String userName){

        //调用方法注册

        //存入数据库

        User user=new User();
        user.setImsi(imsi);
        user.setImei(imei);
        user.setStatus(true);
        user.setTrueName(userName);
        user.save();
        return  true;
    }

    /**
     * 判断是否注册
     * @return
     */
    private Boolean IsReg(){
        List<User> userList=DataSupport.where("imsi=? and imei=? and status=true",imsi,imei).find(User.class);
        if(userList!=null&&userList.size()>0){
            return true;
        }else{
            return false;
        }
    }

    private Boolean HaveImsiAndIMEI(){
        if(TextUtils.isEmpty(imsi)){
            Toast.makeText(this,"请添加SIM卡",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(imei)){
            Toast.makeText(this,"无法读取手机串号",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
