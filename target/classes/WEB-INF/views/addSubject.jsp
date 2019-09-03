<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
        <h1>Add New Subject</h1>
        <form:form action="saveSubject" method="post" modelAttribute="subject">
            <table>
                <tr>
                    <td>Sub Title</td>
                    <td>
                        <form:input path="subtitle" /> <br />
                        <form:errors path="subtitle" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td>Duration In Hours</td>
                    <td>
                        <form:input path="duration_in_hours" /> <br />
                        <form:errors path="duration_in_hours" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><button type="submit">Submit</button></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>