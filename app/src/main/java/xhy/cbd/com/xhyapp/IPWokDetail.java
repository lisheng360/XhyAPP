package xhy.cbd.com.xhyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class IPWokDetail extends AppCompatActivity {

    private TextView texview_workName;
    private ImageButton btn_goback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipwok_detail);

        //获取参数
        Intent intent = this.getIntent();
        int workId=intent.getIntExtra("workId",1);
        String workName=intent.getStringExtra("workName");

        texview_workName=(TextView)findViewById(R.id.texview_workName);
        texview_workName.setText(workName);
        btn_goback=(ImageButton)findViewById(R.id.btn_goback);
        btn_goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent=new Intent(IPWokDetail.this,MainActivity.class);
                mainIntent.putExtra("tabId",0);
                startActivity(mainIntent);
            }
        });
    }
}
