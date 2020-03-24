//echo off是批处理文件中的命令，可以使得下面的命令不在显示屏上面显示，前面加上@是为了使其本身不显示
@echo off
//setlocal是批处理本地化的一种操作，在执行setlocal之后所做的环境改动只限于批处理文件
//ENABLEDELAYEDEXPANSION 启用变量延迟，直到出现匹配的endlocal命令
SETLOCAL ENABLEDELAYEDEXPANSION

//rem的意思是注释
rem 链接  
set URL="http://cdn.hygyc.com/"
rem tomcat目录  
set TOMCAT_HOME="D:\apache-tomcat-7.0.100"
rem 关闭tomcat命令的路径  
set CLOSE_CMD=net stop Tomcat7
rem 启动tomcat命令的路径  
set START_CMD=net start Tomcat7
rem tomcat缓存目录  
set TOMCAT_CACHE=%TOMCAT_HOME%\work
rem 日志文件的路径  
set LOG_PATH=%TOMCAT_HOME%\check.log
rem 每次检测完后等待时间，再进行下一次检测，秒，若将程序部署到系统计划任务，可忽略
set TIME_WAIT=5

rem echo string:将字符串显示在屏幕中
rem :loop 和下面的goto组合成循环
:loop
rem 设置变量http状态码
set httpcode=0
rem 打开tomcat目录
cd /d %TOMCAT_HOME%
rem 打印时间
echo %date% %time%
rem 在屏幕上打印执行状态
echo 'begin checking tomcat'  

rem 将记录保存在日志文件中
echo %date% %time% >>%LOG_PATH%
rem 循环
rem FOR [参数] %%变量名 IN (相关文件或命令)   DO 执行的命令
rem 其中参数有/d /l /r /f
rem 参数 /d (参数只能显示当前目录下的目录名字)
rem 参数 /R (搜索指定路径及所有子目录中与set相符合的所有文件)
rem 参数 /L (该集表示以增量形式从开始到结束的一个数字序列。可以使用负的 Step)
rem 参数 /F (使用文件解析来处理命令输出、字符串及文件内容。)
rem (相关文件或命令)指定一个或一组文件。可以使用通配符
for /l %%i in (1,1,20) do (  
    echo %%i
    rem 借助工具获得项目的状态头（curl工具的安装会在下面提及）
    for /f "delims=" %%r in ('curl -sL -w "%%{http_code}" %URL% -o /dev/null') do (
	rem 将变量r的值赋值给httpcode
        set httpcode=%%r
        if !httpcode!==200 (
            GOTO :OUTFOR
        )
    )
)
  
:OUTFOR  
echo %httpcode% >>%LOG_PATH%  
  
if not %httpcode%==200 (
    echo close tomcat >>%LOG_PATH%
    rem 关闭tomcat   call在批处理中用于调用另一个批处理文件，start用于执行一些外部程序
    start %CLOSE_CMD%  
    timeout -t 10 >nul
    rem 记录日志
    echo success to close tomcat >>%LOG_PATH%  
    rem 清除tomcatwork空间 /s意思是不需要确认的删除  /Q是清除目录及子目录
    rd /S /Q %TOMCAT_CACHE%  
    echo start tomcat >>%LOG_PATH%
    rem 开启tomcat,执行bat文件
    call %START_CMD%  
      
    echo success to start tomcat  
    echo success to start tomcat >>%LOG_PATH%  
) else (
    echo the tomcat is running  
    echo the tomcat is running>>%LOG_PATH%  
)  
timeout -t 3 >nul
rem 若将脚本程序部署到系统计划程序中，将以下代码可注释
timeout -t %TIME_WAIT% >nul
goto loop