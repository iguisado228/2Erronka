<?php
define('APP_DIR', value: $_SERVER['DOCUMENT_ROOT'] . '/2ERRONKA/WebOrria'); //Aplikazioaren karpeta edozein lekutatik atzitzeko.
define('HREF_VIEWS_DIR', '/2ERRONKA/WebOrria/src/views'); //Aplikazioaren views karpeta edozein lekutatik deitzeko
?>

<div class="header">
    <a href="index.php"><img class="logoa" src="../../public/irudiak/ikonoa.png" /></a>
</div>
<div class="header grid-elem">
    <?php require_once(APP_DIR . "/src/views/parts/selectLang.php"); ?>
</div>