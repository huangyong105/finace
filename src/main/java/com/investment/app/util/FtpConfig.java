package com.investment.app.util;

/**
 * 功能描述: <br>
 *
 * @since: 1.0.0
 * @Author:yong.huang
 * @Date: 2019/3/24 15:29
 */
public class FtpConfig {
    private int port; //ftp端口
    private String ftpLoginName; //ftp服务器登录账户
    private String ftpLoginPwd; //ftp服务器登录密码
    private String hostName; //ftp主机ip
    private String basePath; //ftp文件基础路径
    private String baseImgUrl; //ftp前端界面图片访问路径

    public String getBasePath() {
        return basePath;
    }
    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
    public String getBaseImgUrl() {
        return baseImgUrl;
    }
    public void setBaseImgUrl(String baseImgUrl) {
        this.baseImgUrl = baseImgUrl;
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public String getFtpLoginName() {
        return ftpLoginName;
    }
    public void setFtpLoginName(String ftpLoginName) {
        this.ftpLoginName = ftpLoginName;
    }
    public String getFtpLoginPwd() {
        return ftpLoginPwd;
    }
    public void setFtpLoginPwd(String ftpLoginPwd) {
        this.ftpLoginPwd = ftpLoginPwd;
    }
    public String getHostName() {
        return hostName;
    }
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
}
