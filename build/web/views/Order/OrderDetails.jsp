<%@include file="../../includes/header.jsp" %>
<div class="tabcontent row" id="Dashboard">
    <div class="body flex-grow-1 px-3">
        <div class="container-lg">
            <div class="card mb-5" style="padding: 10px">
                <div style="margin: auto">
                    <h1>Order Details</h1>
                </div>
                <form action="Order" method="post">
                    <div class="row g-3">
                        <div class="col-6">
                            <label class="form-label">Customer Name</label>
                            <input class="form-control" value="${requestScope.order.customer.name}" readonly>
                        </div>
                        <div class="col-6">
                            <label class="form-label">Payment method</label>
                            <input class="form-control" value="${requestScope.order.paymentMethod.name}" readonly>
                        </div>
                    </div>
                    <div class="row g-3">
                        <div class="col-6">
                            <label class="form-label">Customer Address</label>
                            <input class="form-control" value="${requestScope.order.customer.address}" readonly>
                        </div>
                        <div class="col-6">
                            <label class="form-label">Customer Phone</label>
                            <input class="form-control" value="${requestScope.order.customer.phone}" readonly>
                        </div>
                    </div>
                    <div class="row g-3">
                        <div class="col-md-6">
                            <label class="form-label">Payment</label>
                            <c:if test="${requestScope.order.payment.id eq 12}">
                                <input class="form-control" value="${requestScope.order.payment.name}" readonly>
                                <input type="hidden" name="payment" value="12">
                            </c:if>
                            <c:if test="${requestScope.order.payment.id ne 12}">
                                <select name="payment" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                                    <c:forEach items="${requestScope.listP}" var="lp">
                                        <c:if test="${lp.id eq requestScope.order.payment.id}">
                                            <option value="${lp.id}" selected>${lp.name}</option>
                                        </c:if>
                                        <c:if test="${lp.id ne requestScope.order.payment.id}">
                                            <option value="${lp.id}">${lp.name}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </c:if>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label">Fulfillment</label>
                            <c:if test="${requestScope.order.fulfillment.id eq 22}">
                                <input class="form-control" value="${requestScope.order.fulfillment.name}" readonly>
                                <input type="hidden" name="fulfillment" value="22">
                            </c:if>
                            <c:if test="${requestScope.order.fulfillment.id ne 22}">
                                <select name="fulfillment" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                                    <c:forEach items="${requestScope.listF}" var="lf">
                                        <c:if test="${lf.id eq requestScope.order.fulfillment.id}">
                                            <option value="${lf.id}" selected>${lf.name}</option>
                                        </c:if>
                                        <c:if test="${lf.id ne requestScope.order.fulfillment.id}">
                                            <option value="${lf.id}">${lf.name}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </c:if>
                        </div>
                    </div>
                    <div class="row g-3">
                        <div class="col-6">
                            <label class="form-label" readonly>Chanel</label>
                            <input class="form-control" value="${requestScope.order.chanel.name}" readonly>
                        </div>
                        <div class="col-6">
                            <label class="form-label">Time create</label>
                            <input class="form-control" value="${requestScope.order.timeCreate}" readonly>
                        </div>
                    </div>
                    <div class="row g-3">
                        <div class="col-6">
                            <label class="form-label">Carrier</label>
                            <input class="form-control" value="${requestScope.order.carrierId.name}" readonly>
                        </div>
                        <div class="col-6">
                            <label class="form-label">Is COD</label><br>
                            <c:if test="${requestScope.order.isCod eq true}">
                                <input type="radio" name="isCod" value="1" checked> COD
                                <input type="radio" name="isCod" value="0"> Not COD
                            </c:if>
                            <c:if test="${requestScope.order.isCod ne true}">
                                <input type="radio" value="1"> COD
                                <input type="radio" value="0" checked> Not COD
                            </c:if>
                        </div>
                    </div>
                    <div class="row g-3">
                        <div class="col-6">
                            <label class="form-label">List product</label><br>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Product Name</th>
                                        <th scope="col">Price</th>
                                        <th scope="col">Quantity</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.order.products}" var="lp">
                                        <tr>
                                            <td>${lp.name}</td>
                                            <td>${lp.price}</td>
                                            <td>${lp.quantity}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <label class="form-label">Total: ${requestScope.order.total}</label><br>
                        </div>
                        <div class="col-6">
                            <label class="form-label">Description</label>
                            <textarea name="des" class="form-control">${requestScope.order.description}</textarea>
                        </div>
                    </div>
                    <div class="row g-3">
                        <div class="col-12" style="display: flex; justify-content: end">
                            <input type="hidden" value="${requestScope.order.id}" name="oid">
                            <button class="btn btn-primary" type="submit" name="action" value="save">
                                Save
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="../../includes/footer.jsp" %>
<meta charset="utf-8">
