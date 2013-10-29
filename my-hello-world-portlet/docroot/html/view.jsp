<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

This is the <b>My Hello World Portlet</b> portlet in View mode.
<%
	String name = (String)request.getAttribute("ATTRIBUTE_NAME");
%>
<p>Hello<%=name  %>!</p>