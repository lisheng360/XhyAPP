package xhy.cbd.com.xhyapp.db;

import org.litepal.crud.DataSupport;

import java.util.Date;

/**
 * 作者: lisheng on 2017/6/6.
 * 邮箱:1021337635@qq.com
 */

public class Report   extends DataSupport {
    //报告ID
    private int reportId;
    //报告名称
    private String reportName;

    //报告内容
    private String content;

    //报告类型
    private int typeid;
    //报告日期
    private Date reportTime;

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

}
