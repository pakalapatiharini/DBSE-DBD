@echo off
REM Copies the project to a folder path WITHOUT spaces, then runs it.
set DEST=C:\CO5_run
if exist "%DEST%" rmdir /s /q "%DEST%"
xcopy "%~dp0*" "%DEST%\" /E /I /Q /Y >nul
cd /d "%DEST%"
call mvnw.cmd clean spring-boot:run
pause
