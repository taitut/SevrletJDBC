<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarResponsive" aria-controls="navbarResponsive"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a class="nav-link" href="#">Home
                    <span class="sr-only">(current)</span>
                </a></li>
                <li class="nav-item"><a class="nav-link" href="#">About</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Services</a>
                </li>
                <li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
                <c:if test="${not empty USER}">
                    <div class="dropdown show">
                        <a class="nav-link dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                ${USER.fullname}
                        </a>

                        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <a class="dropdown-item" href="<c:url value='/login?action=logout'/>">Logout</a>
                        </div>
                    </div>

                </c:if>
                <c:if test="${empty USER}">
                    <li class="nav-item"><a class="nav-link" href="<c:url value='/login?action=login'/>">Login</a></li>

                </c:if>

            </ul>
        </div>
    </div>
</nav>