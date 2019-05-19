package route;

import java.io.IOException;

import com.google.android.gcm.server.InvalidRequestException;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.mysql.jdbc.StringUtils;

public class Gcm {

	public boolean sendMessage(){
	final String GCM_API_KEY = "AIzaSyCDcOrmN0NKzZb_2DlTDRUY8TW2_8WERU0";
    final int retries = 3;
    final String notificationToken = "288833849390";
    Sender sender = new Sender(GCM_API_KEY);
    Message msg = new Message.Builder().build();

    try {
                Result result = sender.send(msg, notificationToken, retries);

                if (StringUtils.isNullOrEmpty(result.getErrorCodeName())) {
                    return true;
                }
    } catch (InvalidRequestException e) {
    	e.printStackTrace();
    } catch (IOException e) {e.printStackTrace();
    }
    return false;
}
}