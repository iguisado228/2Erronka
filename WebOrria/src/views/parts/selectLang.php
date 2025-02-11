<?php
// Iniciar sesión
session_start();

// Establecer el idioma inicial si no está configurado
if (!isset($_SESSION["_LANGUAGE"])) {
    $_SESSION["_LANGUAGE"] = "eus"; // Por defecto, se establece Euskera
}

// Establecer el idioma actual y el opuesto
$currentLang = $_SESSION["_LANGUAGE"];
$oppositeLang = ($currentLang === 'eus') ? 'en' : 'eus'; // Si está en Euskera, cambiará a Inglés y viceversa
?>

<!-- Enlaces de idiomas con íconos -->
<a href="?selectedLang=<?php echo $oppositeLang; ?>" class="language-icon">
    <?php if ($currentLang === 'eus'): ?>
        <!-- Si el idioma es Euskera, mostrar el ícono de Inglés -->
        <img src="../../public/irudiak/uk.png" alt="English" title="Change to English">
    <?php else: ?>
        <!-- Si el idioma es Inglés, mostrar el ícono de Euskera -->
        <img src="../../public/irudiak/ikurrina.png" alt="Euskara" title="Change to Euskara">
    <?php endif; ?>
</a>
