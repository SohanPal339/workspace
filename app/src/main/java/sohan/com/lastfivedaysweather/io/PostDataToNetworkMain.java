package sohan.com.lastfivedaysweather.io;

import android.content.Context;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;


public class PostDataToNetworkMain {

    public String postMethod(Context context, String conUrl) throws Exception {

       return postMethodV1(context, conUrl);

    }
    private String postMethodV1(Context context, String url)throws Exception {

            // TODO Auto-generated method stub
            BufferedReader in = null;
            String data = null;
            try {
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(url));
                HttpResponse response = client.execute(request);
                HttpEntity entity = response.getEntity();
                in = new BufferedReader(new InputStreamReader(entity.getContent()));
                StringBuffer sb = new StringBuffer("");
                String line = "";
                String NL = System.getProperty("line.separator");
                while ((line = in.readLine()) != null)
                {
                    sb.append(line + NL);
                }
                in.close();
                data = sb.toString();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            finally
            {
                if (in != null)
                {
                    try
                    {
                        in.close();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            return data;
    }
}