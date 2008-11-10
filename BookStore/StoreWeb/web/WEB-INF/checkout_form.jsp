<%--@elvariable id="checkout" type="java.util.Map"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1>Checkout</h1>

<jsp:include page="cart_contents.jsp"/>

<a href="/store/catalogue">Continue shopping</a>

<hr/>
<form action="/store/checkout" method="POST" id="checkout">

    <div id="name_and_address" class="group">
        <h2>Name and address</h2>

        <p>
            <label class="required" for="full_name">Full Name</label>
            <input id="full_name" type="text" name="full_name" value="${checkout.full_name}" size="30"/>
        </p>

        <p>
            <label class="required" for="email">Email</label>
            <input id="email" type="text" name="email" value="${checkout.email}" size="30"/>
        </p>

        <p>
            <label class="required" for="address">Address</label>
            <input id="address" type="text" name="address" value="${checkout.address}" size="40"/>
            <br/>
            <input id="address2" type="text" name="address" value="${checkout.address2}" size="40"/>
        </p>

        <div class="side_by_side">
            <p>
                <label class="required" for="address">Postal Town/City</label>
                <input id="town" type="text" name="town" value="${checkout.town}" size="16"/>
            </p>

            <p>
                <label class="required" for="postcode">Post code</label>
                <input id="postcode" type="text" name="postcode" value="${checkout.postcode}" size="16"/>
            </p>
        </div>

        <p>&nbsp;</p>
    </div>

    <div id="credit_card" class="group">
        <h2>Credit card</h2>

        <p>
            <label class="required" for="address">Number</label>
            <input id="credit_card_number" type="text" name="address" value="${checkout.creditCard.number}"
                   size="20"/>
        </p>

        <div class="side_by_side">
            <p>
                <label class="required" for="address">Security code</label>
                <input id="credit_card_security_code" type="text" name="address"
                       value="${checkout.creditCard.securityCode}" size="3"/>
            </p>

            <p>
                <label class="required" for="address">Expiry (MMYY)</label>
                <input id="credit_card_expiry" type="text" name="address" value="${checkout.creditCard.expiry}"
                       size="3"/>
            </p>
        </div>
        <p>&nbsp;</p>
    </div>
</form>