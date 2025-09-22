@echo off
SET /P ProjectName=Enter project name: 

dotnet new globaljson --sdk-version 6.0.100 --output %ProjectName%
dotnet new mvc --no-https --output %ProjectName% --framework net6.0
dotnet new sln -o %ProjectName%
dotnet sln %ProjectName%\%ProjectName%.sln add %ProjectName%\%ProjectName%.csproj

echo Project %ProjectName% created successfully!
pause
