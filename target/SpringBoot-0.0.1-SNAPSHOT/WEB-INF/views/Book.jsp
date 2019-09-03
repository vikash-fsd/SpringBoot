<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <h2>Search Book By Title</h2>
        <form:form action="searchBook" method="post" modelAttribute="book">
            <table>
                <tr>
                    <td>Enter Book ID</td>
                    <td>
                        <form:input path="bookid" /> <br />
                        <form:errors path="bookid" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><button type="submit">Search</button></td>
                </tr>
            </table>
        </form:form>      
        <h2>List of Books</h2>
        <table>
            <tr>
                <td><strong>Book ID</strong></td>
                <td><strong>Title</strong></td>
                <td><strong>Price</strong></td>
                <td><strong>Volume</strong></td>
                <td><strong>Published Date</strong></td>
                <td><strong>Subject ID</strong></td>
                <td><strong>Delete Book</strong></td>
            </tr>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.bookid}</td>
                    <td>${book.title}</td>
                    <td>${book.price}</td>
                    <td>${book.volume}</td>
                    <td>${book.published_date}</td>
                    <td>${book.subject.subjectid}</td>
                    <td><a href="<c:url value='deleteBook?bookid=${book.bookid}'/>">delete</a></td>                
                </tr>
            </c:forEach>
        </table>
        <div>
        	<a href="<c:url value='addBook' />">Add New Book</a>
        </div>
    </body>
</html>