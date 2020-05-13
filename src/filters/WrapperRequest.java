package filters;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class WrapperRequest extends HttpServletRequestWrapper {
    private Map<String, String[]> requestParams = null;

    public WrapperRequest(final ServletRequest request) {
        super((HttpServletRequest) request);

    }

    @Override
    public String getParameter(final String name) {
        if (getParameterMap().get(name) != null) {
            return getParameterMap().get(name)[0];
        } else{
            return null;
        }

    }

    @Override
    public Map<String, String[]> getParameterMap() {
        if (requestParams == null) {
            requestParams = new HashMap<String, String[]>();
            requestParams.putAll(super.getParameterMap());
        }
        return Collections.unmodifiableMap(requestParams);
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(getParameterMap().keySet());
    }

    @Override
    public String[] getParameterValues(final String name) {
        return getParameterMap().get(name);
    }
}