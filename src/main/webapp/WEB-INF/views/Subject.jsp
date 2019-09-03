<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Subjects</title>
        <style type="text/css">
            .error {
                color: red;
            }
            table {
                width: 50%;
                border-collapse: collapse;
                border-spacing: 0px;
            }
            table td {
                border: 1px solid #565454;
                padding: 20px;
            }
        </style>
    </head>
    <body>
    <form:form action="searchSubject" method="post" modelAttribute="subject">
            <table>
                <tr>
                    <td>Enter Subject ID</td>
                    <td>
                        <form:input path="subjectid" /> <br />
                        <form:errors path="subjectid" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><button type="submit">Search</button></td>
                </tr>
            </table>
        </form:form>         
        <h2>List of Subjects</h2>
        <table>
            <tr>
                <td><strong>Subject ID</strong></td>
                <td><strong>Sub Title</strong></td>
                <td><strong>Duration In Hours</strong></td>
                <td><strong>Delete Subject</strong></td>
            </tr>
            <c:forEach items="${subjects}" var="subject">
                <tr>
                    <td>${subject.subjectid}</td>
                    <td>${subject.subtitle}</td>
                    <td>${subject.duration_in_hours}</td>
                    <td><a href="<c:url value='deleteSubject?subjectid=${subject.subjectid}'/>">delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <div>
        	<a href="<c:url value='addSubject' />">Add New Subject</a>
        </div>
    </body>
</html>