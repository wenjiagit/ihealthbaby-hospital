package cn.ihealthbaby.hospital.httl;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * @author zuoge85 on 15/5/18.
 */
public final class BindingResultMethod {
    private MessageSourceAccessor messageAccessor;

    public BindingResultMethod() {
        WebApplicationContext webApplicationContext = HttlWebEngine.getWebApplicationContext();
        if (webApplicationContext == null) {
            throw new RuntimeException("哎呀，这个必须在spring 和 web 项目里面使用！");
        }
        MessageSource messageSource = webApplicationContext.getBean(MessageSource.class);
        this.messageAccessor = new MessageSourceAccessor(messageSource);
    }

    public String validJson(BindingResult result) {
        if(result == null){
            return StringUtils.EMPTY;
        }
        JsonNodeFactory jf = JsonNodeFactory.instance;
        ObjectNode obj = jf.objectNode();
        List<FieldError> fieldErrors = result.getFieldErrors();
        for (ObjectError error : result.getAllErrors()) {
            String key = (error instanceof FieldError ? ((FieldError) error).getField() : error.getObjectName());
            String message = messageAccessor.getMessage(error);
            obj.put(key, message);
        }
        return obj.toString();
    }
}
