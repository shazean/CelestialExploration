scoreboard players set .check c_e 0
scoreboard players set .failed c_e 0

function celestialexploration:activation
execute unless entity @s[tag=dimp_activate] run scoreboard players set .failed c_e 1
execute if entity @s[tag=dimp_activate] unless entity @e[tag=portal,dx=0] run summon item_frame ~ ~ ~ {ItemRotation:2b,Invulnerable:1b,Invisible:1b,Fixed:1b,Tags:["portal","x","init"],Item:{id:"minecraft:flint_and_steel",Count:1b,tag:{CustomModelData:1}}}
tag @s remove dimp_activate

execute as @e[tag=portal,tag=init] run function celestialexploration:setup_type

scoreboard players set .invalid c_e 0
### prevent alt portals in alt dimensions ###
execute unless predicate celestialexploration:overworld run scoreboard players set .invalid c_e 1
execute as @e[tag=portal,tag=init] run function celestialexploration:dimension_override
execute if score .invalid c_e matches 1 run scoreboard players set .failed c_e 1
execute if score .invalid c_e matches 1 run kill @e[tag=portal,tag=init]

tag @e[tag=portal] remove init