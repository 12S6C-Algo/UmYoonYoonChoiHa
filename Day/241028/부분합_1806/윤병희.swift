let input = readLine()!.split(separator: " ").map { Int($0)! }
let N = input[0]
let S = input[1]
var arrays = readLine()!.split(separator: " ").map{ Int($0)! }
var result = 1000001
var sum = 0
var front = 0
var back = 0

while front < N && back < N {
    if arrays[back] + sum < S {
        sum += arrays[back]
        back += 1
    } else {
        if result == 1 {
            result = min(result, back-front+1)
            break
        }
        result = min(result, back-front+1)
        sum -= arrays[front]
        front += 1
    }
    
}
if result == 1000001 {
    print(0)
} else {
    print(result)
}
