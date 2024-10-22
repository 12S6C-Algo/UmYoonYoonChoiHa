let input = readLine()!.split(separator: " ").map{ Int($0)! }
var array = [Int]()
var getArray = Array(repeating: 0, count: input[1]+1)

for _ in 1...input[0] {
    array.append(Int(readLine()!)!)
}

array += array[0...input[2]-1]

var nowMax = 0
var start = 0
var end = input[2]-1

for i in 0...input[2] - 1{
    if getArray[array[i]] == 0 {
        nowMax += 1
    }

    getArray[array[i]] += 1
}

var resultMax = nowMax

while start < input[0] {
    start += 1
    end += 1

    if getArray[array[start-1]] == 1 {
        nowMax -= 1
    }
    getArray[array[start-1]] -= 1

    if getArray[array[end]] == 0 {
        nowMax += 1
    }
    getArray[array[end]] += 1
    
    if getArray[input[3]] == 0 {
        resultMax = max(resultMax, nowMax + 1)
    } else {
        resultMax = max(resultMax, nowMax)
    }
}

print(resultMax)
