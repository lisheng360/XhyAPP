package xhy.cbd.com.xhyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MsgDetail extends AppCompatActivity implements View.OnClickListener {
    private TextView texview_workName;
    private ImageButton btn_goback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_detail);

        //获取参数
        Intent intent = this.getIntent();
        int reportId=intent.getIntExtra("reportId",1);
        String reportName=intent.getStringExtra("reportName");

        texview_workName=(TextView)findViewById(R.id.texview_workName);
        texview_workName.setText(reportName);
        btn_goback=(ImageButton)findViewById(R.id.btn_goback);
        btn_goback.setOnClickListener(this);
        ImageView garbage1=(ImageView)findViewById(R.id.garbage1);

        garbage1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_goback:
                Intent mainIntent=new Intent(MsgDetail.this,MainActivity.class);
                mainIntent.putExtra("tabId",2);
                startActivity(mainIntent);
                break;
            case R.id.garbage1:
                Toast.makeText(getApplicationContext(),"点击查看监控",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
    }
}
