<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <link rel="stylesheet" href="../../../public/css/css.css">
</head>

<body>

    <?php
    require_once(APP_DIR . "/src/translation/translations.php"); //APP_DIR erabilita itzulpenen dokumentua atzitu dugu.

    ?>

    <nav class="nabigazioBarra">
        <ul class="nabigazioEstekak">
            <li><a href="index.php"><b><?= trans("hasieraNav") ?></b></a></li>
            <li><a href="produktuak.php"><b><?= trans("produktuakNav") ?></b></a></li>
            <li><a href="kontaktua.php"><b><?= trans("kontaktuaNav") ?></b></a></li>
            <li><a href="zerbitzuak.php"><b><?= trans("zerbitzuakNav") ?></b></a></li>
        </ul>
        <button class="menuBotoia"><strong>☰</strong></button>
    </nav>

    <?php if (isset($_SESSION['erabiltzailea'])) { ?>
        <a class="saioaItxi" href="saioaItxi.php">
            <i class="fa-solid fa-right-from-bracket" id="ikonoa" aria-hidden="true"></i>
        </a>
        <div>
            <a class="erabiltzaileIzena" href="erabiltzailePanela.php">
                <?php echo htmlspecialchars($_SESSION['erabiltzailea']); ?>
            </a>
        </div>
    <?php } ?>

    <a class="right" href="saioHasiera.php">
        <i class="fa fa-user-circle-o" id="ikonoa" aria-hidden="true"></i>
    </a>

    <div class="karritoa">
        <i class="fa fa-shopping-cart" id="ikonoa" aria-hidden="true"></i>
    </div>

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

        const menuToggle = document.querySelector(".menuBotoia");
        const navLinks = document.querySelector(".nabigazioEstekak");

        menuToggle.addEventListener("click", () => {
            navLinks.classList.toggle("active");
        });


    </script>
</body>

</html>