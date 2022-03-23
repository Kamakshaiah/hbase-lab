import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

public class EnableTable {

    public static void main(String[] args) {
        Configuration conf = HBaseConfiguration.create();
        try {           
            Connection conn = ConnectionFactory.createConnection(conf);
            Admin admin = conn.getAdmin();
		TableName tableName = TableName.valueOf("Customer");
		// Verifying whether the table is disabled
	      Boolean bool = admin.isTableEnabled(tableName);
	      System.out.println(bool);

	      // Enabling the table using HBaseAdmin object
	      if(!bool){
		 admin.enableTable(tableName);
		 System.out.println("Table Enabled");
	      }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
