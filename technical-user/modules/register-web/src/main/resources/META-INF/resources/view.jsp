<%@ include file="/init.jsp"%>

<%
RegisterWebConfiguration registerWebConfiguration = (RegisterWebConfiguration)request.getAttribute(RegisterWebConfiguration.class.getName());
%>

<portlet:renderURL var="registerUserUrl">
    <portlet:param name="mvcRenderCommandName" value="/register_user" />
</portlet:renderURL>


<portlet:renderURL var="viewUserUrl">
    <portlet:param name="mvcRenderCommandName" value="/view_user" />
</portlet:renderURL>


<div class="container my-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card shadow-lg rounded-4">
                <div class="card-body p-4">
                    <h4 class="card-title mb-4 text-center">
                        <%= registerWebConfiguration.message() %>
                    </h4>
                    <div class="d-flex justify-content-between mt-4">
                        <a href="<%= registerUserUrl %>" class="btn btn-success">
                            <liferay-ui:message key="clic.to.register.user" />
                        </a>
                        <a href="<%= viewUserUrl %>" class="btn btn-info text-white">
                            <liferay-ui:message key="clic.to.view.users" />
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>