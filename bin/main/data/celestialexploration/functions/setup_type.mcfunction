# Cloud Wolf:
#       Used to tie a tag to the type of portal it is.
#       Can also alter the portal face (with RP on)

execute if block ~ ~ ~ red_sandstone run tag @s add sand
execute if block ~ ~ ~ red_sandstone run data modify entity @s Item set value {id:"minecraft:flint_and_steel",Count:1b,tag:{CustomModelData:1}}

execute if block ~ ~ ~ sandstone run tag @s add moon
execute if block ~ ~ ~ sandstone run data modify entity @s Item set value {id:"minecraft:flint_and_steel",Count:1b,tag:{CustomModelData:2}}

execute if block ~ ~ ~ yellow_terracotta run tag @s add venus
execute if block ~ ~ ~ yellow_terracotta run data modify entity @s Item set value {id:"minecraft:flint_and_steel",Count:1b,tag:{CustomModelData:3}}

execute if block ~ ~ ~ light_gray_terracotta run tag @s add mercury
execute if block ~ ~ ~ light_gray_terracotta run data modify entity @s Item set value {id:"minecraft:flint_and_steel",Count:1b,tag:{CustomModelData:4}}