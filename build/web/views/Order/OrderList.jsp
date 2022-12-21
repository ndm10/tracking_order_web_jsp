<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../includes/header.jsp" %>
<div class="tabcontent row" id="Dashboard">
    <div class="body flex-grow-1 px-3">
        <div class="container-lg">
            <div class="card mb-5" style="padding: 10px">
                <div style="margin: auto">
                    <h1>Order List</h1>
                </div>
                <form action="Order" method="Post">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="row">
                                <div class="col-md-6">
                                    <select name="payment" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                                        <option value="-1">---ALL Payment---</option>
                                        <c:forEach items="${requestScope.listP}" var="lp">
                                            <c:if test="${lp.id eq requestScope.payment}">
                                                <option value="${lp.id}" selected>${lp.name}</option>
                                            </c:if>
                                            <c:if test="${lp.id ne requestScope.payment}">
                                                <option value="${lp.id}">${lp.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-6">
                                    <select name="fulfillment" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                                        <option value="-1">---ALL Fulfillment---</option>
                                        <c:forEach items="${requestScope.listF}" var="lf">
                                            <c:if test="${lf.id eq requestScope.fulfillment}">
                                                <option value="${lf.id}" selected>${lf.name}</option>
                                            </c:if>
                                            <c:if test="${lf.id ne requestScope.fulfillment}">
                                                <option value="${lf.id}">${lf.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <select name="cod" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                                        <c:if test="${requestScope.cod eq -1}">
                                            <option value="-1" selected="">---ALL COD---</option>
                                            <option value="1">---COD---</option>
                                            <option value="0">---Not COD---</option>
                                        </c:if>
                                        <c:if test="${requestScope.cod eq 1}">
                                            <option value="-1">---ALL COD---</option>
                                            <option value="1" selected>---COD---</option>
                                            <option value="0">---Not COD---</option>
                                        </c:if>
                                        <c:if test="${requestScope.cod eq 0}">
                                            <option value="-1">---ALL COD---</option>
                                            <option value="1">---COD---</option>
                                            <option value="0" selected>---Not COD---</option>
                                        </c:if>
                                    </select>
                                </div>
                                <div class="col-md-6">
                                    <select name="chanel" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                                        <option value="-1">---ALL Chanel---</option>
                                        <c:forEach items="${requestScope.listC}" var="lc"> 
                                            <c:if test="${lc.id eq requestScope.chanel}">
                                                <option value="${lc.id}" selected>${lc.name}</option>
                                            </c:if>
                                            <c:if test="${lc.id ne requestScope.chanel}">
                                                <option value="${lc.id}">${lc.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6" style="display: inline">
                            <div class="row">

                            </div>
                            <div class="row" style="padding-left: 30%">
                                <div class="col-md-8">
                                    <input type="text" name="textSearch"
                                           class="form-control" id="exampleFormControlInput1" placeholder="Enter something to search">
                                </div>
                                <div class="col-md-4">
                                    <input class="btn btn-primary" name="action" type="submit" value="Search">
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                <div>
                    <form id="form__submit" style="display:flex; justify-content: end; padding: 1%" action="Order" method="Post">
                        <button type="submit" class="btn btn-primary" style="left: 0px">
                            <svg class="icon icon-lg">
                            <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-plus"></use>
                            </svg>
                            Create New Order
                        </button>
                        <input hidden="" value="add" name="action"/>
                    </form>
                </div>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Customer</th>
                            <th scope="col">Payment</th>
                            <th scope="col">Fulfillment</th>
                            <th scope="col">Create Time</th>
                            <th scope="col">COD</th>
                            <th scope="col">Chanel</th>
                            <th scope="col">Total</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.listO}" var="lo">
                            <tr>
                                <td>${lo.id}</td>
                                <td>${lo.customer.name}</td>
                                <td>${lo.payment.name}</td>
                                <td>${lo.fulfillment.name}</td>
                                <td>${lo.timeCreate}</td>
                                <c:if test="${lo.isCod eq true}">
                                    <td>COD</td>
                                </c:if>
                                <c:if test="${lo.isCod ne true}">
                                    <td>Not COD</td>
                                </c:if>
                                <td>${lo.chanel.name}</td>
                                <td>${lo.total}</td>
                                <td>
                                    <form action="Order" method="post">
                                        <button name="action" value="edit" type="submit" class="btn btn-info">Info</button>
                                        <input type="hidden" value="${lo.id}" name="oid">
                                        <c:if test="${lo.fulfillment.id ne 20 && lo.fulfillment.id ne 22 }">
                                            <button  name="action" value="cancel" type="submit" class="btn btn-dark">Cancel</button>
                                        </c:if>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%@include file="../../includes/footer.jsp" %>
<meta charset="utf-8">
