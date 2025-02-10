<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="../../public/css/css.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <title>Zerbitzuak</title>
</head>

<body class="grid-container">
    <header class="header">
        <?php require_once "parts/header.php" ?>
    </header>

    <nav class="nav">

        <?php require_once "parts/menu.php" ?>

    </nav>
    <div class="content">
        <div class="botoia">
            <div class="karritoa2">
                <h2><?= trans("erosketaZestoa") ?></h2>
                <div id="karrito-elementuak">
                    <?= trans("zestoaHutsik") ?>
                </div>
            </div>
        </div>
        <div class="eskainitakoZerbitzuak">
            <table class="garraioZerbitzua">
                <tr>
                    <th><?= trans("garraioZerbitzua") ?></th>
                </tr>
                <tr>
                    <td><?= trans("garraioZerbitzuaText") ?><br><img class="garraioZerbitzuaImg"
                            src="../../public/irudiak/garraioZerbitzua.png">
                    </td>
                </tr>
            </table>



            <table class="bezeroarenArreta">

                <tr>
                    <th><?= trans("bezeroArreta") ?></th>
                </tr>
                <tr>
                    <td><?= trans("bezeroArretaText") ?><br><img class="bezeroarenArretaImg"
                            src="../../public/irudiak/bezeroarenArreta.png">
                    </td>
                </tr>
            </table>

            <table class="paketearenJarraipena">

                <tr>
                    <th><?= trans("paketearenJarraipena") ?></th>
                </tr>

                <tr>
                    <td><?= trans("paketearenJarraipenaText") ?><br><img
                            class="paketearenJarraipenaImg" src="../../public/irudiak/paketeJarraipena.png">
                    </td>
                </tr>
            </table>

        </div>


    </div>
    <?php
    require_once("karritoa.php")
        ?>

    <footer class="footer">
        <?php require_once "parts/footer.php" ?>
    </footer>


</body>

</html>