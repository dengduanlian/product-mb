#Migration tool for WSO2 Message Broker Server 3.2.0

Welcome to the WSO2 MB 3.2.0 release

================================================================================
                        Migration - From WSO2 MB 3.1.0 to WSO2 MB 3.2.0
================================================================================

WSO2 MB 3.2.0 comes with several modifications to the database compared to WSO2 MB 3.1.0 in terms of the
format of data that is stored in. This tool is written for you to upgrade the existing records created by
WSO2 MB 3.1.0, so that they are compatible with WSO2 MB 3.2.0.

In order to migrate from WSO2 MB 3.1.0 to WSO2 MB 3.2.0, follow the below steps.

1. Disconnect all the subscribers and publishers for WSO2 MB 3.1.0.
2. Shut down the server.
3. DB scripts for migration are located inside <MB_HOME>/dbscripts/mb-store/migration-3.1.0_to_3.2.0/. Run the
relevant db script to create/modify tables.
4. Run the tool to modify data inside the tables.
5. Start WSO2 MB 3.2.0.
6. Reconnect all the publishers and subscribers.

Follow the below steps to run the tool

1. Unzip org.wso2.mb.migration.tool.zip. The directory structure of the unzipped folder is as follows:
	TOOL_HOME
		|-- lib <folder>
		|-- config.properties <file>
		|-- tool.sh <file>
		|-- README.txt <file>
		|-- org.wso2.carbon.mb.migration.tool.jar

2. Download the relevent database connector and copy it into the lib directory. For e.g., if you are
 wishing to upgrade your mysql databases, you can download the mysql connector jar
 from http://dev.mysql.com/downloads/connector/j/5.1.html and copy it into the lib directory

3. Update the config.properties with your database parameters. You can find the current configurations
from configuration properties for the MB database in WSO2MB_300_HOME(The directory in which the server
is installed)/repository/conf/datasources/master-datasources.xml

4. Run the tool by running tool.sh. If you're running on a non-linux version, you need to
run "org.wso2.carbon.mb.migration.tool.jar" manually

(c) Copyright 2017 WSO2 Inc.

