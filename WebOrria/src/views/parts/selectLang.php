<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../public/css/css.css">
</head>

<body>
    <?php
    session_start();

    if (!isset($_SESSION["_LANGUAGE"])) {
        $_SESSION["_LANGUAGE"] = "eus";
    }

    $currentLang = $_SESSION["_LANGUAGE"];
    $oppositeLang = ($currentLang === 'eus') ? 'en' : 'eus';
    ?>

    <a href="?selectedLang=<?php echo $oppositeLang; ?>">
        <?php if ($currentLang === 'eus'): ?>
            <img class="hizkuntzaIkonoa" src="../../public/irudiak/uk.png" alt="English" title="Change to English">
        <?php else: ?>
            <img class="hizkuntzaIkonoa" src="../../public/irudiak/ikurrina.png" alt="Euskara" title="Change to Euskara">
        <?php endif; ?>
    </a>

</body>

</html>