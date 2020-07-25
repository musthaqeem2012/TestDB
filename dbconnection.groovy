import java.io.File.*
	import java.sql.SQLException;
import java.sql.*
import groovy.sql.Sql

import jenkins.model.Jenkins


def GetDBDetails(){
	/* JENKINS_HOME environment variable is not reliable */
//def jenkinsHome = Jenkins.instance.getRootDir().absolutePath
def props = new Properties()
def rootDir = pwd()
def propertiesFile = new File("${rootDir}/dbprop.properties")
String sEnvType="QA"
String sDBURL
String sDBUname
String sDBPwd
String sDBDriver	
	
	
if (propertiesFile.exists()) {
    props.load(propertiesFile.newDataInputStream())
	if(sEnvType=="QA")
	{
		println("QAENV")
	 sDBURL=props.getProperty('db.QADBURL')
	 sDBUname=props.getProperty('db.QADBUname')
	 sDBPwd=props.getProperty('db.QADBPwd')
	 sDBDriver=props.getProperty('db.QADBDriver') 
	}
	else
	{
		println("DevENV")
	 sDBURL=props.getProperty('db.DevDBURL')
	 sDBUname=props.getProperty('db.DevDBUname')
	 sDBPwd=props.getProperty('db.DevDBPwd')
	 sDBDriver=props.getProperty('db.DevDBDriver')  
	}
}
	println(sDBURL)
	println(sDBUname)
	
	def dbUrl      = "jdbc:postgresql://localhost:5432/test"
def dbUser     = "postgres"
def dbPassword = "admin123"
def dbDriver   = "org.postgresql.Driver"
//Class.forName("org.postgresql.Driver");

	  try {

            Class.forName("org.postgresql.Driver");

        } /*catch (ClassNotFoundException e) {

            println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            println(e.printStackTrace());
            return;

        }*/
	//def sql = Sql.newInstance(dbUrl, dbUser, dbPassword, dbDriver)
      // Creating a connection to the database
      //def sql = Sql.newInstance(sDBUrl,sDBUname, 
       //  sDBPwd, sDBDriver)  
	Statement stmt = null;
	conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("Connected to the PostgreSQL server successfully.");	
	stmt = c.createStatement();

      ResultSet rs = stmt.executeQuery( "select * from dept" );
while ( rs.next() ) {

         println(rs.getString("country"));
}


      rs.close();

      stmt.close();

      conn.close();

  
      	

   }
return this
