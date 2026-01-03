using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace AsymmetricEncryptionExample
{
    public class RSAManager
    {
        private RSACryptoServiceProvider myRSA;
        private RSAParameters rsaParameters;
        private RSACryptoServiceProvider otherRSA;


        public RSAManager()
        {
            myRSA = new RSACryptoServiceProvider();
            rsaParameters = myRSA.ExportParameters(true);
        }

        // Load Private Key from file
        public void loadKeyMenuItem_Click(string filepath)
        {
            string xmlKeys = File.ReadAllText(filepath);
            myRSA.FromXmlString(xmlKeys);
        }

        // Save Private Key to file
        public void saveKeyMenuItem_Click(string filepath)
        {
            string xmlKeys = myRSA.ToXmlString(true);
            File.WriteAllText(filepath, xmlKeys);
        }

        // Import other public key
        public void importKeyMenuItem_Click(string filePath)
        {
            string xmlKey = File.ReadAllText(filePath);
            otherRSA = new RSACryptoServiceProvider();
            otherRSA.FromXmlString(xmlKey);
        }

        // Save encrypted message to file
        public void saveMessageMenuItem_Click(string message, string filepath)
        {
            byte[] messageBytes = Encoding.Unicode.GetBytes(message);
            byte[] encryptedBytes = otherRSA.Encrypt(messageBytes, false);
            string encryptedMessage = Convert.ToBase64String(encryptedBytes);
            File.WriteAllText(filepath, encryptedMessage);
        }

        //Export public key
        public void exportKeyMenuItem_Click(string filepath)
        {
            string xmlKey = myRSA.ToXmlString(false);
            File.WriteAllText(filepath, xmlKey);
        }

    }
}
