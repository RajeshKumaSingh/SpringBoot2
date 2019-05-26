 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">Logo</a>

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#">Link 1</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 2</a>
    </li>

    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Dropdown link
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="#">Link 1</a>
        <a class="dropdown-item" href="#">Link 2</a>
        <a class="dropdown-item" href="#">Link 3</a>
      </div>
    </li>
  </ul>
  <ul class="navbar-nav ml-auto">
  <c:choose>
  <c:when test="${not empty user}">
  	<li class="nav-item">
      <a class="nav-link" href="#"><c:out value="${user}" /></a>
    </li>
    <li class="nav-item">
      <a id="signOutLink" class="nav-link" data-toggle="modal" data-target="#logOutModel" href="#">Log-Out</a>
    </li>
  </c:when>
  <c:otherwise>
  	<li class="nav-item">
      <a id="loginLink" class="nav-link" data-toggle="modal" data-target="#loginModel" href="#">Log-In</a>
    </li>
    <li class="nav-item">
      <a id="signUpLink" class="nav-link" data-toggle="modal" data-target="#signUpModel" href="#">Sign-Up</a>
    </li>
  </c:otherwise>
  </c:choose>
    </ul>
</nav> 


<!-- Modal -->
<c:choose>
<c:when test="${empty user}">
<div class="modal fade" id="signUpModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">SignUp Form</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       	<jsp:include page="../signup.jsp"></jsp:include>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="loginModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Login Form</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       	<jsp:include page="../login.jsp"></jsp:include>
      </div>
    </div>
  </div>
</div>
</c:when>
<c:otherwise>
<div class="modal fade" id="logOutModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Log Out</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       	<jsp:include page="../logout.jsp"></jsp:include>
      </div>
    </div>
  </div>
</div>

</c:otherwise>
</c:choose>

<script src="js/nav.js"></script>