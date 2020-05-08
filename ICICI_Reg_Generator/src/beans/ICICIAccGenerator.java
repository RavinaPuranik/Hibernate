package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import com.mysql.jdbc.Statement;

public class ICICIAccGenerator extends IdentityGenerator {
	String name="ICICI";
	String acno="";
	@Override
	public Serializable generate(SharedSessionContractImplementor s, Object obj) {
		
		//get next sequence value
		Connection con=s.connection();
		try {
		java.sql.Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select count(acno) from ICICIaccount"); 
		
		if(rs.next())
        {
            acno=name+(rs.getInt(1)+1234);
        }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return acno;
		//append to ICICI String
		//send to table
		
		
	}

}
