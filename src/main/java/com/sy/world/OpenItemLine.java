package com.sy.world;

import lombok.Data;

@Data
public class OpenItemLine {
    private String name;
    private String barcode;
    private Integer qty;
    private Long price;
    private String itemCode;

}
