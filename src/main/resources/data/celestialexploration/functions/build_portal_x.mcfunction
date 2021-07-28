# Cloud Wolf:
#       This is to build a portal of specified block type.
#       Copy the 2 lines and change block to your own.

execute if entity @s[tag=sand] run fill ~-1 ~-4 ~ ~2 ~-4 ~ red_sandstone
execute if entity @s[tag=sand] run fill ~-1 ~ ~ ~2 ~-4 ~ red_sandstone

execute if entity @s[tag=moon] run fill ~-1 ~-4 ~ ~2 ~-4 ~ sandstone
execute if entity @s[tag=moon] run fill ~-1 ~ ~ ~2 ~-4 ~ sandstone

execute if entity @s[tag=venus] run fill ~-1 ~-4 ~ ~2 ~-4 ~ yellow_terracotta
execute if entity @s[tag=venus] run fill ~-1 ~ ~ ~2 ~-4 ~ yellow_terracotta

execute if entity @s[tag=mercury] run fill ~-1 ~-4 ~ ~2 ~-4 ~ light_gray_terracotta
execute if entity @s[tag=mercury] run fill ~-1 ~ ~ ~2 ~-4 ~ light_gray_terracotta