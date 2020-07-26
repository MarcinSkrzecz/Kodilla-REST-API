call runcrud
if "%ERRORLEVEL%" == "0" goto runoperapage
echo.
echo RUNCRUD has errors
goto fail

:runoperapage
start D:\Opera\launcher.exe http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo cant open Opera
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo page in opera is opened