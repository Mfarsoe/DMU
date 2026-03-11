<?php
// --- Opgave 3.1 ---
function tagIt($tag, $content) {
    return "<$tag>$content</$tag>";
}

echo "3.1 Test: " . tagIt('b', 'Hello World') . "<br>\n";

// --- Opgave 3.2 ---
function tagIt2($tag, $content) {
    $args = func_get_args();
    $numArgs = func_num_args();
    $attributes = "";

    // Iterate through pairs starting from index 2
    for ($i = 2; $i < $numArgs; $i += 2) {
        $attrName = $args[$i];
        $attrValue = $args[$i + 1];
        $attributes .= " $attrName='$attrValue'";
    }

    return "<$tag$attributes>$content</$tag>";
}

echo "3.2 Test: " . htmlspecialchars(tagIt2('p', 'Hello World', 'class', 'fancy')) . "<br>\n";
echo "3.2 Rendering: " . tagIt2('p', 'Hello World', 'class', 'fancy') . "<br>\n";

// --- Opgave 3.3 ---
function charAt($s, &$i) {
    $char = $s[$i];
    $i++;
    return $char;
}

$a = 6;
$result = charAt('Hello World', $a);
echo "3.3 Test: charAt('Hello World', 6) returnerede '$result'. Ny værdi af \$a er $a.<br>\n";
?>
