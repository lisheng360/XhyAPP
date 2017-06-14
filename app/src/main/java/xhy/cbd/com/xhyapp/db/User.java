package xhy.cbd.com.xhyapp.db;

import org.litepal.crud.DataSupport;

/**
 * 作者: lisheng on 2017/6/6.
 * 邮箱:1021337635@qq.com
 */

public class User  extends DataSupport {

    //手机唯一标识
    private String imei;

    //国际移动用户识别码

    private String imsi;

    //手机用户名
    private String trueName;

    //用户状态
    private Boolean status;

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
