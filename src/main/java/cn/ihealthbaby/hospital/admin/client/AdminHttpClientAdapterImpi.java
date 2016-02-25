package cn.ihealthbaby.hospital.admin.client;

import com.isnowfox.http.client.AbstractApacheHttpClientAdapter;
import com.isnowfox.http.client.AbstractHttpClientAdapter;
import com.isnowfox.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * @author zuoge85 on 15/6/15.
 */
public class AdminHttpClientAdapterImpi extends AbstractApacheHttpClientAdapter implements HttpClientAdapter {
    private static final Logger log = LoggerFactory.getLogger(AdminHttpClientAdapterImpi.class);

    public AdminHttpClientAdapterImpi(String serverUrl, String proxy, int port) {
        super(serverUrl, proxy, port);
    }

    public AdminHttpClientAdapterImpi(String serverUrl) {
        super(serverUrl);
    }

    private <T> T deserializeJson(String json, Type type) {
        return JsonUtils.gsonDeserialize(json, type);
    }

    @Override
    public <T> Result<T> request(String method, String uri, List<Map.Entry<String, Object>> form, Type type, boolean isAccount) {
        return super.request(method, uri, form, isAccount, createCallback(uri, type, null));
    }

    @Override
    public <T> Future<?> requestAsync(String method, String uri, List<Map.Entry<String, Object>> form, Type type, boolean isAccount, Callback<T> callable) {
        return requestAsync(method, uri, form, isAccount, createCallback(uri, type, callable));
    }

    private <T> ResultCallback<Result<T>> createCallback(final String uri, final Type type, Callback<T> callable) {
        return (isSuccess, json, ex) -> {
            Result<T> result;
            if (!isSuccess) {
                log.error("错误,url:{},content:{}", uri, json, ex);
                result = Result.createError(ex);
            } else {
                result = deserializeJson(json, type);
            }
            if (callable != null) {
                callable.call(result);
            }
            return result;
        };
    }
}
