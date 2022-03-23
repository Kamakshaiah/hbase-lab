import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

public class AddColumn {

    public static void main(String[] args) {
        Configuration conf = HBaseConfiguration.create();
        try {           
            Connection conn = ConnectionFactory.createConnection(conf);
            Admin admin = conn.getAdmin();
		TableName tableName = TableName.valueOf("Customer");
		// Instantiating columnDescriptor class
	      HColumnDescriptor columnDescriptor = new HColumnDescriptor("contactDetails");
      
	      // Adding column family
	      admin.addColumn(tableName, columnDescriptor);
	      System.out.println("coloumn added");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
