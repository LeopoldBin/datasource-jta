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
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages = "cn.leopold.mapper.second",sqlSessionTemplateRef = "secondSqlSessionTemplate")
public class SecondDataSource extends AbstractDataSourceConfig{

    private Logger log = LoggerFactory.getLogger(SecondDataSource.class);

    // 配置从数据源
    @Bean(name = "SecondDB")
    public DataSource testDataSource(Environment env) throws SQLException {
        String prefix = "spring.datasource.druid.second.";
        log.info("从数据源注入成功.....");
        return getDataSource(env,prefix,"second");
    }

    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("SecondDB") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "secondSqlSessionTemplate")
    public SqlSessionTemplate secondSqlSessionTemplate(
            @Qualifier("secondSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
