data = input()

stack = []
result = 0
for i in range(len(data)):
    if data[i] == '(':
        stack.append('(')
    else:  # case of ')'
        stack.pop()
        if data[i - 1] == '(':  # laser
            result += len(stack)
        else:  # end of a stick
            result += 1

print(result)
