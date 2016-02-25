package cn.ihealthbaby.hospital.db;

import com.isnowfox.core.IocFactory;
import com.isnowfox.core.SpringIocFactory;
import com.isnowfox.dbtool.mysql.Builder;
import com.isnowfox.dbtool.mysql.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;


public class HospitalDaoBuilder {
	private static final Logger log = LoggerFactory.getLogger(HospitalDaoBuilder.class);
	/**
	 *
	 */
	public static void main(String[] args) {
		try {
			File dir=new File("ihealthbaby-hospital/src/main/java/");
			File resourcesDir=new File("ihealthbaby-hospital/src/main/resources/");
			if(!dir.exists()){
				dir=new File("src/main/java/");
				resourcesDir=new File("src/main/resources/");
			}

			log.info("代码路径:{}",dir.getAbsolutePath());
			//ve.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH,Main.class.getResource(".").getFile());
			//ve.init();
			Config config=new Config(dir,resourcesDir);
			config.setPack("cn.ihealthbaby.hospital.db");
			IocFactory ioc=new SpringIocFactory("spring/BuilderContext.xml");

			DataSource ds=ioc.getBean("dataSource",DataSource.class);
			Connection conn=null;
			try{
				conn=ds.getConnection();
				Builder builder=new Builder(config, conn);
				builder.objectCreate();

				builder.cacheDaoImplCreate();
				builder.cacheSpringXmlCreate();
				ioc.destroy();
				log.info("生成结束");
			}finally{
				if(conn!=null){
					conn.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
