<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Login</title>

</head>

<body>
    <div class="container">
        <div class="login-form">
            <div class="main-div">
                <div class="panel">
                    <h2>Login</h2>
                    <p>Please enter your email and password</p>
                    <c:if test="${param.incorrectAccount != null}">
						<div class="alert alert-danger">
                        	<strong>Username or Password is incorrect!</strong>
                    	</div>                    
                    </c:if>
                    <c:if test="${param.accessDenied != null}">
						<div class="alert alert-danger">
                        	<strong>ACCESS DENIED!</strong>
                    	</div>                    
                    </c:if>
                </div>
                <form action="j_spring_security_check" id="formLogin" method="post">
                    <div class="form-group">
                        <input type="text" class="form-control" id="userName" name="j_username" placeholder="Username">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="password" name="j_password"
                            placeholder="Password">
                    </div>
                    <div class="forgot">
                        <a href="#">Forgot password?</a>
                    </div>
                    <button type="submit" class="btn btn-primary">Login</button>
                </form>
            </div>
        </div>
    </div>

</body>

</html>