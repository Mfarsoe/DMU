@echo off
REM ==========================================
REM Skafold et ASP.NET Core projekt uden kode
REM ==========================================

SET /P ProjectName=Enter project name:
if "%PROJECT_NAME%"=="" set PROJECT_NAME=MyAspNetApp

echo Opretter tomt projekt: %PROJECT_NAME%

mkdir %PROJECT_NAME%
cd %PROJECT_NAME%

REM ==========================================
REM Opret .csproj (minimal ASP.NET Core projektfil)
REM ==========================================
(
echo ^<Project Sdk="Microsoft.NET.Sdk.Web"^>
echo   ^<PropertyGroup^>
echo     ^<TargetFramework^>net6.0^</TargetFramework^>
echo   ^</PropertyGroup^>
echo ^</Project^>
) > %PROJECT_NAME%.csproj

REM ==========================================
REM Opret standard mappestruktur
REM ==========================================
mkdir Controllers
mkdir Models
mkdir Views
mkdir Views\Home
mkdir wwwroot
mkdir wwwroot\css
mkdir wwwroot\js
mkdir wwwroot\images

REM ==========================================
REM Opret en tom Program.cs (valgfrit)
REM ==========================================
(
echo using Microsoft.AspNetCore.Builder;
echo using Microsoft.Extensions.Hosting;
echo
echo var builder = WebApplication.CreateBuilder(args);
echo var app = builder.Build();
echo
echo app.Run();
) > Program.cs

echo ==========================================
echo Projektstruktur oprettet!
echo Du kan nu køre:
echo   dotnet restore
echo   dotnet run
echo ==========================================
