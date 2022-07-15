package com.wjh.demo.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:Code
 * Package:
 *
 * @Date:2021/3/31 16:11
 * @Author:WenJiahu
 */
public class Generator {

    public static void main(String[] args) {
        AutoGenerator mpg = Generator.getAutoGenerator();
        mpg.execute();
    }

    private static AutoGenerator getAutoGenerator() {
        AutoGenerator mpg = new AutoGenerator();

        //1.全局配置
        GlobalConfig gc = GeneratorUtils.getGlobalConfig(new GlobalConfigEntity() {{
            setAuthor("wjh");
        }});
        mpg.setGlobalConfig(gc);

        //2设置数据源
        DataSourceConfig dsc = GeneratorUtils.getDataSourceConfig();
        mpg.setDataSource(dsc);

        //3.包的设置
        PackageConfig pc = GeneratorUtils.getPackageConfig();
        mpg.setPackageInfo(pc);

        //4.策略配置
        StrategyConfig strategy = GeneratorUtils.getStrategyConfig();
        mpg.setStrategy(strategy);

        //自定义输出
        InjectionConfig cfg = GeneratorUtils.getInjectionConfig(pc);
        mpg.setCfg(cfg);

        // 自定义模板
        TemplateConfig template = GeneratorUtils.getTemplateConfig();
        mpg.setTemplateEngine(new VelocityTemplateEngine());  // 使用Veloctiy模板
        mpg.setTemplate(template);


        return mpg;
    }
}
