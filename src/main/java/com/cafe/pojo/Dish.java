package com.cafe.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {

    private Long dishId;
    private String name;
    private Long categoryId;
    private BigDecimal price;
    private String image;
    private String description;
    private int status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", dishId" + dishId +
                ", categoryId" + categoryId +
                ", price=" + price +
                ", description=" + description+
                ", status=" + status  +
                ", createTime" + createTime +
                ", updateTime" + updateTime +
                '}';
    }

}
