package xhy.cbd.com.xhyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;

import java.util.ArrayList;
import java.util.List;

import xhy.cbd.com.xhyapp.db.IPWork;
import xhy.cbd.com.xhyapp.db.Report;
import xhy.cbd.com.xhyapp.util.IpWorkAdapter;
import xhy.cbd.com.xhyapp.util.MsgAdapter;
import xhy.cbd.com.xhyapp.util.MyDecoration;
import xhy.cbd.com.xhyapp.util.OnItemClickListener;

/**
 * 作者: lisheng on 2017/6/13.
 * 邮箱:1021337635@qq.com
 */

public class MsgFragment  extends Fragment {
    private List<Report> reportList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.msg_fragment,container,false);
        //初始化数据，后期改成web获取
        if(reportList.size()<=0){
            initReport();
        }


        //加载RecyclerView
        RecyclerView recyclerView= (RecyclerView)view.findViewById(R.id.msg_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        //layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addItemDecoration(new MyDecoration(getActivity(), MyDecoration.VERTICAL_LIST,getResources().getColor(R.color.lineColor)));

        MsgAdapter adapter=new MsgAdapter(reportList);
        //点击事件
        adapter.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(View view , int position){
                //跳转二级fragment
                Intent intent=new Intent(getActivity(),MsgDetail.class);
                intent.putExtra("reportId",reportList.get(position).getReportId());
                intent.putExtra("reportName",reportList.get(position).getReportName());
                startActivity(intent);
                //Toast.makeText(getActivity(), reportList.get(position).getReportName(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);

        return  view;
    }

    public void initReport(){
        Report report=new Report();
        report.setReportName("视频监控:朝阳北街道路出现大量垃圾");
        report.setReportId(1);
        reportList.add(report);
        report=new Report();
        report.setReportName("推送消息2");
        report.setReportId(2);
        reportList.add(report);
        report=new Report();
        report.setReportName("推送消息3");
        report.setReportId(3);
        reportList.add(report);
        report=new Report();
        report.setReportName("推送消息4");
        report.setReportId(4);
        reportList.add(report);
        report=new Report();
        report.setReportName("推送消息5");
        report.setReportId(5);
        reportList.add(report);
    }
    /**
     * 返回实例
     * @param
     * @return
     */
    public static MsgFragment newInstance() {
        MsgFragment fragment = new MsgFragment();
        return fragment;
    }


}
