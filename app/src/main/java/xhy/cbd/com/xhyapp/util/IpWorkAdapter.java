package xhy.cbd.com.xhyapp.util;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import xhy.cbd.com.xhyapp.R;
import xhy.cbd.com.xhyapp.db.IPWork;


/**
 * 作者: lisheng on 2017/6/7.
 * 邮箱:1021337635@qq.com
 */

public class IpWorkAdapter extends RecyclerView.Adapter<IpWorkAdapter.ViewHolder>  implements View.OnClickListener {

    private List<IPWork> mWorkList;

    private static OnItemClickListener mOnItemClickListener = null;




    static class ViewHolder extends  RecyclerView.ViewHolder {
        TextView workName;
        TextView endTime;
        TextView task;
        ImageView percentImg;
        TextView percent;
        public ViewHolder(View view ){
            super(view);
            workName=(TextView)view.findViewById(R.id.workName);
            endTime=(TextView)view.findViewById(R.id.endTime);
            task=(TextView)view.findViewById(R.id.task);
            percentImg=(ImageView)view.findViewById(R.id.percentImg);
            percent=(TextView)view.findViewById(R.id.percent);
        }


    }
    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }
    public IpWorkAdapter(List<IPWork> workList){
        mWorkList=workList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.ipworklist_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        IPWork work=mWorkList.get(position);
        holder.workName.setText(work.getWorkName());
        holder.endTime.setText(work.getEndTime());
        holder.task.setText(work.getTask());
        holder.percentImg.setImageResource(R.drawable.green);
        holder.percent.setText(work.getPercent()+"%");
        //将position保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    @Override
    public int getItemCount() {
        return  mWorkList.size();
    }

}
