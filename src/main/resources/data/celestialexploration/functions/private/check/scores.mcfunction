scoreboard players set .check c_e 0
 function celestialexploration:score_combine
execute if score .check c_e matches 1.. at @s run function celestialexploration:private/check/to_frame
 function celestialexploration:score_reset

scoreboard players add @s[tag=dim_warp] c_e 1
execute if score @s c_e matches 1.. run scoreboard players reset @s[tag=!dim_warp] c_e
execute if score @s c_e matches 80..100 at @s run function celestialexploration:private/portal/warp
tag @s remove dim_warp