
@set COMMAND_JAVAC="%JAVA_HOME%\bin\javac" -g -d ..\bin -source 10 -target 10 ^
-cp "%JC_HOME_TOOLS%\lib\api_classic-3.0.4.jar;%JC_HOME_TOOLS%\lib\api_classic_annotations-3.0.4.jar" ^
-Xlint:-options .\com\example\helloworld\HelloWorldApplet.java
%COMMAND_JAVAC%
call "%JC_HOME_TOOLS%\bin\converter.bat" -config ..\configurations\HelloWorld.conf

call "%JC_HOME_TOOLS%\bin\verifyexp.bat" ..\deliverables\HelloWorld\com\example\helloworld\javacard\helloworld.exp
