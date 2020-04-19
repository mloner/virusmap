<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<c:forEach items="${coords}" var="coord">
    <tr>
        <td><c:out value="${coord.latlng}"/></td>
    </tr>
</c:forEach>
</html>