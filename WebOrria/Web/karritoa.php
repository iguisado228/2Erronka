
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<link rel="stylesheet" href="css_m.css">

<script>
$(document).ready(function () {
    const cart = [];
    const cartElement = document.getElementById("cart-items");

    document.querySelector(".content").addEventListener("click", (event) => {
        if (event.target.classList.contains("add-to-cart")) {
            const productElement = event.target.closest(".produktua");
            const product = {
                id: productElement.dataset.idproduktua,
                name: productElement.dataset.name,
                price: parseFloat(productElement.dataset.price)
            };

            addToCart(product);
        }

        if (event.target.classList.contains("remove-from-cart")) {
            const productId = event.target.dataset.id;
            removeFromCart(productId);
        }
    });

    function addToCart(product) {
        cart.push(product);
        renderCart();
    }

    function removeFromCart(productId) {
        const index = cart.findIndex(item => item.id === productId);
        if (index !== -1) {
            cart.splice(index, 1);
            renderCart();
        }
    }

    function renderCart() {
        if (cart.length === 0) {
            cartElement.innerHTML = "<p>Karritoa hutsik dago.</p>";
            return;
        }

        const cartItems = cart.map(item => `
            <p>
                ${item.name} - ${item.price.toFixed(2)}€ 
                <button class="remove-from-cart" data-id="${item.id}">Kendu</button>
            </p>
        `).join("");

        cartElement.innerHTML = `
            <h3>Produktuak karritoan:</h3>
            ${cartItems}
            <p><strong>Guztira: ${cart.reduce((total, item) => total + item.price, 0).toFixed(2)}€</strong></p>
        `;
        <?php
        
        ?>
    }

    $(".karritoa").click(function () {
        $(".cart").slideToggle(300);
    });

    $(".karritoa").click(function (event) {
        if (!$(event.target).closest(".karritoa").length) {
            $(".cart").slideUp(300);
        }
    });
});
</script>


