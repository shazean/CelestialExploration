# Cloud Wolf:
#       Used to check if there is a portal at this location

execute if block ~ ~ ~ red_sandstone if predicate celestialexploration:mars_portal_z run function celestialexploration:private/check/origin_z

execute if block ~ ~ ~ sandstone if predicate celestialexploration:moon_portal_z run function celestialexploration:private/check/origin_z

execute if block ~ ~ ~ yellow_terracotta if predicate celestialexploration:venus_portal_z run function celestialexploration:private/check/origin_z

execute if block ~ ~ ~ light_gray_terracotta if predicate celestialexploration:mercury_portal_z run function celestialexploration:private/check/origin_z
