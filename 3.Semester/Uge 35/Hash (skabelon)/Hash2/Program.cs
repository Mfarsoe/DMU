using System;
using System.IO;
using System.Security.Cryptography;

namespace Hash {

  public class Program {

    // hash -c -f "c:\test\testdata.txt"   // vil udskrive hash for filens indhold
    // hash -v -f "c:\test\testdata.txt" -h d56d+5qwf/d5fr5   // check at fil har hashværdi

    private static void Main(string[] args) {
      string filename = null;
      string hash = null;
      bool? compute = null;

      for (int i = 0; i < args.Length; i++)
        switch (args[i]) {
          case "-c":
            compute = true;
            break;

          case "-v":
            compute = false;
            break;

          case "-f":
            if (i + 1 < args.Length)
              filename = args[++i];
            else
              Console.WriteLine("Argument -f missing filename");
            break;

          case "-h":
            if (i + 1 < args.Length)
              hash = args[++i];
            else
              Console.WriteLine("Argument -h missing hash");
            break;

          default:
            Console.WriteLine("Unexpected argument: " + args[i]);
            break;
        }

      if (compute == true) {
        // validate arguments
        if (filename != null) {
                    //TODO compute hash of filename with md5
                    Console.WriteLine(ComputeHash(filename));
                }
                else
          Console.WriteLine("Compute hash, missing filename");

      } else if (compute == false) {
        // validate arguments
        if (filename != null) {
          if (hash != null) {
            //-> verify hash
            if(ComputeHash(filename) == hash)
              Console.WriteLine("Hash verified");
            else
              Console.WriteLine("Hash NOT verified");
          } else
            Console.WriteLine("Verify hash, missing hash");

        } else
          Console.WriteLine("Verify hash, missing filename");

      } else // compute == null
        Console.WriteLine("Missing -c or -v (i.e. compute or verify hash)");
    }
        private static string ComputeHash(string filename)
        {
            byte[] data = File.ReadAllBytes(filename);
            MD5CryptoServiceProvider md5 = new MD5CryptoServiceProvider();
            byte[] hashed = md5.ComputeHash(data);
            string base64Hash = Convert.ToBase64String(hashed);
            return base64Hash;
        }
  }
}
