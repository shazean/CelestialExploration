# Cloud Wolf:
#       This is a list of ways portals can activate based on
#       the block type versus the input score method.

execute if score @s dimp_flsteel matches 1.. if block ~ ~ ~ red_sandstone run tag @s add dimp_activate
execute if score @s dimp_lava matches 1.. if block ~ ~ ~ red_sandstone run tag @s add dimp_activate

execute if score @s dimp_flsteel matches 1.. if block ~ ~ ~ sandstone run tag @s add dimp_activate
execute if score @s dimp_lava matches 1.. if block ~ ~ ~ sandstone run tag @s add dimp_activate

execute if score @s dimp_flsteel matches 1.. if block ~ ~ ~ yellow_terracotta run tag @s add dimp_activate
execute if score @s dimp_lava matches 1.. if block ~ ~ ~ yellow_terracotta run tag @s add dimp_activate

execute if score @s dimp_flsteel matches 1.. if block ~ ~ ~ light_gray_terracotta run tag @s add dimp_activate
execute if score @s dimp_lava matches 1.. if block ~ ~ ~ light_gray_terracotta run tag @s add dimp_activate