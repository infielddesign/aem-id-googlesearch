<%@ page session="false" %>
<%--
/*************************************************************************
 * Copyright 2014 Infield Design
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author Gaetan Marmasse <gaetan@infielddesign.com>
 * 
 *************************************************************************/
--%>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>
<%@ page import="com.adobe.granite.xss.XSSAPI" %>
<%@ page import="javax.jcr.Node" %>
<%@include file="/libs/foundation/global.jsp"%>

<%
        boolean isEdit = WCMMode.fromRequest(request) == WCMMode.EDIT;
        boolean isDesign = WCMMode.fromRequest(request) == WCMMode.DESIGN;
%>

<c:set var="isEdit" value="<%= isEdit %>" />
<c:set var="isDesign" value="<%= isDesign %>" />
