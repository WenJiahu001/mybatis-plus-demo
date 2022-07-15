package com.wjh.demo.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.*;

/**
 * @author 文家虎
 * @Package com.wjh.demo
 * @date 2021/5/21 16:17
 */
public class GeneratorUtils {

    private static String projectPath = System.getProperty("user.dir");

    private static String basePackage = "com.wjh.demo";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static GlobalConfig getGlobalConfig(GlobalConfigEntity data) {
        GlobalConfig config = new GlobalConfig();
        config.setAuthor(data.getAuthor());
        config.setOutputDir(projectPath + "/src/main/java");
        config.setAuthor("wjh");
        config.setOpen(false);
        config.setSwagger2(true); //实体属性 Swagger2 注解
        config.setMapperName("%sDao");
        config.setXmlName("%sDao");
        config.setServiceName("%sService");
        config.setServiceImplName("%sServiceImpl");
        config.setControllerName("%sController");
        return config;
    }

    public static DataSourceConfig getDataSourceConfig() {

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8&allowPublicKeyRetrieval=true");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            @Override
            public IColumnType processTypeConvert(GlobalConfig config, String fieldType) {
                if (fieldType.toLowerCase().contains("datetime")) {
                    return DbColumnType.DATE;
                }

                return super.processTypeConvert(config, fieldType);
            }
        });
        return dsc;
    }

    public static PackageConfig getPackageConfig() {
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.wjh.demo.business");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        pc.setModuleName(scanner("模块名"));
        return pc;
    }

    public static StrategyConfig getStrategyConfig() {
        String tables = scanner("表名");
        String[] table = tables.split(",");

        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude(table);
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.wjh.demo.common.entity.Entity");
        strategy.setEntityLombokModel(true);
//        strategy.setRestControllerStyle(true);
        // 公共父类
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id", "createTime", "updateTime", "deleted");
//        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix(new String[]{"tb_", "sys_"});   // 修改表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);   // 表名生成策略(下划线转驼峰)
//        strategy.setInclude(new String[]{"tb_user"});   // 需要生成的表
        // strategy.setExclude(new String[]{"test"});   // 排除生成的表

        //自动填充
        strategy.setLogicDeleteFieldName("deleted");
        TableFill create_time = new TableFill("create_time", FieldFill.INSERT);
        TableFill modify_time = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(create_time);
        tableFills.add(modify_time);
        strategy.setTableFillList(tableFills);

        strategy.setVersionFieldName("version");
        return strategy;
    }

    public static InjectionConfig getInjectionConfig(PackageConfig pc) {

        // 如果模板引擎是 velocity
        String templatePath = "templates/myEntityVO.java.vm";

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            //自定义属性注入:abc
            //在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("basePackage", basePackage);
                this.setMap(map);
            }
        };
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/com/wjh/demo/business/" + pc.getModuleName()
                        + "/entity/VO/" + tableInfo.getEntityName() + "VO" + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig("templates/myEntityQueryDTO.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/com/wjh/demo/business/" + pc.getModuleName()
                        + "/entity/DTO/" + tableInfo.getEntityName() + "QueryDTO" + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig("templates/myEntityEditDTO.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/com/wjh/demo/business/" + pc.getModuleName()
                        + "/entity/DTO/" + tableInfo.getEntityName() + "EditDTO" + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig("templates/myEntityAddDTO.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/com/wjh/demo/business/" + pc.getModuleName()
                        + "/entity/DTO/" + tableInfo.getEntityName() + "AddDTO" + StringPool.DOT_JAVA;
            }
        });
//        cfg.setFileCreate(new IFileCreate() {
//            @Override
//            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
//                // 判断自定义文件夹是否需要创建
//                checkDir("调用默认方法创建的目录，自定义目录用");
//                if (fileType == FileType.MAPPER) {
//                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
//                    return !new File(filePath).exists();
//                }
//                // 允许生成模板文件
//                return true;
//            }
//        });
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    public static TemplateConfig getTemplateConfig() {
        TemplateConfig template = new TemplateConfig();
        template.setController("templates/myController.java.vm");
        template.setService("templates/myService.java.vm");
        template.setServiceImpl("templates/myServiceImpl.java.vm");
        template.setMapper("templates/myDao.java.vm");
//        template.setXml("myTemplates/myXml.vm");
        template.setEntity("templates/myEntity.java.vm");
//        template.setEntityKt("myTemplates/myEntityDTO.vm");
        template.setXml(null);
        return template;
    }
}
