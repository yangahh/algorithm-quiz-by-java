data = input()

zero_group = [x for x in data.split('0') if x != '']
one_group = [x for x in data.split('1') if x != '']

print(min(len(zero_group), len(one_group)))
