package com.sy.world;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.sy.world.entity.Person;
import com.sy.world.entity.UnderwriteBillSlipPersonDetailReqDTO;
import com.sy.world.tools.InsuranceDataListener;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
public class EasyExecl {
    @Test
    public void easyExecl(){
        InsuranceDataListener<UnderwriteBillSlipPersonDetailReqDTO> insuranceDataListener = new InsuranceDataListener();
        File file = new File("/Users/sunyang/Documents/12/账户创建.xls");
        EasyExcel.read(file.getPath(), UnderwriteBillSlipPersonDetailReqDTO.class,insuranceDataListener).autoTrim(true).extraRead(CellExtraTypeEnum.MERGE).sheet("人员清单").doRead();
        System.out.println(1);
    }
}
