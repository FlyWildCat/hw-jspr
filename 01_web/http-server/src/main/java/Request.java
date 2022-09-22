import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public class Request {
    private final String path;
    private final String method;
//    private final String body;
    private final List<String> headers;

    public Request(String path, String method, List<String> headers) {
        this.path = path;
        this.method = method;
        this.headers = headers;
    }

    public String getPath() {
        return path;
    }

    public String getMethod() {
        return method;
    }

//    public String getBody() {
//        return body;
//    }

    public List<String> getHeaders() {
        return headers;
    }

    @Override
    public String toString() {
        return "Метод: " + method + "\n" +
                "Путь: " + path + "\n" +
                "Заголовки: " + headers + "\n"/* +
                "Тело: " + body + "\n"*/;
    }

    public MultiMap getQueryParams(String url) {
        MultiMap parameter = new MultiValueMap();
        List<NameValuePair> params;
        try {
            params = URLEncodedUtils.parse(new URI(url), "UTF-8");
            for (NameValuePair param : params) {
                if (param.getName() != null && param.getValue() != null)
                    parameter.put(param.getName(), param.getValue());
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return parameter;
    }
//
    public String getQueryParamsPath(String url) {
        String result;
        int i = url.indexOf("?");
        if (i == -1) {
            return url;
        }
        result = url.substring(0, i);
        return result;
    }
}
