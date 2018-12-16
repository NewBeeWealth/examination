package com.aaa.examination;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * className:ExaminationMainApp
 * discriptoin:
 * author:llw
 * createTime:2018-11-28 14:58
 */
@EnableTransactionManagement //添加事务注解
@SpringBootApplication()
@MapperScan("com.aaa.examination.dao")
public class ExaminationMainApp {
    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ExaminationMainApp.class);
        System.out.println("炎龙铠甲合体！！！");
    }
}
