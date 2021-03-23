package org.lanqiao.util.common;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

import static org.lanqiao.util.common.Common.*;


@Getter
public enum OrderEnum implements Serializable {


    ONE(NDVIP,365),
    TWO(JDVIP,90),
    THREE(YDVIP,30),
    FOUR(QGVIP,30);

    private Integer days;
    private String mes;

    OrderEnum(String mes,Integer days){
        this.days = days;
        this.mes = mes;
    }

    public static OrderEnum list(String mes) {
        // 获取枚举类中的所有值
        OrderEnum[] countryEnums = OrderEnum.values();
        for (OrderEnum countryEnum : countryEnums) {
            if (mes.equals(countryEnum.getMes())) {
                return countryEnum;
            }
        }
        return null;
    }

}
