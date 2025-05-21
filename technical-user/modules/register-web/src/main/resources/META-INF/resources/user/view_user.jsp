<%@ include file="/init.jsp" %>

<div class="container mt-4">
    <h3 class="mb-3 text-center">
    	<liferay-ui:message key="users.record"></liferay-ui:message>
    </h3>

	<table class="table table-striped table-hover text-center">
	    <thead>
	        <tr>
	            <th class="text-center fw-bold"><liferay-ui:message key="name" /></th>
	            <th class="text-center fw-bold"><liferay-ui:message key="email" /></th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach var="user" items="${users}">
	            <tr>
	                <td>${user.name}</td>
	                <td>${user.email}</td>
	            </tr>
	        </c:forEach>
	    </tbody>
	</table>

    <c:if test="${empty users}">
        <div class="alert alert-info mt-3">
        	<liferay-ui:message key="no.registered.users"></liferay-ui:message>
        </div>
    </c:if>
</div>