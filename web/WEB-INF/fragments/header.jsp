<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
    <nav id="nav-menu" class="navbar navbar-expand-lg navbar-dark">
        <a class="navbar-brand" href="/lab15/home">The eLibrary&reg; ::: CS472</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto ml-3">
                <li class="nav-item <c:if test="${requestScope.servletName == 'about-us'}">active</c:if>">
                    <a class="nav-link" href="/lab15/about-us">About Us</a>
                </li>
                <li class="nav-item <c:if test="${requestScope.servletName == 'virtual-tour'}">active</c:if>">
                    <a class="nav-link" href="/lab15/virtual-tour">Virtual Tour</a>
                </li>
                <li class="nav-item <c:if test="${requestScope.servletName == 'book'}">active</c:if>">
                    <a class="nav-link" href="/lab15/book">Books</a>
                </li>
            </ul>
            <form class="form-inline">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</header>