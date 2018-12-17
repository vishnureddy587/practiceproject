/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.aem.summit.core.servlets;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.SearchResult;

import javax.jcr.Node;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Servlet that writes some sample content into the response. It is mounted for
 * all resources of a specific Sling resource type. The
 * {@link SlingSafeMethodsServlet} shall be used for HTTP methods that are
 * idempotent. For write operations use the {@link SlingAllMethodsServlet}.
 */
@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths="+ "/bin/mysearch",
        "sling.servlet.extensions=" + "txt"
})
public class MySearchServlet extends SlingSafeMethodsServlet {

    

    @Override
    protected void doGet(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {
         try {
        	 String searchWord = req.getParameter("inputVal");
        	 QueryBuilder queryBuilder = req.getResourceResolver().adaptTo(QueryBuilder.class);
        	 Map<String,String> predicateMap = new HashMap<String,String>();
        	 //predicateMap.put("path", "/content/we-retail");
        	 predicateMap.put("group.p.or", "true");
        	 predicateMap.put("group.1_path", "/content/Lab2018");
        	 predicateMap.put("group.2_path", "/content/we-retail");
        	 predicateMap.put("fulltext", searchWord);
        	 predicateMap.put("type","cq:Page");
        	 predicateMap.put("p.limit", "-1");
        	 Session session = req.getResourceResolver().adaptTo(Session.class);
        	 Query query = queryBuilder.createQuery(PredicateGroup.create(predicateMap), session);
        	 SearchResult searchRes=query.getResult();
        	 Iterator<Node> searchNodes = searchRes.getNodes();
        	 JSONArray jsonArr = new JSONArray();
        	 while(searchNodes.hasNext()) {
        		 JSONObject jsonObj= new JSONObject();
        		 Node eachNode = searchNodes.next();
        		 jsonObj.put(eachNode.getName(), eachNode.getPath());
        		 jsonArr.put(jsonObj);
        	 }
        	 resp.getWriter().write(jsonArr.toString());
         }catch(Exception e)
         {
        	 
         }
    }
}
