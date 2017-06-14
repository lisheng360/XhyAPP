package xhy.cbd.com.xhyapp.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import xhy.cbd.com.xhyapp.R;
import xhy.cbd.com.xhyapp.db.IPWork;
import xhy.cbd.com.xhyapp.db.Report;

/**
 * 作者: lisheng on 2017/6/14.
 * 邮箱:1021337635@qq.com
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder>  implements View.OnClickListener {
    private List<Report> mReportList;

    private static OnItemClickListener mOnItemClickListener = null;




    static class ViewHolder extends  RecyclerView.ViewHolder {
        TextView reportName;

        public ViewHolder(View view ){
            super(view);
            reportName=(TextView)view.findViewById(R.id.report_name);

        }


    }
    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }
    public MsgAdapter(List<Report> reportList){
        mReportList=reportList;
    }

    @Override
    public MsgAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item,parent,false);
        MsgAdapter.ViewHolder holder=new MsgAdapter.ViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }



    @Override
    public void onBindViewHolder(MsgAdapter.ViewHolder holder, int position) {
        Report report=mReportList.get(position);
        holder.reportName.setText(report.getReportName());

        //将position保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    @Override
    public int getItemCount() {
        return  mReportList.size();
    }
}
