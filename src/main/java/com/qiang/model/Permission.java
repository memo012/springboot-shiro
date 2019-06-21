package com.qiang.model;

/**
 * @Author: qiang
 * @ProjectName: adminsystem
 * @Package: com.qiang.model
 * @Description:
 * @Date: 2019/6/20 0020 11:17
 **/
public class Permission {
    private Integer pid;
    private String name;
    private String url;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
