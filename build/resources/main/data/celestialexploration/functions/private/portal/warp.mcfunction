#say warp
scoreboard players set @s c_e 1000000

tag @s add this
execute if predicate celestialexploration:overworld run function celestialexploration:private/portal/to_dimension
execute unless predicate celestialexploration:overworld run function celestialexploration:private/portal/to_overworld
tag @s remove this