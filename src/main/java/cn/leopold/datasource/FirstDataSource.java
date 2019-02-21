package cn.leopold.datasource;

import cn.leopold.conf.AbstractDataSourceConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages = "cn.leopold.mapper.first",sqlSessionTemplateRef = "firstSqlSessionTemplate")
public class FirstDataSource extends AbstractDataSourceConfig{

    private Logger log = LoggerFactory.getLogger(FirstDataSource.class);

    // 配置主数据源
    @Primary
    @Bean(name = "FirstDB")
    public DataSource testDataSource(Environment env) throws SQLException {
        String prefix = "spring.datasource.druid.first.";
        log.info("主数据源注入成功.....");
        return getDataSource(env,prefix,"first");
    }

    @Bean(name = "firstSqlSessionFactory")
    public SqlSessionFactory firstSqlSessionFactory(@Qualifier("FirstDB") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "firstSqlSessionTemplate")
    public SqlSessionTemplate firstSqlSessionTemplate(
            @Qualifier("firstSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
