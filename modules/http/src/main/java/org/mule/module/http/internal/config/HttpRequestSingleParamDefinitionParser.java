/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.module.http.internal.config;

import org.mule.config.spring.parsers.generic.ChildDefinitionParser;
import org.mule.module.http.internal.HttpParam;
import org.mule.module.http.internal.HttpParamType;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class HttpRequestSingleParamDefinitionParser extends ChildDefinitionParser
{
    private HttpParamType httpParamType;

    public HttpRequestSingleParamDefinitionParser(Class<? extends HttpParam> clazz, HttpParamType httpParamType)
    {
        super("param", clazz);

        this.httpParamType = httpParamType;

        addAlias("paramName", "name");
        addAlias("headerName", "name");

    }

    @Override
    protected void parseChild(Element element, ParserContext parserContext, BeanDefinitionBuilder builder)
    {
        builder.addConstructorArgValue(httpParamType);
        super.parseChild(element, parserContext, builder);
    }

}
