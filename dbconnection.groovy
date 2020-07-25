import java.io.File.*
import java.sql.*
import groovy.sql.Sql

import jenkins.model.Jenkins



def GetDBDetails() {
	/* JENKINS_HOME environment variable is not reliable */
def jenkinsHome = Jenkins.instance.getRootDir().absolutePath
def props = new Properties()

def propertiesFile = new File("${jenkinsHome}/dbprop.properties")
//def File propsFile = new File('dbprop.properties')

if (propertiesFile.exists()) {
    props.load(propsFile.newDataInputStream())
	println("File Loaded")
}
	
	
	

String sEnvType="QA"
String sDBURL
String sDBUname
String sDBPwd
String sDBDriver
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
	println("Im inside groovy")
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
