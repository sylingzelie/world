package com.sy.world;

import lombok.Data;

import java.util.List;

@Data
public class PreCalcReq {
    private String source;
    private String xrefNo;
    private List<String> tokens;
    private Long amount;
    private Long storeId;
    private String storeName;
    private OpenOrderDigest digest;

}
