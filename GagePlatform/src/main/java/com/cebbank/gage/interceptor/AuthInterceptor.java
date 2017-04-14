package com.cebbank.gage.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cebbank.gage.model.User;
import com.cebbank.gage.util.GageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Created by xn on 2017/4/14.
 */
public class AuthInterceptor extends HandlerInterceptorAdapter{
    private final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
    /*
     * 利用正则映射到需要拦截的路径

    private String mappingURL;

    public void setMappingURL(String mappingURL) {
               this.mappingURL = mappingURL;
    }
  */

    /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * 如果返回true
     *    执行下一个拦截器,直到所有的拦截器都执行完毕
     *    再执行被拦截的Controller
     *    然后进入拦截器链,
     *    从最后一个拦截器往回执行所有的postHandle()
     *    接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        /*if ("GET".equalsIgnoreCase(request.getMethod())) {
            RequestUtil.saveRequest();
        }*/

        logger.info("==============执行顺序: 1、preHandle================");
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());
        String role = url.substring(1 , url.indexOf("/", 1));

        logger.info("requestUri:"+requestUri);
        logger.info("contextPath:"+contextPath);
        logger.info("url:"+url);

        //取出重定向前的session，并保存现有session
        HttpSession session = request.getSession();
        User user = GageUtils.getRequest(session.getId());
//        GageUtils.saveRequest(request);

        if(null == user) {
            logger.info("Interceptor：跳转到login页面！");
//            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
            response.sendRedirect("/login");
            return false;
        }else if(user.getRole().toString().equals(role.toUpperCase())||
                "user".equals(role)){
            return true;
        }else {
            //未授权访问401
            response.sendError(401);
//            response.sendRedirect("/login");
            return false;
        }
    }

    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
     * 可在modelAndView中加入数据，比如当前时间
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        logger.info("==============执行顺序: 2、postHandle================");
        if(modelAndView != null){  //加入当前时间
//            modelAndView.addObject("var", "测试postHandle");
        }
    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
     *
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        logger.info("==============执行顺序: 3、afterCompletion================");
    }

}