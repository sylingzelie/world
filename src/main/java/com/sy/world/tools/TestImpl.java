package com.sy.world.tools;

import com.sy.world.entity.Order;
import com.sy.world.entity.User;
import com.sy.world.entity.claim.ClaimAppRequest;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TestImpl implements TestT{

    @Override
    public Object compareTo() {
        User user = new User();
        user.setUsername("sy");
        Order order = new Order();
        order.setNumber("123");
        int random = (int)Math.random()*10;
        if(random > 5){
            return user;
        }else {
            return order;
        }
    }


    public static void main(String[] args) {

        // xml转json
        Map<String, Object> map = PackageToZip.unZipFileAndConvertXml(new File("D:\\1\\clmappreq_BCLB202203030005_20220310_1320001501789948838150144.zip"), ClaimAppRequest.class);

        map.forEach((xmlName, object) -> {
            ClaimAppRequest appRequest = (ClaimAppRequest) object;
//            if ("04".equals(appRequest.getClaimAppBodyReq().getClmProcess())) {
//                return;
//            }
            int i = 0;
        });
    }

}
