package com.investment.app.util;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.net.SocketException;
import java.util.UUID;

import static org.springframework.boot.Banner.Mode.LOG;

/**
 * 功能描述: <br>
 *
 * @since: 1.0.0
 * @Author:yong.huang
 * @Date: 2019/3/24 15:30
 */
public class FtpUtils {
    private static Logger logger=LoggerFactory.getLogger(FtpUtils.class);
    static FTPClient ftpClient=new FTPClient();

    private  static String FTP_BASEPATH="/home/ftpuser";

    /**
     *
     * @param hostName ftp服务器主机名ip
     * @param port  ftp服务器连接断口
     * @param loginName  ftp服务器登录名
     * @param loginPwd  ftp服务器登录密码
     */
    public static void  FtpLogin(String hostName,int port,String loginName,String loginPwd){
        try {
            ftpClient.connect(hostName, port);
            ftpClient.login(loginName, loginPwd);
            int reply=ftpClient.getReplyCode();   //判断ftp是否正确连接,返回状态码值在200~300之间表示正确连接
            if(!FTPReply.isPositiveCompletion(reply)){
                ftpClient.disconnect();
            }
        } catch (SocketException e) {
            logger.error("socket错误：",e);
        } catch (IOException e) {
            logger.error("io错误：",e);
        }
    }

    /**
     * 断开ftp连接
     */
    public static void closeConnection(){
        if(ftpClient.isConnected()){
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                logger.error("io错误：",e);
            }
        }
    }

    /**
     * 修改文件名为uuid开头避免文件名重复
     * @param fileName 获取上传的文件名
     * @return 新的文件名
     */
    public static String getFileSuffName(String fileName){
        File file=new File(fileName);
        String oldFileName=file.getName();
        String suffixFileName=oldFileName.substring(oldFileName.lastIndexOf(".")+1);

        String uuid=UUID.randomUUID().toString().replace("-","");
        String newFileName=uuid+"."+suffixFileName;

        return newFileName;
    }

    /**
     * 上传文件
     * @param filePath 文件路径，如 2017/10/05
     * @param basePath 基础路径  /home/ftpUpFile/
     * @param is 文件流
     * @param fileName 文件名称
     * @return
     */
    public static boolean uploadFile(String filePath,String basePath,InputStream is,String fileName){
        boolean flag=false;
        try {
            if(!ftpClient.changeWorkingDirectory(basePath+filePath)){
                String[] dirs=filePath.split("/");
                String tempPath=basePath;
                for(String dir:dirs){
                    if(null==dir || "".equals(dir))
                    {continue;}
                    tempPath+="/"+dir;
                    if(!ftpClient.changeWorkingDirectory(tempPath)){
                        if(!ftpClient.makeDirectory(tempPath)){
                            return flag;
                        }else{
                            ftpClient.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            ftpClient.enterLocalPassiveMode();
            //ftpClient.enterLocalActiveMode();
            //ftpClient.setFileType(FTP.BINARY_FILE_TYPE);//设置文件为二进制流
            if(!ftpClient.storeFile(fileName, is)){ //上传文件
                return flag;
            }
            is.close();
            ftpClient.logout();
            flag=true;
        } catch (IOException e) {
            logger.error("io错误：",e);
        }finally{
            closeConnection();
        }
        return flag;
    }

    /**
     * Description: 从FTP服务器下载文件
     * @param remotePath FTP服务器上的相对路径
     * @param fileName 要下载的文件名
     * @param localPath 下载后保存到本地的路径
     * @return
     */
    public static boolean downloadFile(String remotePath,String fileName, String localPath) {
        boolean result = false;
        try {
            ftpClient.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
            FTPFile[] files = ftpClient.listFiles();
            for (FTPFile ff : files) {
                if (ff.getName().equals(fileName)) {
                    File localFile = new File(localPath + "/" + ff.getName());

                    OutputStream is = new FileOutputStream(localFile);
                    ftpClient.retrieveFile(ff.getName(), is);
                    is.close();
                }
            }
            ftpClient.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public static void main(String[] args) {
        String hostName="47.101.147.30";
        int port=21;
        String loginName="ftpuser";
        String loginPwd="ftpuser";
        FtpUtils.FtpLogin(hostName,port,loginName,loginPwd);
        File file = new File("F:\\photo\\dongyuan.jpg");
        if (file.isFile() && file.exists()) { //判断文件是否存在
            System.out.println("ok");
        }
            String oldName = file.getName();
        String newName = FtpUtils.getFileSuffName(oldName);
        //调用方法，上传文件
        try {
            boolean result = FtpUtils.uploadFile("boy",FtpUtils.FTP_BASEPATH, new FileInputStream(file),newName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

}
