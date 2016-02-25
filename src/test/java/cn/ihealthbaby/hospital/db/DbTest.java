package cn.ihealthbaby.hospital.db;

import net.moznion.mysql.diff.DiffExtractor;
import net.moznion.mysql.diff.MySqlConnectionInfo;
import net.moznion.mysql.diff.SchemaDumper;
import net.moznion.mysql.diff.SchemaParser;
import net.moznion.mysql.diff.model.Table;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zuoge85 on 15/7/31.
 */

public class DbTest {

    @Test
    public void test() throws InterruptedException, SQLException, IOException, URISyntaxException {
        MySqlConnectionInfo localMySqlConnectionInfo = MySqlConnectionInfo.builder()
                 .host("127.0.0.1")     // "localhost" is the default value
                 .user("root")     // "root" is the default value
                 .pass("111111") // "" is the default value
                 .url("jdbc:mysql://127.0.0.1:3306/ihealthbaby_hospital?autoReconnect=true&characterEncoding=utf-8") // or you can specify host, port and properties by a URL
                .build();


        SchemaDumper schemaDumper = new SchemaDumper(localMySqlConnectionInfo);

        final String oldSql = "CREATE TABLE `sample` (\n"
                + "  `id` INTEGER(10) NOT NULL AUTO_INCREMENT,\n"
                + "  `name` VARCHAR(32) NOT NULL,\n"
                + "  PRIMARY KEY (`id`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n";
        final String newSql = "CREATE TABLE `sample` (\n"
                + "  `id` INTEGER(10) NOT NULL AUTO_INCREMENT,\n"
                + "  `name` VARCHAR(32) NOT NULL,\n"
                + "  PRIMARY KEY (`id`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n";

//        String oldSchema = schemaDumper.dump(oldSql);
//        String newSchema = schemaDumper.dump(newSql);

        List<Table> oldTables = SchemaParser.parse(oldSql);
        List<Table> newTables = SchemaParser.parse(newSql);

        String diff = DiffExtractor.extractDiff(oldTables, newTables);


        System.out.println(diff);
    }
}
