<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Books</title>
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
        <h1>Add New Book</h1>
        <form:form action="saveBook" method="post" modelAttribute="book">
            <table>
                <tr>
                    <td>Title</td>
                    <td>
                        <form:input path="title" /> <br />
                        <form:errors path="title" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td>
                        <form:input path="price" /> <br />
                        <form:errors path="price" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td>Volume</td>
                    <td>
                        <form:input path="volume" /> <br />
                        <form:errors path="volume" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td>Published Date</td>
                    <td>
                        <form:input path="published_date" /> <br />
                        <form:errors path="published_date" cssClass="error" />
                    </td>
                </tr>
                <tr>
                   <td>Subject</td>
					<td>
						<form:select path="subject">
						<form:option value="">Select</form:option> 
            			<form:options items="${subjects}" itemValue="subjectid" itemLabel="subtitle" />
           				</form:select>
           				<form:errors path="subject" cssClass="error" />
        			</td>
                </tr>
                <tr>
                    <td colspan="2"><button type="submit">Submit</button></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>