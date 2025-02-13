<?php
session_start();

if (isset($_GET["selectedLang"]) && $_GET["selectedLang"] != "") {
    $currentLang = $_GET["selectedLang"];
    $oppositeLang = ($currentLang === 'eus') ? 'en' : 'eus';
} else {

    if (!isset($_SESSION["_LANGUAGE"])) {
        $_SESSION["_LANGUAGE"] = "eus";
    }

    $currentLang = $_SESSION["_LANGUAGE"];
    $oppositeLang = ($currentLang === 'eus') ? 'en' : 'eus';

}

?>

<a href="?selectedLang=<?php echo $oppositeLang; ?>">
    <?php if ($currentLang === 'eus'): ?>
        <img class="hizkuntzaIkonoa" src="../../public/irudiak/uk.png" alt="English" title="Change to English">
    <?php else: ?>
        <img class="hizkuntzaIkonoa" src="../../public/irudiak/ikurrina.png" alt="Euskara" title="Change to Euskara">
    <?php endif; ?>
</a>