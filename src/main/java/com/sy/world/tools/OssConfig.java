package com.sy.world.tools;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.File;

public class OssConfig {


    public static void main(String[] args) {
        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "LTAI5tDFxq3WeBP1TT9L3shP";
        String accessKeySecret = "39mhLlfsx9AYRp6SBvUqiZTo2KTiho";
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "sunyang-s";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        String objectName = "C:\\test\\t.txt";

        File file = new File(objectName);

        ossClient.putObject(bucketName, file.getName(),file);


        // 关闭OSSClient。
        ossClient.shutdown();
    }

}
