package net.aimeizi;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * Created by feng on 2017/4/20.
 */
public class CodeGenerator {

    public static void main(String[] args) {

        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("qtuc");
        gc.setFileOverride(true);
        gc.setActiveRecord(false);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor("qtuc");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("类型转换：" + fieldType);
                return super.processTypeConvert(fieldType);
            }
        });

        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:mysql://172.16.120.107:3306/qtuc_v2?useUnicode=true&autoReconnect=true&characterEncoding=UTF-8");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名
        // strategy.setDbColumnUnderline(true);//全局下划线命名
        strategy.setTablePrefix(new String[]{"ag_", "dict_", "sc_", "ucm_", "uic_"});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        // strategy.setInclude(new String[] { "user" }); // 需要生成的表
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        // strategy.setSuperEntityClass("com.baomidou.demo.BaseEntity");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.BaseMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.BaseService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.BaseServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.BaseController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuliderModel(true);
        mpg.setStrategy(strategy);

        // 包配置

        PackageConfig pc = new PackageConfig();
        pc.setModuleName(null);  //所属模块
        pc.setParent("cn.qtone.uc.basedata"); // 自定义包路径
        pc.setController("controller"); // 这里是控制器包名，默认web
        pc.setEntity("model");
        pc.setXml("xml");
        mpg.setPackageInfo(pc);

        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/template 下面内容修改，
        // 放置自己项目的 src/main/resources/template 目录下, 默认名称一下可以不配置，也可以自定义模板名称
         TemplateConfig tc = new TemplateConfig();
         tc.setController("/templates/controller.java.vm");
         tc.setEntity("/templates/entity.java.vm");
         tc.setMapper("/templates/mapper.java.vm");
         tc.setXml("/templates/mapper.xml.vm");
         tc.setService("/templates/service.java.vm");
         tc.setServiceImpl("/templates/serviceImpl.java.vm");
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
         mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();
    }

}
