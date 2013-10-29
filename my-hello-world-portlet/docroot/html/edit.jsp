<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<form action="<portlet:actionURL />" method="post"
	name="<portlet:namespace />fm">
	<label for="<portlet:namespace/>name">Name:</label> 
	<input name="<portlet:namespace/>name"	type="text" /> <br />
	<br />

	<%-- <portlet:defineObjects /> --%>

	<!-- This is the -->
	<!-- <b>My Hello World Portlet</b> -->
	<!-- portlet in Edit mode. -->
	<input type="submit" value="Add Name" />
</form>