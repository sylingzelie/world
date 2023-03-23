package com.sy.world.tools;

public enum QueryEnv {
    DEV("LATEST", "开发环境", "https://opengw.dev.pajk.cn/api/v1/", true),
    TEST("TEST", "测试环境", "https://opengw.test.pajk.cn/api/v1/", true),
    PROD("PROD", "生产环境", "https://opengw.jk.cn/api/v1/", false);

    private String url;
    private String code;
    private String msg;
    private boolean printFlag;

    private QueryEnv(String code, String msg, String url, boolean printFlag) {
        this.code = code;
        this.msg = msg;
        this.url = url;
        this.printFlag = printFlag;
    }

    public String getUrl() {
        return this.url;
    }

    public String getCode() {
        return this.code;
    }

    public boolean getPrintFlag() {
        return this.printFlag;
    }
}
