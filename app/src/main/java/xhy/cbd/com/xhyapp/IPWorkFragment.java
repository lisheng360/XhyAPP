package xhy.cbd.com.xhyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import java.util.ArrayList;
import java.util.List;
import xhy.cbd.com.xhyapp.db.IPWork;
import xhy.cbd.com.xhyapp.util.IpWorkAdapter;
import xhy.cbd.com.xhyapp.util.MyDecoration;
import xhy.cbd.com.xhyapp.util.OnItemClickListener;

/**
 * Created by lisheng on 2017/6/8.
 */

public class IPWorkFragment extends Fragment
{
    private List<IPWork> workList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.ipwork_fragment,container,false);
        //初始化数据，后期改成web获取
        if(workList.size()<=0){
            initIpWork();
        }


        //加载RecyclerView
        RecyclerView recyclerView= (RecyclerView)view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        //layoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        recyclerView.setLayoutManager(layoutManager);
        //加载头
        RecyclerViewHeader header = RecyclerViewHeader.fromXml(getActivity(), R.layout.ipworklist_header);

        header.attachTo(recyclerView);

        recyclerView.addItemDecoration(new MyDecoration(getActivity(), MyDecoration.VERTICAL_LIST,getResources().getColor(R.color.lineColor)));

        IpWorkAdapter adapter=new IpWorkAdapter(workList);
        //点击事件
        adapter.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(View view , int position){
                //跳转二级
                Intent intent=new Intent(getActivity(),IPWokDetail.class);
                intent.putExtra("workId",workList.get(position).getId());
                intent.putExtra("workName",workList.get(position).getWorkName());
                startActivity(intent);
                //getActivity().finish();
                //Toast.makeText(getActivity(), workList.get(position).getWorkName(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);

        return  view;
    }

    public void initIpWork(){

        IPWork work=new IPWork();
        work.setWorkName("违法建筑拆迁");
        work.setEndTime("2月");
        work.setTask("1800平米");
        work.setPercentImg(1);
        work.setPercent(60.0);
        workList.add(work);
        work=new IPWork();
        work.setWorkName("占道经营");
        work.setEndTime("9月");
        work.setTask("10处");
        work.setPercentImg(2);
        work.setPercent(54.0);
        workList.add(work);
        work=new IPWork();
        work.setWorkName("无证无照餐饮单位整治");
        work.setEndTime("4月");
        work.setTask("30处");
        work.setPercentImg(2);
        work.setPercent(69.0);
        workList.add(work);
        work=new IPWork();
        work.setWorkName("违法建设拆除");
        work.setEndTime("4月");
        work.setTask("30处");
        work.setPercentImg(1);
        work.setPercent(69.0);
        workList.add(work);

    }

    public static IPWorkFragment newInstance() {
        IPWorkFragment fragment = new IPWorkFragment();
        return fragment;
    }
}
