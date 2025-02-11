<?php
function setSessionLanguageToDefault()
{
  $_SESSION["_LANGUAGE"] = "eus";
}

function changeSessionLanguage()
{
  if (isset($_GET["selectedLang"])) {
    $_SESSION["_LANGUAGE"] = $_GET["selectedLang"];
  }
}

if (!isset($_SESSION["_LANGUAGE"])) {
  setSessionLanguageToDefault();
}

changeSessionLanguage();

function trans($indexPhrase)
{
  static $tranlationsArray = array();

  if (file_exists(APP_DIR . '/translations/' . $_SESSION["_LANGUAGE"] . '.php')) {
    $url = APP_DIR . '/translations/';
    $tranlationsArray = include($url . $_SESSION["_LANGUAGE"] . '.php');
  }

  return isset($tranlationsArray[$indexPhrase]) ? $tranlationsArray[$indexPhrase] : $indexPhrase;
}
?>