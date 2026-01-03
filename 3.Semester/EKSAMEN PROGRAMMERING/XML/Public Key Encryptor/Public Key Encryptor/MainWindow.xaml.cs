using AsymmetricEncryptionExample;
using Microsoft.Win32;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Public_Key_Encryptor {
  /// <summary>
  /// Interaction logic for MainWindow.xaml
  /// </summary>
  public partial class MainWindow : Window {

        private RSACryptoServiceProvider myRSA, otherRSA;
        
        public MainWindow() {
            InitializeComponent();
    }

    private void OnLoadPrivateKeyClicked( object sender, RoutedEventArgs e ) {
      
            OpenFileDialog openFileDialog1 = new OpenFileDialog();


            if (openFileDialog1.ShowDialog() == true)
            {
                myRSA.FromXmlString(File.ReadAllText(openFileDialog1.FileName));
            }

            DisplayKeys();
        }

    private void OnSavePrivateKeyClicked( object sender, RoutedEventArgs e ) {
            SaveFileDialog saveFileDialog = new SaveFileDialog();
            
            if (saveFileDialog.ShowDialog() == true)
                File.WriteAllText(saveFileDialog.FileName, myRSA.ToXmlString(true));
        }

    private void OnImportPublicKeyClicked( object sender, RoutedEventArgs e ) {
            OpenFileDialog openFileDialog1 = new OpenFileDialog();
            if (openFileDialog1.ShowDialog() == true)
            {
                otherRSA.FromXmlString(File.ReadAllText(openFileDialog1.FileName));
            }
            DisplayKeys();
        }

    private void OnSaveEncryptedMessageClicked( object sender, RoutedEventArgs e ) {
            SaveFileDialog saveFileDialog = new SaveFileDialog();

            if (saveFileDialog.ShowDialog() == true)
            {
                byte[] messageBytes = Encoding.Unicode.GetBytes(MessageTextBox.Text);
                byte[] encryptedBytes = otherRSA.Encrypt(messageBytes, true);
                //string encryptedMessage = Convert.ToBase64String(encryptedBytes);
                File.WriteAllBytes(saveFileDialog.FileName, encryptedBytes);
            }
        }

    private void OnExportPublicKeyClicked( object sender, RoutedEventArgs e ) {
            SaveFileDialog saveFileDialog = new SaveFileDialog();

            if (saveFileDialog.ShowDialog() == true)
                File.WriteAllText(saveFileDialog.FileName, myRSA.ToXmlString(false));
        }

    private void OnLoadEncryptedMessageClicked( object sender, RoutedEventArgs e ) {
            OpenFileDialog openFileDialog1 = new OpenFileDialog();
            if (openFileDialog1.ShowDialog() == true)
            {
                byte[] encryptedBytes = File.ReadAllBytes(openFileDialog1.FileName);
                byte[] messageBytes = myRSA.Decrypt(encryptedBytes, true);
                MessageTextBox.Text = Encoding.Unicode.GetString(messageBytes);
            }
        }

    private void DisplayKeys() {
         RSAParameters rsaParams = myRSA.ExportParameters(true);
            PrivateKeyTextBox.Text = Convert.ToBase64String(rsaParams.D);
            PublicKeyTextBox.Text = Convert.ToBase64String(rsaParams.Modulus);

        RSAParameters otherParams = otherRSA.ExportParameters(false);
            OtherPublicKeyTextBox.Text = Convert.ToBase64String(otherParams.Modulus);
        }

        private void OnWindowLoaded(object sender, RoutedEventArgs e)
        {
            myRSA = new RSACryptoServiceProvider();
            otherRSA = new RSACryptoServiceProvider();
            DisplayKeys();
        }
    }
}
