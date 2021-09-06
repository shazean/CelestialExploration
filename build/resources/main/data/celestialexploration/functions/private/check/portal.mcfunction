clone ~ ~ ~ ~ ~ ~ 100 1 112 replace move
scoreboard players set .range c_e 0
scoreboard players set .check c_e 1
scoreboard players set .failed c_e 1

### X basis Portals
execute if score .check c_e matches 1.. positioned ~ ~1 ~ if block ~ ~ ~ #celestialexploration:portal_frames positioned ~ ~ ~ run function celestialexploration:portal_shape_x
execute if score .check c_e matches 1.. positioned ~ ~1 ~ if block ~ ~ ~ #celestialexploration:portal_frames positioned ~-1 ~ ~ run function celestialexploration:portal_shape_x
execute if score .check c_e matches 1.. positioned ~ ~2 ~ if block ~ ~ ~ #celestialexploration:portal_frames positioned ~ ~ ~ run function celestialexploration:portal_shape_x
execute if score .check c_e matches 1.. positioned ~ ~2 ~ if block ~ ~ ~ #celestialexploration:portal_frames positioned ~-1 ~ ~ run function celestialexploration:portal_shape_x
execute if score .check c_e matches 1.. positioned ~ ~-1 ~ if block ~ ~ ~ #celestialexploration:portal_frames positioned ~ ~4 ~ run function celestialexploration:portal_shape_x
execute if score .check c_e matches 1.. positioned ~ ~-1 ~ if block ~ ~ ~ #celestialexploration:portal_frames positioned ~-1 ~4 ~ run function celestialexploration:portal_shape_x

### Z basis Portals
execute if score .check c_e matches 1.. positioned ~ ~1 ~ if block ~ ~ ~ #celestialexploration:portal_frames positioned ~ ~ ~ run function celestialexploration:portal_shape_z
execute if score .check c_e matches 1.. positioned ~ ~1 ~ if block ~ ~ ~ #celestialexploration:portal_frames positioned ~ ~ ~-1 run function celestialexploration:portal_shape_z
execute if score .check c_e matches 1.. positioned ~ ~2 ~ if block ~ ~ ~ #celestialexploration:portal_frames positioned ~ ~ ~ run function celestialexploration:portal_shape_z
execute if score .check c_e matches 1.. positioned ~ ~2 ~ if block ~ ~ ~ #celestialexploration:portal_frames positioned ~ ~ ~-1 run function celestialexploration:portal_shape_z
execute if score .check c_e matches 1.. positioned ~ ~-1 ~ if block ~ ~ ~ #celestialexploration:portal_frames positioned ~ ~4 ~ run function celestialexploration:portal_shape_z
execute if score .check c_e matches 1.. positioned ~ ~-1 ~ if block ~ ~ ~ #celestialexploration:portal_frames positioned ~ ~4 ~-1 run function celestialexploration:portal_shape_z

execute if score .failed c_e matches 1 run clone 100 1 112 100 1 112 ~ ~ ~ replace move