<!DOCTYPE html>


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css_m.css">
    <title>Hasiera</title>
</head>

<body class="grid-container">
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
            <br>
            <h3>APARTEKO ESKAINTZAK!</h3>
            <h4>(%33ko deskontuarekin)</h4><br>
            <div class="aparteko">
                <div class="eskaintza1"><br>
                    <h4>Sony HT-G700</h4>
                    <del>349.95€</del>
                    <p>234.47€ !!!!</p>
                    <img src="../irudiak/produktuak/produktu5.png" alt="" />
                </div>
                <div class="eskaintza2"><br>
                    <h4>Apple Watch Series 7</h4>
                    <del>399.99€</del>
                    <p> 267.99€ !!!!</p>
                    <img src="../irudiak/produktuak/produktu18.png" alt="">
                </div>
                <div id="google_translate_element" class="google"></div>
            </div>

        </div>
    </article>
    <footer class="footer">
        <?php require_once "footer_m.php" ?>
    </footer>



    <script type="text/javascript"
        src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>


    <script type="text/javascript">
        function googleTranslateElementInit() {
            new google.translate.TranslateElement({ pageLanguage: 'es', includedLanguages: 'eu,en,es', layout: google.translate.TranslateElement.InlineLayout.SIMPLE, gaTrack: true }, 'google_translate_element');
        }
    </script>
    <?php
    require_once("karritoa.php")
        ?>
</body>


</html>