<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css_m.css">
    <title>Produktuak</title>
    <style>

    </style>
</head>

<body>
    <div class="grid-container">
        <header class="header">
            <?php require_once "header_m.php" ?>
        </header>
        <nav class="nav">
            <?php require_once "menu.php" ?>
        </nav>
        <article class="main">
            <div class="content">
                <div class="botoia">
                    <div class="cart">
                        <h2>Karrito</h2>
                        <div id="cart-items">
                            <p>Karritoa hutsik dago.</p>
                        </div>
                    </div>
                </div>
                <?php
                require_once("db.php");

                $conn = konexioaSortu();

                if ($conn->connect_error) {
                    die("Konexioa egiterako orduan errore bat egon da: " . $conn->connect_error);
                }

                $sql = "SELECT idProduktua, izena, prezioa, irudia FROM produktua"; // Incluye el ID
                $result = $conn->query($sql);

                if ($result->num_rows > 0) {
                    echo "<div class='produktuak'>";
                    while ($row = $result->fetch_assoc()) {
                        echo "<div class='produktua' data-idProduktua='" . $row["idProduktua"] . "' data-name='" . $row["izena"] . "' data-price='" . $row["prezioa"] . "'>";
                        echo "<h2 class='produktuIzena'>" . $row["izena"] . "</h2>";
                        echo "<p class='produktuPrezioa'>Prezioa: " . $row["prezioa"] . "€</p>";
                        echo "<img src='../irudiak/produktuak/" . $row["irudia"] . "' >";
                        echo "<button class='add-to-cart'>Gehitu karritora</button>";
                        echo "</div>";
                    }
                    echo "</div>";
                } else {
                    echo "Ez dira produktuak geratzen";
                }
                $conn->close();
                ?>
            </div>
        </article>
        <footer class="footer">
            <?php require_once "footer_m.php" ?>
        </footer>
    </div>



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
</body>

</html>
