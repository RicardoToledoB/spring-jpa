<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">
        <title>Test Spring MVC</title>
        <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS" />
        <link href="${bootstrapCSS}" rel="stylesheet">
        <spring:url value="/resources/css/starter.css" var="starterCSS" />
        <link href="${starterCSS}" rel="stylesheet"> 

    </head>

    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Test SpringMVC</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li ><a href="${pageContext.request.contextPath}/">Home</a></li>
                        <li class="active"> <a href="${pageContext.request.contextPath}/usuario/home">Usuario</a></li>
                        
                     
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <div class="container">
            <div class="row">
                <br>
                <spring:url value="/resources/img/logoSpring.png" var="logo"/>
                <h3><img src="${logo}"/> Listado Roles</h3>
                <br>
                <a href="${pageContext.request.contextPath}/usuario/new" class="btn btn-primary">Nuevo Usuario</a><br>

                <br>
                <c:if test="${not empty usuario}">
                    <table  class="table table-striped table-bordered table-hover">  
                      <thead>  
                            <tr>  
                                <th>#</th>
                                <th>nombre</th>
                                <th>apepat</th>
                                <th>estado</th>
                                <th>acciones</th>  
                            </tr>  
                        </thead>  
                        <tbody>  
                            <c:forEach var="usuario" items="${usuario}">
                                <tr>  
                                    <td>${usuario.id}</td>
                                    <td>${usuario.nombre}</td>  
                                    <td>${usuario.apepat}</td> 
                                    <td>${usuario.estado}</td>  
                                     <td>  
                                        <a href="${pageContext.request.contextPath}/usuario/edit/${usuario.id}">Edit</a> /
                                        <a href="${pageContext.request.contextPath}/usuario/delete/${usuario.id}">Delete</a> /
                                        <a href="${pageContext.request.contextPath}/usuario/detail/${usuario.id}">View</a>
                                    </td>    
                                </tr>  
                            </c:forEach>
                        </tbody>  
                    </table>  
                </c:if>

            </div>


        </div><!-- /.container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <spring:url value="/resources/js/jquery-1.11.3.min.js" var="jqueryJS" />
        <script src="${jqueryJS}"></script>
        <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJS" />
        <script src="${bootstrapJS}"></script>
    </body>
</html>


