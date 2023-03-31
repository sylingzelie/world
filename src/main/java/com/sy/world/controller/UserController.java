package com.sy.world.controller;

import com.sy.world.entity.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.axis.client.Call;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import java.lang.String;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

@Api(value = "用户管理", tags = "用户管理")
@RestController
@RequestMapping("user")
public class UserController {


    @ApiOperation("获取用户")
    @GetMapping("getStaff")
    public Staff getUser() {
        Staff staff = new Staff();
        return staff;
    }

    @GetMapping("testNginx")
    public String testNginx() {
        return "测试nginx";
    }

    @GetMapping("testNginx1")
    public void getYBQueryTrace(YBQueryTrace ybQueryTrace){
        String xinChengCertifyCodePK = "97798888381861904102";
        String jxmedUrl = "https://test2.citicpruagents.com.cn/xc_jxyd/services/JXMedInterface?wsdl";
        String username = "jxtest";
        String password = "jxtest";
        Call jxmedCall = null;
        try {
            jxmedCall = new Call(jxmedUrl);
        } catch (MalformedURLException mue) {
            System.out.println("信诚call配置失败，请检查jxmedUrl是否正确,medCardNo=" + mue);
        }
        jxmedCall.setUsername(username.trim());
        jxmedCall.setPassword(password.trim());
        // 清理以前的数据
//        jxmedCall.clearOperation();
//                    jxmedCall.removeAllParameters();
        jxmedCall.setOperationName("YBQueryTrace");
        QName qnameQueryTraceInt = new QName("YBQueryTrace:YBQueryTrace", "YBQueryTrace");
        jxmedCall.registerTypeMapping(YBQueryTrace.class, qnameQueryTraceInt,
                new BeanSerializerFactory(YBQueryTrace.class, qnameQueryTraceInt),
                new BeanDeserializerFactory(YBQueryTrace.class, qnameQueryTraceInt));

        jxmedCall.addParameter("in0", XMLType.SOAP_DOCUMENT, ParameterMode.IN);
        jxmedCall.addParameter("in1", qnameQueryTraceInt,YBQueryTrace.class, ParameterMode.IN);

        QName qnameYBTraceInfo = new QName("YBTrace:YBTrace", "YBTrace");
        jxmedCall.registerTypeMapping(YBTrace.class, qnameYBTraceInfo,
                new BeanSerializerFactory(YBTrace.class, qnameYBTraceInfo),
                new BeanDeserializerFactory(YBTrace.class, qnameYBTraceInfo));
        jxmedCall.setReturnClass(YBTrace[].class);
//        jxmedCall.setReturnType(qnameYBTraceInfo,YBTrace[].class);
        jxmedCall.setTimeout(30 * 1000);

        ybQueryTrace.setCertifyCode(xinChengCertifyCodePK);

        YBTrace[] objects = null;
        try {
            objects = (YBTrace[]) jxmedCall.invoke(new Object[]{
                    xinChengCertifyCodePK,ybQueryTrace
            });
        } catch (RemoteException e) {
        }
    }

    public static void main(String[] args) {
//        String xinChengCertifyCodePK = "97798888381861904102";
        String jxmedUrl = "http://140.206.189.148:56182/core/nonvehicle/PolicyInquiryImplService?wsdl";
//        String username = "jxtest";
//        String password = "jxtest";
        Call jxmedCall = null;
        try {
            jxmedCall = new Call(jxmedUrl);
        } catch (MalformedURLException mue) {
            System.out.println("信诚call配置失败，请检查jxmedUrl是否正确,medCardNo=" + mue);
        }
//        jxmedCall.setUsername(username.trim());
//        jxmedCall.setPassword(password.trim());

//        jxmedCall.clearOperation();
        jxmedCall.setOperationName("policyInquiry");
//        QName qnameQueryTraceInt = new QName("YBQueryTrace:YBQueryTrace", "YBQueryTrace");
//
//        jxmedCall.registerTypeMapping(YBQueryTrace.class, qnameQueryTraceInt,
//                new BeanSerializerFactory(YBQueryTrace.class, qnameQueryTraceInt),
//                new BeanDeserializerFactory(YBQueryTrace.class, qnameQueryTraceInt));

        jxmedCall.addParameter("in0", XMLType.XSD_STRING, ParameterMode.IN);
        jxmedCall.addParameter("in1", XMLType.XSD_STRING, ParameterMode.IN);
        jxmedCall.addParameter("in2", XMLType.XSD_STRING, ParameterMode.IN);
        jxmedCall.addParameter("in3", XMLType.XSD_STRING, ParameterMode.IN);
        jxmedCall.addParameter("in4", XMLType.XSD_STRING, ParameterMode.IN);

        QName qnameYBTraceInt = new QName("YBTrace:YBTrace", "YBTrace");

        jxmedCall.registerTypeMapping(YBTrace.class, qnameYBTraceInt,
                new BeanSerializerFactory(YBTrace.class, qnameYBTraceInt),
                new BeanDeserializerFactory(YBTrace.class, qnameYBTraceInt));
        jxmedCall.setReturnClass(YBTrace[].class);
        jxmedCall.setTimeout(30 * 1000);

//        ybQueryTrace.setCertifyCode(xinChengCertifyCodePK);

        YBTrace[] objects = null;
        YBQueryTrace ybQueryTrace = new YBQueryTrace("97798888381861904102","000030665118088","200300003374950","2020-01-31","2021-01-31");
        try {
            objects = (YBTrace[]) jxmedCall.invoke(new Object[]{
                    "xinChengCertifyCodePK","000030665118088","200300003374950","2020-01-31","2021-01-31"});
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(objects.length);
    }

    }


