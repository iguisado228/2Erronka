<?php
// language.php
// Función para establecer el idioma por defecto
function setSessionLanguageToDefault()
{
  $_SESSION["_LANGUAGE"] = "eus"; // Establecemos 'eus' como idioma por defecto
}

// Función para cambiar el idioma según el parámetro GET
function changeSessionLanguage()
{
  if (isset($_GET["selectedLang"])) {
    $_SESSION["_LANGUAGE"] = $_GET["selectedLang"]; // Actualizamos el idioma en la sesión
  }
}

// Establecer el idioma si aún no se ha guardado en la sesión
if (!isset($_SESSION["_LANGUAGE"])) {
  setSessionLanguageToDefault(); // Establecer 'eus' si no se ha guardado
}

// Cambiar el idioma si es necesario
changeSessionLanguage(); 

// Función para las traducciones
function trans($indexPhrase)
{
  static $tranlationsArray = array();

  // Verificar si el archivo de traducciones existe
  if (file_exists(APP_DIR . '/translations/' . $_SESSION["_LANGUAGE"] . '.php')) {
    $url = APP_DIR . '/translations/';
    // Cargar las traducciones del archivo correspondiente
    $tranlationsArray = include($url . $_SESSION["_LANGUAGE"] . '.php');
  }

  // Devolver la traducción si existe, si no, devolver la frase original
  return isset($tranlationsArray[$indexPhrase]) ? $tranlationsArray[$indexPhrase] : $indexPhrase;
}
?>
