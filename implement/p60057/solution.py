def solution(s):
    min_len = len(s)  # 8

    for i in range(1, len(s) // 2 + 1):  # 1,2,3,4
        result_str = ''
        repeat = 1
        for start_idx in range(0, len(s), i):  # i==1: 0~7, i==2: 0~6(0,2,4,6),
            a = s[start_idx: start_idx + i]
            b = s[start_idx + i: start_idx + (i * 2)]
            if a == b:
                repeat += 1
            else:
                if repeat == 1:
                    result_str += a
                else:
                    result_str += str(repeat) + a

                repeat = 1  # reset

        if len(result_str) < min_len:
            min_len = len(result_str)

    return min_len


result = solution("aabbaccc")
print(result)  # 7
result = solution("abcabcabcabcdededededede")
print(result)  # 14
