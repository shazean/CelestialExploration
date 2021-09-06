# Cloud Wolf:
#       This checks the integrity of the portal, if failed
#       portal will be killed.

execute if entity @s[tag=sand] unless predicate celestialexploration:mars_portal_z run kill @s
execute if entity @s[tag=moon] unless predicate celestialexploration:moon_portal_z run kill @s
execute if entity @s[tag=venus] unless predicate celestialexploration:venus_portal_z run kill @s
execute if entity @s[tag=mercury] unless predicate celestialexploration:mercury_portal_z run kill @s