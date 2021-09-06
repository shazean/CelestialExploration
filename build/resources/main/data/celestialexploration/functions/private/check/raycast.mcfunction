scoreboard players remove .range c_e 1
execute if block ~ ~ ~ #celestialexploration:portal_activator run function celestialexploration:private/check/portal
execute if score .range c_e matches 1.. unless block ~ ~ ~ #celestialexploration:portal_activator positioned ^ ^ ^0.25 run function celestialexploration:private/check/raycast