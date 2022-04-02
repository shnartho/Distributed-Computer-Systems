using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;
using Grpc.Net.Client;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Hosting;

namespace gRPCclient
{
    public class Program
    {
        public async Task Main(string[] args)
        {
            Console.WriteLine("Starting gRPC Client");
            using var channel = GrpcChannel.ForAddress("https://localhost:5001");
            var client = new Greeter.GreeterClient(channel);
            Console.Write("Enter the name: ");
            String str = Console.ReadLine();
            int val = 21;
            var reply = await client.SayHelloAsync(new HelloRequest { Name=str, Age=val});
            Console.WriteLine("From server: " + reply.Message);
            Console.WriteLine("From server: "+val+" years = "+reply.Days+" days");
            Console.WriteLine("Press any key to exit...");
            Console.ReadKey();
            channel.ShutdownAsync().Wait();
            //CreateHostBuilder(args).Build().Run();
        }

        // Additional configuration is required to successfully run gRPC on macOS.
        // For instructions on how to configure Kestrel and gRPC clients on macOS, visit https://go.microsoft.com/fwlink/?linkid=2099682
        public static IHostBuilder CreateHostBuilder(string[] args) =>
            Host.CreateDefaultBuilder(args)
                .ConfigureWebHostDefaults(webBuilder => { webBuilder.UseStartup<Startup>(); });
    }
}