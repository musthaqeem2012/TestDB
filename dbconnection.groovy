import java.io.File.*
import java.sql.*
import groovy.sql.Sql

import jenkins.model.Jenkins



//def GetDBDetails(String workspace) {
def GetDBDetails(){
	/* JENKINS_HOME environment variable is not reliable */
def jenkinsHome = Jenkins.instance.getRootDir().absolutePath
def props = new Properties()
//def sfilepath=workspace+ "/dbprop.properties"
//def propertiesFile = new File(sfilepath)
//def File propsFile = new File('dbprop.properties')
def propertiesFile = new File("${jenkinsHome}/workspace/HND/dbprop.properties")
String sEnvType="QA"
String sDBURL
String sDBUname
String sDBPwd
String sDBDriver	
	
	//def workspace = manager.build.getEnvVars()["WORKSPACE"]
	def env = System.getenv()
	println(env['WORKSPACE'])
	println(env['JOB_BASE_NAME'])
	println(pwd())
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
	/*
      // Creating a connection to the database
      def sql = Sql.newInstance(sDBUrl,sDBUname, 
         sDBPwd, sDBDriver)  
			
      sql.eachRow('select * from employee') {
         tp -> 
         println([tp.FIRST_NAME,tp.LAST_NAME,tp.age,tp.sex,tp.INCOME])
      }  
		
      sql.close()
      */	

   }
return this
