package sohan.com.lastfivedaysweather.io;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONObject;

public class PostDataToNetwork extends AsyncTask<JSONObject, String, Object> {

	private String url;
	private String pageurl;
	private Context context;
	private ProgressDialog progressDialog;
	private GetDataCallBack callBack;
	public volatile boolean running = true;

	/**
	 * @param message
	 *            for the progress bar
	 */
	private void setProgresDialogProperties(String message) {
		progressDialog = new ProgressDialog(context);
		progressDialog.setProgress(0);
		progressDialog.setMax(100);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progressDialog.setMessage(message);
		progressDialog.setCancelable(false);
	}

	/**
	 * @param context
	 *            Activity context
	 * @param message
	 *            progress message
	 * @param callBack
	 *            call back instance
	 */
	public PostDataToNetwork(Context context, String message, GetDataCallBack callBack) {

		this.callBack = callBack;
		this.context = context;

		if (!TextUtils.isEmpty(message)) {
			setProgresDialogProperties(message);
		}
	}

	/**
	 * URl to hit
	 *
	 * @param url
	 * @param pageurl
	 */
	public void setConfig(String url, String pageurl) {
		this.url = url;
		this.pageurl = pageurl;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		try {
			if (progressDialog != null)
				progressDialog.show();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see android.os.AsyncTask#doInBackground(Params[])
	 */
	@Override
	protected Object doInBackground(JSONObject... params) {
		Object result = null;
		try {
			PostDataToNetworkMain dataToNetwork = new PostDataToNetworkMain();
			result = dataToNetwork.postMethod(context,url+pageurl);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	protected void onPostExecute(Object result) {
		super.onPostExecute(result);
		if (callBack != null) {
			while (true) {
				if (!isCancelled() && running) {
					Log.e("tag", "not cancelled");
					callBack.processResponse(result);
					break;
				}
				else {
					Log.e("tag", "postdata cancelled");
					break;
				}
			}

		}
		try {
			if (progressDialog != null) {
				progressDialog.dismiss();
				progressDialog = null;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
