package xhy.cbd.com.xhyapp.db;

import org.litepal.crud.DataSupport;
/**
 * Created by lisheng on 2017/6/8.
 */

public class IPWork extends DataSupport  {

    //编号
    private int id;
    //专项行动名称
    private String workName;
    //计划完成时间
    private String endTime;
    //工作任务
    private String task;

    //进度图标
    private int percentImg;
    //累计进度
    private Double percent;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getPercentImg() {
        return percentImg;
    }

    public void setPercentImg(int percentImg) {
        this.percentImg = percentImg;
    }
    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }



}
