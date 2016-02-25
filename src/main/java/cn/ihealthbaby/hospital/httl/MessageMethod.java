package cn.ihealthbaby.hospital.httl;

import httl.web.WebEngine;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

/**
 * @author zuoge85 on 15/5/18.
 */
public class MessageMethod {
    private MessageSourceAccessor messageAccessor;

    public MessageMethod() {
        WebApplicationContext webApplicationContext = HttlWebEngine.getWebApplicationContext();
        if(webApplicationContext != null){
            MessageSource messageSource = webApplicationContext.getBean(MessageSource.class);
            this.messageAccessor = new MessageSourceAccessor(messageSource);
        }
    }

    public String m(String code) throws NoSuchMessageException {
        return messageAccessor.getMessage(code);
    }


    public String m(String code, Object obj0) throws NoSuchMessageException {
        return messageAccessor.getMessage(code, new Object[]{obj0});
    }

    public String m(String code, Object obj0, Object obj1) throws NoSuchMessageException {
        return messageAccessor.getMessage(code, new Object[]{obj0, obj1});
    }

    public String m(String code, Object obj0, Object obj1, Object obj2) throws NoSuchMessageException {
        return messageAccessor.getMessage(code, new Object[]{obj0, obj1, obj2});
    }

    public String m(String code, Object obj0, Object obj1, Object obj2, Object obj3) throws NoSuchMessageException {
        return messageAccessor.getMessage(code, new Object[]{obj0, obj1, obj2, obj3});
    }

    public String m(String code, Object obj0, Object obj1, Object obj2, Object obj3, Object obj4) throws NoSuchMessageException {
        return messageAccessor.getMessage(code, new Object[]{obj0, obj1, obj2, obj3, obj4});
    }

    public String m(String code, Object[] args) throws NoSuchMessageException {
        return messageAccessor.getMessage(code, args);
    }

    public String mm(String code, String obj0) throws NoSuchMessageException {
        return messageAccessor.getMessage(code, new Object[]{new DefaultMessageSourceResolvable(obj0)});
    }

    public String mm(String code, String obj0, String obj1) throws NoSuchMessageException {
        return messageAccessor.getMessage(code, new Object[]{new DefaultMessageSourceResolvable(obj0),
                new DefaultMessageSourceResolvable(obj1)});
    }

    public String mm(String code, String obj0, String obj1, String obj2) throws NoSuchMessageException {
        return messageAccessor.getMessage(code, new Object[]{
                new DefaultMessageSourceResolvable(obj0),
                new DefaultMessageSourceResolvable(obj1),
                new DefaultMessageSourceResolvable(obj2)
        });
    }

    public String mm(String code, String obj0, String obj1, String obj2, String obj3) throws NoSuchMessageException {
        return messageAccessor.getMessage(code, new Object[]{
                new DefaultMessageSourceResolvable(obj0),
                new DefaultMessageSourceResolvable(obj1),
                new DefaultMessageSourceResolvable(obj2),
                new DefaultMessageSourceResolvable(obj3)
        });
    }
}
