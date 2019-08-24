package com.neverend.blog.moudel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="返回数量信息", description="返回共有树形节点中共有几个层级数量")
public class NumSize {
    @ApiModelProperty(value="多少层级节点")
    private int sizeNum;

    public int getSizeNum() {
        return sizeNum;
    }

    public void setSizeNum(int sizeNum) {
        this.sizeNum = sizeNum;
    }

    public NumSize(int sizeNum) {
        this.sizeNum = sizeNum;
    }

    public NumSize() {
    }
}
