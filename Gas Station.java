/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.

Solution: start at point p. 
        i = p+ step( step <= gas.length). 
        if curGasSum + (gas[i] - cost[i]) < 0: p can't be the starting point,  and p --> i can't be the starting point. 
                    start point should be p + step + 1
        step == gas.length: found the start!
        
        a way to simplify:
        (1)can complete: gasSum >= costSum.  
        (2) at every start point, i>start should have: curGasSum + (gas[i] - cost[i]) > 0.
*/
public int canCompleteCircuit(int[] gas, int[] cost) {

        if(gas==null||cost==null||gas.length==0||cost.length==0||gas.length!=cost.length){
            return -1;
        }
        int totalStep = gas.length;
        int start = 0;
        while (start < gas.length){
            int sum = 0;
            int step = 0;
            for (; step < totalStep; step++){
                int i = (start + step) % gas.length;
                int diff = gas[i] - cost[i];
                sum += diff;
                if (sum < 0){
                    start += step + 1;
                    break;
                }
            }
            if (step == totalStep) return start;
            
        }
        return -1;
}

public int canCompleteCircuit_Simplify(int[] gas, int[] cost) {
    int totalGas = 0;
    int curGas = 0;
    int start = 0;
    for (int i = 0; i < gas.length; i++){
        int diff = gas[i] - cost[i];
        totalGas += diff;
        curGas += diff;
        if (curGas < 0){
            curGas = 0;
            start = i + 1;
        }
    }
    return totalGas >= 0? start: -1;
}
