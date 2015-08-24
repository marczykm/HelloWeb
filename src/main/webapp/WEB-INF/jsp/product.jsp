<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Products</title>
</head>
<body>
   <c:url var="addAction" value="/product/add"></c:url>
    <form:form action="${addAction}" commandName="newProduct">
        <table>
            <c:if test="${!empty newProduct.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id" />
                </td>
            </tr>
            </c:if>
            <tr>
                <td>
                    <form:label path="name">
                        <spring:message text="Name"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="name"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="price">
                        <spring:message text="Price"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="price"/>
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <c:if test="${!empty newProduct.name}">
                        <input type="submit"
                            value="<spring:message text="Edit Product"/>" />
                    </c:if>
                    <c:if test="${empty newProduct.name}">
                        <input type="submit"
                            value="<spring:message text="Add Product"/>" />
                    </c:if>
                </td>
            </tr>

        </table>
    </form:form>
   <div>
        <c:if test="${!empty products}">
        <h3>Products list</h3>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td><a href="<c:url value='/product/edit/${product.id}' />">Edit</a></td>
                        <td><a href="<c:url value='/product/delete/${product.id}' />">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
   </div>
</body>
</html>