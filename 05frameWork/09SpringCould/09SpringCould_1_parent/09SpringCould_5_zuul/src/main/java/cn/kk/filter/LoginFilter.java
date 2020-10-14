package cn.kk.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {

    // @Autowired
    // HttpServletRequest request;

    @Override
    public String filterType() {
        //类型，pre
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        // 顺序
        return FilterConstants.PRE_DECORATION_FILTER_ORDER -1;
    }

    @Override
    public boolean shouldFilter() {
        //确认过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 获取请求参数
        RequestContext ct = RequestContext.getCurrentContext();
        HttpServletRequest request = ct.getRequest();
        String token = request.getParameter("access-token");
        // 判断是否存在(null , 空，空格)
        // if (token == null || token.trim().isEmpty())
        // 上面判断太麻烦，使用 common-lang3下的StringUtils
        if(StringUtils.isBlank(token)){
            //不存在，拦截
            ct.setSendZuulResponse(false);
            //返回 403
            ct.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
            ct.setResponseBody(HttpStatus.FORBIDDEN.getReasonPhrase());
        }
        //存在，放行,ct.setSendZuulResponse(false); 默认true
        return null;
    }
}
