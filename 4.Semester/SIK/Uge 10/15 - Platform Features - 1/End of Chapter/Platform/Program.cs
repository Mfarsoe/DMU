using Platform;
using Microsoft.AspNetCore.HttpLogging;
using Microsoft.Extensions.FileProviders;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddHttpLogging(opts => {
    opts.LoggingFields = HttpLoggingFields.RequestMethod
        | HttpLoggingFields.RequestPath | HttpLoggingFields.ResponseStatusCode;
});

var app = builder.Build();

app.MapGet("config", async (HttpContext context,
IConfiguration config, IWebHostEnvironment env) => {
    string defaultDebug = config["Logging:LogLevel:Default"];
    await context.Response
    .WriteAsync($"The config setting is: {defaultDebug}");
    await context.Response
    .WriteAsync($"\nThe env setting is: {env.EnvironmentName}");
    string wsID = config["WebService:Id"];
    string wsKey = config["WebService:Key"];
    await context.Response.WriteAsync($"\nThe secret ID is: {wsID}");
    await context.Response.WriteAsync($"\nThe secret Key is: {wsKey}");
});

app.UseHttpLogging();

app.UseStaticFiles();

var env = app.Environment;
app.UseStaticFiles(new StaticFileOptions {
    FileProvider = new
        PhysicalFileProvider($"{env.ContentRootPath}/staticfiles"),
    RequestPath = "/files"
});

app.MapGet("population/{city?}", Population.Endpoint);

app.Run();
