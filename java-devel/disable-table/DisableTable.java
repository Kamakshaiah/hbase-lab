import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

public class DisableTable {

    public static void main(String[] args) {
        Configuration conf = HBaseConfiguration.create();
        try {           
            Connection conn = ConnectionFactory.createConnection(conf);
            Admin admin = conn.getAdmin();
		TableName tableName = TableName.valueOf("Customer");
            // Verifying weather the table is disabled
      		Boolean bool = admin.isTableDisabled(tableName);
      		System.out.println(bool);

      		// Disabling the table using HBaseAdmin object
	      if(!bool){
		 admin.disableTable(tableName);
		 System.out.println("Table disabled");
	      }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
