import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

public class ListTables {

    public static void main(String[] args) {
        Configuration conf = HBaseConfiguration.create();
        try {           
            Connection conn = ConnectionFactory.createConnection(conf);
            Admin hAdmin = conn.getAdmin();

	    // Getting all the list of tables using HBaseAdmin object	
	    HTableDescriptor[] tableDescriptor = hAdmin.listTables();
	    
	    // printing all the table names.
	      for (int i=0; i<tableDescriptor.length;i++ ){
		 System.out.println(tableDescriptor[i].getNameAsString());
	      }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
