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

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * HttlViewResolver. (Integration, Singleton, ThreadSafe)
 *
 * @author zuoge85
 * @author Liang Fei (liangfei0201 AT gmail DOT com)
 */
public class HttlViewResolver extends AbstractTemplateViewResolver implements InitializingBean {
    private MediaType mediaType;

//    private ParameterContentNegotiationStrategy parameterContentNegotiationStrategy = new ParameterContentNegotiationStrategy(
//            ImmutableMap.of("json", MediaType.APPLICATION_JSON, "html", MediaType.TEXT_HTML)
//    );

    public HttlViewResolver() {
        setViewClass(requiredViewClass());
//        parameterContentNegotiationStrategy.setParameterName("$type");
    }

    @Override
    protected Class<?> requiredViewClass() {
        return HttlView.class;
    }

    public void afterPropertiesSet() throws Exception {
        WebApplicationContext webApplicationContext = (WebApplicationContext) getApplicationContext();

        HttlWebEngine.setWebApplicationContext(webApplicationContext);
        HttlWebEngine.setServletContext(getServletContext());
        if (getSuffix() == null || getSuffix().length() == 0) {
            super.setSuffix(HttlWebEngine.getTemplateSuffix());
        }
    }

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        RequestAttributes attrs = RequestContextHolder.getRequestAttributes();
        Assert.isInstanceOf(ServletRequestAttributes.class, attrs);
        List<MediaType> producibleMediaTypes = this.getProducibleMediaTypes(((ServletRequestAttributes) attrs).getRequest());
        for (MediaType mediaType : producibleMediaTypes) {
            if (mediaType.isCompatibleWith(MediaType.TEXT_HTML)) {
                return super.resolveViewName(viewName, locale);
            }
        }

//        ServletWebRequest ex = new ServletWebRequest(((ServletRequestAttributes)attrs).getRequest());
//        List<MediaType> mediaTypes = parameterContentNegotiationStrategy.resolveMediaTypes(ex);
//		List requestedMediaTypes = this.getMediaTypes(((ServletRequestAttributes)attrs).getRequest());
        return null;
    }
//
//
    private List<MediaType> getProducibleMediaTypes(HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        Set<MediaType> mediaTypes = (Set) request.getAttribute(HandlerMapping.PRODUCIBLE_MEDIA_TYPES_ATTRIBUTE);
        return (!CollectionUtils.isEmpty(mediaTypes) ? new ArrayList<>(mediaTypes) : Collections.singletonList(MediaType.ALL));
    }

    @Override
    public void setContentType(String contentType) {
        super.setContentType(contentType);
        mediaType = MediaType.parseMediaType(contentType);
    }

    //
//	private MediaType getMostSpecificMediaType(MediaType acceptType, MediaType produceType) {
//		produceType = produceType.copyQualityValue(acceptType);
//		return MediaType.SPECIFICITY_COMPARATOR.compare(acceptType, produceType) < 0?acceptType:produceType;
//	}


}