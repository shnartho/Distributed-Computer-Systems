using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Grpc.Core;
using Microsoft.Extensions.Logging;

namespace gRPCserver
{
    public class GreeterService : Greeter.GreeterBase
    {
        private readonly ILogger<GreeterService> _logger;

        public GreeterService(ILogger<GreeterService> logger)
        {
            _logger = logger;
        }

        public override Task<HelloReply> SayHello(HelloRequest request, ServerCallContext context)
        {
            string msg;
            int val;
            val = request.Age * 12 * 365;
            msg = "Hello "+request.Name+" being "+request.Age+" years old.";
            return Task.FromResult(new HelloReply { Message=msg, Days=val });
        }
    }
}