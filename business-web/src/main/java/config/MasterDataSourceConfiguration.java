package config;

/*import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;*/

/**
 * @Author perth 〖bfcy_china@163.com〗
 * @Date 2019/3/14 21:44
 */
/*@Configuration
@MapperScan(basePackages = "com.somta.springboot.dao.master", sqlSessionTemplateRef  = "masterSqlSessionTemplate")*/
public class MasterDataSourceConfiguration {

//    @Value("${spring.datasource.master.driver-class-name}")
//    private String driverClassName;
//
//    @Value("${spring.datasource.master.url}")
//    private String url;
//
//    @Value("${spring.datasource.master.username}")
//    private String username;
//
//    @Value("${spring.datasource.master.password}")
//    private String password;
//
//    @Bean(name = "masterDataSource")
//    @Primary
//    public DataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(this.driverClassName);
//        dataSource.setUrl(this.url);
//        dataSource.setUsername(this.username);
//        dataSource.setPassword(this.password);
//        return dataSource;
//    }
//
//    @Bean(name = "masterSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/master/**/Mysql_*Mapper.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "masterTransactionManager")
//    @Primary
//    public DataSourceTransactionManager transactionManager(@Qualifier("masterDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "masterSqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }

}

