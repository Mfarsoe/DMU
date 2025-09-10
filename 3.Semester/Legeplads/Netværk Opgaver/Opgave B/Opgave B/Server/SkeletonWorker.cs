using Opgave_B.Server;
using Opgave_B;
using System.Net.Sockets;
using System.Xml;

internal class SkeletonWorker
{
    private SkeletonManager manager;
    private System.Net.Sockets.Socket connection;
    private System.Threading.Thread thread;
    private bool stop;
    

    public SkeletonWorker(SkeletonManager manager, System.Net.Sockets.Socket connection)
    {
        this.manager = manager;
        this.connection = connection;
        stop = false;
    }

    public void Start()
    {
        thread = new System.Threading.Thread(Run);
        thread.Start();
    }

    private void Run()
    {
        try
        {
            using (var stream = new NetworkStream(connection))
            using (var reader = new StreamReader(stream))
            using (var writer = new StreamWriter(stream))
            {
                while (!stop)
                {
                    if (stream.DataAvailable)
                    {
                        string xml = reader.ReadLine();
                        if (xml == null)
                            break;

                        Console.WriteLine("Received XML: " + xml);

                        using (var sr = new StringReader(xml))
                        using (var xr = XmlReader.Create(sr))
                        {
                            xr.MoveToContent();

                            if (xr.IsStartElement("oldest"))
                            {
                                xr.ReadStartElement(); // <oldest>

                                Person p1 = new Person();
                                p1.FromXml(xr);
                                Person p2 = new Person();
                                p2.FromXml(xr);

                                xr.ReadEndElement(); // </oldest>

                                // Kald serverens MethodImpl
                                var oldest = new MethodImpl().Oldest(p1, p2);
                                Console.WriteLine($"Server: Oldest is {oldest}");

                                // Send XML-svar
                                string responseXml = BuildResponseXml(oldest);
                                writer.WriteLine(responseXml);
                                writer.Flush();
                            }
                            else
                            {
                                Console.WriteLine("Unknown XML request");
                            }
                        }
                    }
                    else
                    {
                        System.Threading.Thread.Sleep(100);
                    }
                }
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine("SkeletonWorker error: " + ex);
        }
        finally
        {
            connection.Close();
            manager.RemoveWorker(this);
        }
    }

    private string BuildResponseXml(Person p)
    {
        using (StringWriter sw = new StringWriter())
        using (XmlWriter xw = XmlWriter.Create(sw))
        {
            p.ToXml(xw);
            xw.Flush();
            return sw.ToString();
        }
    }

    public void Shutdown(bool waitForTermination)
    {
        stop = true;
        if (waitForTermination && thread != null)
            thread.Join();
    }
}
