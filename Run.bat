cd /d %~dp0
 
CALL mvn clean 
CALL mvn install -D browser="firefox" -D surefire.suiteXmlFiles=TestFileForCorePortal.xml

pause