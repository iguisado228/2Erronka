<!DOCTYPE html>
<html lang="es">

<head>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <link rel="stylesheet" href="css_m.css">
    <style>
        #login-container {
            display: none;
            position: fixed;
            top: 20%;
            left: 35%;
            width: 100%;
            height: 100%;
            align-items: center;
            justify-content: center;
        }
    </style>
</head>



<body>

    <?php

    session_start();


    ?>


    <div class="menu-container">
        <div class="menu-icon">
            <i class="fa fa-bars" aria-hidden="true"></i>
        </div>
        <div class="menu">
            <ul>
                <li><a href="index_m.php">Hasiera</a></li>
                <li><a href="produktuak.php">Produktuak</a></li>
                <li><a href="kontaktua.php">Kontaktua</a></li>
                <li><a href="zerbitzuak.php">Zerbitzuak</a></li>
            </ul>
        </div>
    </div>

    <?php if (isset($_SESSION['erabiltzailea'])) {
        ?>
        <a class="saioaItxi" href="saioaItxi.php"><i class="fa-solid fa-right-from-bracket" id="ikonoa"
        aria-hidden="true"></i></a>
        <div class="erabiltzaileIzena">
            <?php echo htmlspecialchars($_SESSION['erabiltzailea']); ?>

        </div>

        
    <?php } ?>
    <a class="right" href="saioHasiera.php"><i class="fa fa-user-circle-o" id="ikonoa" aria-hidden="true"></i></a>

    <div class="karritoa" id="karritoa">
        <i class="fa fa-shopping-cart" id="ikonoa" aria-hidden="true"></i>
    </div>



    <!-- kontenedore honetan, Saio hasiera kargatuko da -->
    <div id="login-container">
        <div id="login-content"></div>
    </div>

    <script>
        $(document).ready(function () {
            $(".menu-icon").click(function () {
                $(".menu").slideToggle(300);
            });

            $(document).click(function (event) {
                if (!$(event.target).closest(".menu-container").length) {
                    $(".menu").slideUp(300);
                }
            });

            // Saioa hasieraren formularioa kargatuko da logoan click egitean
            $(".right").click(function (event) {
                event.preventDefault();
                $("#login-content").load("saioHasiera.php", function () {
                    $("#login-container").fadeIn();
                });
            });

            // Saio itxieraren lehioa itxiko da kanpoan click egitean edo Xa sakatzean
            $(document).on("click", ".itxi", function (event) {
                event.preventDefault();
                $("#login-container").fadeOut();
            });

            $(document).click(function (event) {
                if (!$(event.target).closest("#login-content").length && !$(event.target).closest(".right").length) {
                    $("#login-container").fadeOut();
                }
            });
        });
    </script>
</body>

</html>