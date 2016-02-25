package cn.ihealthbaby.hospital;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.isnowfox.spring.AccountRuntimeException;
import com.isnowfox.spring.JsonMappingExceptionResolver;

/**
 * @author zuoge85 on 15/5/19.
 */
public class ManagerJsonMappingExceptionResolver extends JsonMappingExceptionResolver {

    protected ModelAndView noJsonResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if(ex instanceof AccountRuntimeException){
            RedirectView view = new RedirectView("/login.do",true);
            return new ModelAndView(view);
        }
        return super.noJsonResolveException(request, response, handler, ex);
    }
}
