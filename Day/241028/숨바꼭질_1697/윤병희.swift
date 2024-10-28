let input = readLine()!.split(separator: " ").map{ Int($0)! }
let N = input[0]
let K = input[1]

var time = 0

var stack = [N]
var subStack = [Int]()
var map = Array(repeating: false, count: 100001)

while !stack.isEmpty {
    let location = stack.popLast()!
    
    if location == K {
        print(time)
        break
    }
    
    
    if location - 1 >= 0 {
        if !map[location - 1] {
            map[location - 1] = true
            
            if location - 1 == K {
                print(time + 1)
                break
            }
            subStack.append(location - 1)
        }
    }
    
    if location + 1 <= 100000 {
        if !map[location + 1] {
            map[location + 1] = true
            
            if location + 1 == K {
                print(time + 1)
                break
            }
            subStack.append(location + 1)
        }
    }
    
    if location * 2 <= 100000 {
        if !map[location * 2] {
            map[location * 2] = true
            
            if location * 2 == K {
                print(time + 1)
                break
            }
            subStack.append(location * 2)
        }
    }
    
    if stack.isEmpty {
        stack = subStack
        subStack = .init()
        time += 1
    }
}
