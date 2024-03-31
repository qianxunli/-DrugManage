package com.example.drug.common;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class FastAutoGeneratorTest {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/drug?characterEncoding=utf-8&userSSL=false", "root", "qwe123qwe")
                .globalConfig(builder -> {
                    builder.author("qianxun") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E:/WorkPlace/springboot_vue_drug/drug/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example") // 设置父包名
                            .moduleName("drug") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "E:/WorkPlace/springboot_vue_drug/drug/src/main/resources/mapper"));
                    // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("shoptrolley") ;// 设置需要生成的表名
                    //.addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker
                .execute();
    }
}
//Mapper 添加@Mapper
//Controller 改为@RestController
//entity 根据_生成为带大写，大写生成为小写,主键如果自动递增则使用  @TableId(type= IdType.AUTO)，否则 @TableId
//entity 如果需要大写则@TableField("userid")