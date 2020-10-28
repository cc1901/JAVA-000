# GC summary

## Parallel GC
1. -XX:+UseParallelGC
1. default GC in jdk 8 and 7
1. for high throughput, when do GC stw, parallel GC high efficiency when not do GC not GC thread run parallel with other thread

## CMS GC
1. -XX:+UseConcMarkSweepGC
1. deprecated since jdk 9
> pros:
>  - used for low latency
> cons:
>  - very sensitive to CPU resources
>  - easy generate memory fragmentation, compact cause STW
> 6 stage:
>  1. Initial Mark (STW)
>  1. Concurrent Mark
>  1. Concurrent Preclean
>  1. Final Remark (STW)
>  1. Concurrent Sweep
>  1. Concurrent Reset

## G1 GC
1. -XX:+UseG1GC -XX:+GCTimeRatio -XX:+MaxGCPauseMillis
1. default GC since jdk 9
>pros: Max GC Pause time controllable, better performance for big heap (>4G)
>cons: very sensitive to CPU resources, Total GC pause time will be long
>stages:
> 1. Initial Mark (STW)
> 1. Root Region SCAN
> 1. Concurrent Marking
> 1. Remark (STW)
> 1. Cleanup (small STW and Concurrent)
> 1. Copying (STW)

## ZGC
1. -XX:+UnlockExperimentalVMOptions -XX:+UseZGC
1. added since jdk 11
>pros:
> - Pause times do not exceed 10ms
> - Pause times do not increase with the heap or live-set size,
> - No more than 15% application throughput reduction compared to using G1
> - Handle heap memory, ranging from KBs to a large TB memory
>cons:
> - Only support Linux/x64, support MacOS and Windows after JDK15
> - The initial experimental version of ZGC will not have support for class unloading.