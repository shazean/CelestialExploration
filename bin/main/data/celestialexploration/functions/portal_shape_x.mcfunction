# Cloud Wolf:
#       Used to check if there is a portal at this location

execute if block ~ ~ ~ red_sandstone if predicate celestialexploration:mars_portal_x run function celestialexploration:private/check/origin_x

execute if block ~ ~ ~ sandstone if predicate celestialexploration:moon_portal_x run function celestialexploration:private/check/origin_x

execute if block ~ ~ ~ yellow_terracotta if predicate celestialexploration:venus_portal_x run function celestialexploration:private/check/origin_x

execute if block ~ ~ ~ light_gray_terracotta if predicate celestialexploration:mercury_portal_x run function celestialexploration:private/check/origin_x
