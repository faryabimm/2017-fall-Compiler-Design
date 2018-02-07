import pstats
stats = pstats.Stats("program.prof")
stats.sort_stats("tottime")

stats.print_stats()