# Cloud Wolf:
#       This is to enable portals in alternate dimensions,
#       if not filled out your portal WILL NOT WORK.
#       This is to prevent having a portal to dimension B
#       inside dimension A. (location ambiguity)


execute if entity @s[tag=sand] if predicate celestialexploration:mars_dimension run scoreboard players set .invalid c_e 0
execute if entity @s[tag=moon] if predicate celestialexploration:moon_dimension run scoreboard players set .invalid c_e 0
execute if entity @s[tag=venus] if predicate celestialexploration:venus_dimension run scoreboard players set .invalid c_e 0
execute if entity @s[tag=mercury] if predicate celestialexploration:mercury_dimension run scoreboard players set .invalid c_e 0