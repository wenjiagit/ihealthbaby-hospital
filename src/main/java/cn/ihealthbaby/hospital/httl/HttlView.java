/*
 * Copyright 2011-2013 HTTL Team.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.ihealthbaby.hospital.httl;

import com.isnowfox.spring.AccountHandlerInterceptor;
import httl.web.WebEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.AbstractTemplateView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Map;

/**
 * HttlView. (Integration, Prototype, ThreadSafe)
 *
 * @author Liang Fei (liangfei0201 AT gmail DOT com)
 */
public class HttlView extends AbstractTemplateView {
    private static final Logger log = LoggerFactory.getLogger(HttlView.class);

    @Override
    protected void renderMergedTemplateModel(Map<String, Object> model,
                                             HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            HttlWebEngine.setRequestAndResponse(request, response);
            Object attribute = request.getAttribute(AccountHandlerInterceptor.ACCOUNT_REQUEST_ATTRIBUTE);
            model.put("account", attribute);
            HttlWebEngine.getEngine().getTemplate(getUrl(), request.getLocale(), model).render(model, response);
        } catch (Throwable th) {
            log.error("严重错误！{}", th.getMessage(), th);
            throw th;
        }
    }

    @Override
    public boolean checkResource(Locale locale) throws Exception {
        WebEngine.setServletContext(getServletContext());
        return WebEngine.getEngine().hasResource(getUrl(), locale);
    }

}