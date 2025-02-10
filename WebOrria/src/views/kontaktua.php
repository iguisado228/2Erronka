<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../public/css/css.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <title>Kontaktua</title>
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

        <div class="formularioa">
            <form action="" method="get">
                <h1><?= trans("kontaktatu") ?></h1> <br>

                <label for="izena"><?= trans("izena") ?></label>
                <input type="text" name="izena" id="izena" required> <br> <br>
                <label for="abizena"><?= trans("abizena") ?></label>
                <input type="text" name="abizena" id="abizena"> <br> <br>
                <label for="telefonoa"><?= trans("telefonoa") ?></label>
                <input type="text" name="telefonoa" id="telefonoa" placeholder="+34 6xxxxxxx" required> <br> <br>
                <label for="emaila"><?= trans("emaila") ?></label>
                <input type="email" name="emaila" id="emaila" pattern=".+@.+\..+" required> <br> <br>

                <label for="informazioajaso"><strong><?= trans("informazioaJaso") ?></strong></label> <br> <br>

                <input type="radio" name="informazioajaso" id="telefonozjaso" checked value="telefonoz">
                <label for="informazioajaso"><?= trans("telefonoBi") ?></label> <br>



                <input type="radio" name="informazioajaso" id="emailezjaso" value="emailez">
                <label for="informazioajaso"><?= trans("emailBi") ?></label> <br> <br>

                <label for="errorea"><?= trans("akatsMota") ?></label>
                <select class="arazoa">
                    <option disabled selected><?= trans("arazoa") ?></option>
                    <option value="bueltatu"><?= trans("gailuaBueltatu") ?></option>
                    <option value="konponketa"><?= trans("arazoaKonpondu") ?></option>
                    <option value="bestelakoa"><?= trans("besteArazoBat") ?></option>
                </select> <br> <br>

                <label for="explikazioa"><?= trans("azalduArazoa") ?></label> <br>
                <textarea type="textarea" name="explikazioa" id="explikazioa" class="explikaziokaxa"></textarea>
                <br>
                <br>
                <div class="kontaktatubotoiak">
                    <input type="submit" name="bidali" value="<?= trans("bidali") ?>" class="bidalibotoia">
                    <input type="reset" value="<?= trans("garbitu") ?>" class="ezabatubotoia">
                </div>
            </form>
        </div>


        </table>

    </div>
    <?php
    require_once("karritoa.php")
        ?>

    <footer class="footer">
        <?php require_once "parts/footer.php" ?>
    </footer>

</body>

</html>