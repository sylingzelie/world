package com.sy.world;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OpenOrderDigest {
    private Date orderDate;
    private String orderNo;
    private String outStoreId;
    private Long total;
    private Long ownPay;
    private String clerkPhone;
    private Boolean useCoupon;
    private Boolean primeDay;
    private List<OpenItemLine> items;
}
