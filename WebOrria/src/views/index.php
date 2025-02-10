<!DOCTYPE html>


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../public/css/css.css">
    <title>Hasiera</title>
</head>

<body class="gorputza">
    <header class="header">
        <?php require_once "parts/header.php" ?>
    </header>
    <nav class="nav">
        <?php require_once "parts/menu.php" ?>
    </nav>
    <article class="main">
        <div class="content">
            <div class="botoia">
                <div class="karritoa2">
                    <h2><?= trans("erosketaZestoa") ?></h2>
                    <div id="karrito-elementuak">
                        <?= trans("zestoaHutsik") ?>
                    </div>
                </div>
            </div>
            <br>
            <h3><?= trans("apartekoEskaintza") ?></h3>
            <h4><?= trans("deskontua") ?></h4><br>
            <div class="aparteko">
                <div class="eskaintza1"><br>
                    <h4>Sony HT-G700</h4>
                    <del>349.95€</del>
                    <p>234.47€ !!!!</p>
                    <img src="../../public/irudiak/produktuak/produktu5.png" alt="" />
                </div>
                <div class="eskaintza2"><br>
                    <h4>Apple Watch Series 7</h4>
                    <del>399.99€</del>
                    <p> 267.99€ !!!!</p>
                    <img src="../../public/irudiak/produktuak/produktu18.png" alt="">
                </div>
            </div>
            <div class="albisteak">
                <div class="albisteIrudia">
                    <img src="../../public/irudiak/albisteIrudia.jpg">
                </div>
                <div class="izenburua">
                    <h2><?= trans("albisteak") ?></h2>
                </div>
                <div class="titulua">
                    <h1><?= trans("albisteIzenburua") ?></h1>
                </div>
                <div class="albistea">
                    <p>
                        <?= trans("albisteLehenParagrafoa") ?>
                    </p>

                    <p>
                        <?= trans("albisteBigarrenParagrafoa") ?>
                    </p>

                    <p>
                        <?= trans("albisteHirugarrenParagrafoa") ?>
                    </p>

                    <p>
                        <?= trans("albisteLaugarrenParagrafoa") ?>
                    </p>
                </div>
            </div>
        </div>
    </article>
    <footer class="footer">
        <?php require_once "parts/footer.php" ?>
    </footer>
    <?php require_once "karritoa.php" ?>
</body>

</html>